package com.olp.service.impl;

import com.olp.entity.*;

import com.olp.enums.Status;
import com.olp.repository.*;
import com.olp.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final RazorpayClient client;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public PaymentServiceImpl(@Value("${razorpay.key_id}") String keyId,
                          @Value("${razorpay.key_secret}") String keySecret,
                          PaymentRepository paymentRepository,
                          UserRepository userRepository,
                          CourseRepository courseRepository,
                          EnrollmentRepository enrollmentRepository) throws Exception {
        this.client = new RazorpayClient(keyId, keySecret);
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    // ✅ Create Razorpay Order and save in DB
    public Payment createOrder(Long userId, Long courseId, int amount, String currency) throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", amount * 100);
        options.put("currency", currency);
        options.put("receipt", "order_rcpt_" + System.currentTimeMillis());

        Order order = client.orders.create(options);

        User user = userRepository.findById(userId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        Payment payment = new Payment();
        payment.setRazorpayOrderId(order.get("id"));
        payment.setStatus(Status.SUCCESS);
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setUser(user);
        payment.setCourse(course);


        return paymentRepository.save(payment);
    }

    //  Verify & confirm payment → enroll student
    public String confirmPayment(String orderId, String paymentId) {
        Payment payment = paymentRepository.findAll()
                .stream().filter(p -> p.getRazorpayOrderId().equals(orderId))
                .findFirst().orElseThrow();

        payment.setRazorpayPaymentId(paymentId);
        payment.setStatus(Status.SUCCESS);
        paymentRepository.save(payment);

        // auto-enroll
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(payment.getUser());
        enrollment.setCourse(payment.getCourse());
        enrollment.setStatus("ENROLLED");
        enrollmentRepository.save(enrollment);

        return "Payment successful & enrollment created!";
    }
}
