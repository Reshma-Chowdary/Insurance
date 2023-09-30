package com.Insurance.DiseaseProcedures.Contractor;

import java.util.List;

import com.Insurance.DiseaseProcedures.Models.DiseaseDetails;
import com.Insurance.DiseaseProcedures.Models.DiseaseProcedures;

public interface DiseaseProceduresDao {
	List<DiseaseDetails> getDiseases();

	List<DiseaseProcedures> getProceduresByDisId(int diseaseId);
}