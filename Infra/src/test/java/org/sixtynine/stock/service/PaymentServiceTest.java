package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserService userService;
	
	@After
	public void tearDown() throws Exception {
		Payment payment = createPayment();
		paymentService.deletePayment(payment.getId());;
	}

	@Test
	public void testSavePayment() throws Exception {
		Payment payment = createPayment();
		Payment found = paymentService.findById(payment.getId());
		assertEquals(payment, found);
	}

	private Payment createPayment() {
		Payment payment = new Payment();
		payment.setAcqId("ABC123");
		payment.setAddedDate(new Date());
		payment.setAuthCode("Thi852");
		payment.setUser(userService.findById(1));
		payment.setMerId("ACD528");
		payment.setOrderId("QWDS5H56");
		payment.setPaddedcardNo("4528");
		paymentService.savePayment(payment);		
		return payment;
	}

	@Test
	public void testSearchPayment() throws Exception {
		createPayment();
		List<Payment> payment = paymentService.findPayment(1);
		assertEquals(1, payment.size());
		assertEquals("1", payment.iterator().next().getId());
	}

	@Test
	public void testDeletePayment() throws Exception {
		Payment payment = createPayment();
		assertNotNull(paymentService.findById(payment.getId()));
		paymentService.deletePayment(payment.getId());
		assertNull(paymentService.findById(payment.getId()));
	}

	@Test
	public void testUpdatePayment() throws Exception {
		Payment payment = createPayment();
		Payment payment01 = paymentService.findById(payment.getId());
		assertNotNull(payment01);
		assertEquals(1, payment01.getId());

		payment01.setReasonCode("SIX09");
		paymentService.savePayment(payment01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
