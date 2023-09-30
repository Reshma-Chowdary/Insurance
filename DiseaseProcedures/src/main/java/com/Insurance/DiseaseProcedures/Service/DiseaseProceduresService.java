package com.Insurance.DiseaseProcedures.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.DiseaseProcedures.Contractor.DiseaseProceduresDao;
import com.Insurance.DiseaseProcedures.Models.DiseaseDetails;
import com.Insurance.DiseaseProcedures.Models.DiseaseProcedures;

@Service
public class DiseaseProceduresService {
	@Autowired(required = true)
	DiseaseProceduresDao procedureDao;

	public List<DiseaseDetails> getDiseases() {
		return procedureDao.getDiseases();
	}

	public List<DiseaseProcedures> getProceduresByDisId(int diseaseId) {
		return procedureDao.getProceduresByDisId(diseaseId);
	}
}