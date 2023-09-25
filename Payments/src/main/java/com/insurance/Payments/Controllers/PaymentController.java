package com.insurance.Payments.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Payments.Models.Payments;
import com.insurance.Payments.Repositories.PaymentDaoImpl;

@Controller
public class PaymentController {

	@Autowired
	PaymentDaoImpl pdao;
	
	@GetMapping("/payments")
    public String displayPayments(Model model) {
        List<Payments> payments = pdao.getPayments();
        model.addAttribute("payments", payments);
        return "index";
    }
	
	@GetMapping("/view/{paymentId}")
	public String viewPayment(@PathVariable String paymentId, Model model) {
	    Payments payment = pdao.getPaymentById(paymentId);
	    model.addAttribute("payment", payment);
	    return "paymentDetails"; 
	}

}
