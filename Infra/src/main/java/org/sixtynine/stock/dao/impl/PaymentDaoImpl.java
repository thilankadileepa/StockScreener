package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.PaymentDao;
import org.sixtynine.stock.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl extends AbstractDaoImpl<Payment, Integer> implements
		PaymentDao {

	protected PaymentDaoImpl() {
		super(Payment.class);
	}

	@Override
	public void savePayment(Payment payment) {
		saveOrUpdate(payment);
	}

	@Override
	public List<Payment> findPayment(int orderId) {
		return findByCriteria(Restrictions.eq("orderId", orderId));
	}

}
