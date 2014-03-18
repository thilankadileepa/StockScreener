package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.Payment;

public interface PaymentService {

	Payment findById(int id);

	void savePayment(Payment payment);

	void deletePayment(int id);

	List<Payment> findPayment(int userId);
}
