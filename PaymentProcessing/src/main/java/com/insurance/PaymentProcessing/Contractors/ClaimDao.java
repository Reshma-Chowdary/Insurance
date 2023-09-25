package com.insurance.PaymentProcessing.Contractors;

import java.util.List;

import com.insurance.PaymentProcessing.Models.Claims;

public interface ClaimDao {

	List<Claims> getApprovedClaims();

	Claims getClaimById(int claimId);

	void updatePayStatus(int claim_id);

	void addPayment(int claim_id);

}
