package com.olp.service;

import com.olp.entity.Payment;

public interface PaymentService {
	 public Payment createOrder(Long userId, Long courseId, int amount, String currency) throws Exception;	
	 public String confirmPayment(String orderId, String paymentId);

}
