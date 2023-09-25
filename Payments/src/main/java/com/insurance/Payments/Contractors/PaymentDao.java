package com.insurance.Payments.Contractors;

import java.util.List;

import com.insurance.Payments.Models.Payments;

public interface PaymentDao {
	List<Payments> getPayments();

	
	Payments getPaymentById(String paymentId);
}
