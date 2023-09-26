package com.insurance.PaymentProcessing.Controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.PaymentProcessing.Models.Claims;
import com.insurance.PaymentProcessing.Models.Settlements;
import com.insurance.PaymentProcessing.Repositories.ClaimDaoImpl;

@Controller
public class PaymentController {

	@Autowired
	ClaimDaoImpl cdao;

	@GetMapping("/claims")
	public String getApprovedClaims(Model model) {
		List<Claims> claims = cdao.getApprovedClaims();
		List<Settlements> stmts = cdao.getProcessedPayments();
		model.addAttribute("claims", claims);
		model.addAttribute("settlements", stmts);
		return "SettlementsPage";
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

	@RequestMapping(value = "/makePayment", method = RequestMethod.GET)
	public String confirmProcess(@RequestParam Integer claim_id, String transId) throws ParseException {
		cdao.addTransaction(claim_id, transId);
		cdao.updatePayStatus(claim_id);
		cdao.addPayment(claim_id);
		return "redirect:/claims"; // Redirect to the claims page after processing
	}
}