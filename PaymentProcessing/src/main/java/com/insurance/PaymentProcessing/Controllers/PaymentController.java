package com.insurance.PaymentProcessing.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.PaymentProcessing.Models.Claims;
import com.insurance.PaymentProcessing.Repositories.ClaimDaoImpl;

@Controller
public class PaymentController {

	@Autowired
	ClaimDaoImpl cdao;

	@GetMapping("/claims")
	public String getApprovedClaims(Model model) {
		List<Claims> claims = cdao.getApprovedClaims();
		model.addAttribute("claims", claims);
		return "claimsList";
	}

	@GetMapping("/settlement/{claimId}")
	public String getSettlementPage(@PathVariable int claimId, Model model) {
		Claims claim = cdao.getClaimById(claimId);

		if (claim == null) {
			return "claimNotFound";
		}
		model.addAttribute("claim", claim);
		return "Settlements";
	}

	@PostMapping("/confirm-process")
	public String confirmProcess(@RequestParam int claim_id) {
		System.out.println(claim_id + "hjh");
		cdao.updatePayStatus(claim_id);
		cdao.addPayment(claim_id);
		return "success"; // Redirect to the claims page after processing
	}
}
