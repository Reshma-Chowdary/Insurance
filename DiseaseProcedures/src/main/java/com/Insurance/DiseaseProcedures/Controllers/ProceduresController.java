package com.Insurance.DiseaseProcedures.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Insurance.DiseaseProcedures.Models.DiseaseDetails;
import com.Insurance.DiseaseProcedures.Models.DiseaseProcedures;
import com.Insurance.DiseaseProcedures.Service.DiseaseProceduresService;

@Controller
public class ProceduresController {

	@Autowired(required = true)
	DiseaseProceduresService disc;

	@GetMapping(value = "/diseases")
	public String getDiseases(Model model) {
		List<DiseaseDetails> diseases = disc.getDiseases();
		System.out.println("jhjhjh");
		// int insId = inspId;
		// model.addAttribute("inspId", insId);
		model.addAttribute("diseases", diseases);
		return "diseaseDetails";
	}

	@GetMapping(value = "/procedures/{diseaseId}")
	public String getProceduresByDisId(@PathVariable String diseaseId, Model model) {
		System.out.println("jhjhjh");
		List<DiseaseProcedures> procedures = disc.getProceduresByDisId(Integer.parseInt(diseaseId));
		System.out.println("jhjhjh");
		System.out.println(procedures);
		model.addAttribute("procedures", procedures);
		return "diseaseProcedures";
	}
}