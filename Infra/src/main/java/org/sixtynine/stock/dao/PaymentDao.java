package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.Payment;

public interface PaymentDao extends AbstractDao<Payment, Integer> {

	void savePayment(Payment payment);

	List<Payment> findPayment(int orderId);
}
