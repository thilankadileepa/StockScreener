package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.PaymentDao;
import org.sixtynine.stock.entity.Payment;
import org.sixtynine.stock.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public Payment findById(int id) {
		return paymentDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void savePayment(Payment payment) {
		paymentDao.savePayment(payment);
	}

	@Override
	@Transactional(readOnly = false)
	public void deletePayment(int id) {
		Payment payment = paymentDao.findById(id);
		if (payment != null) {
			paymentDao.delete(payment);
		}
	}

	@Override
	public List<Payment> findPayment(int orderId) {
		return paymentDao.findPayment(orderId);
	}

}
