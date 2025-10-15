package com.olp.controller;

import com.olp.entity.Payment;
import com.olp.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/olp/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    // Step 1: Create Order
    @PostMapping("/create-order")
    public ResponseEntity<Payment> createOrder(
            @RequestParam Long userId,
            @RequestParam Long courseId,
            @RequestParam int amount,
            @RequestParam(defaultValue = "INR") String currency) {
        try {
            return ResponseEntity.ok(paymentService.createOrder(userId, courseId, amount, currency));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Step 2: Confirm Payment
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(
            @RequestParam String orderId,
            @RequestParam String paymentId) {
        return ResponseEntity.ok(paymentService.confirmPayment(orderId, paymentId));
    }
}
