package com.Insurance.DiseaseProcedures.Daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Insurance.DiseaseProcedures.Contractor.DiseaseProceduresDao;
import com.Insurance.DiseaseProcedures.Models.DiseaseDetails;
import com.Insurance.DiseaseProcedures.Models.DiseaseProcedures;
import com.Insurance.DiseaseProcedures.RowMappers.DiseaseDetailsRowMapper;
import com.Insurance.DiseaseProcedures.RowMappers.DiseaseProceduresRowMapper;

@Component
public class DiseaseProceduresDaoImpl implements DiseaseProceduresDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired(required = true)
	public DiseaseProceduresDaoImpl(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String GET_DISEASE_DETAILS = "Select * from diseases";
	String GET_PROCEDURES_BY_DIS_ID = "Select * from proceduress where proc_disc_id=?";

	@Override
	public List<DiseaseDetails> getDiseases() {
		return jdbcTemplate.query(GET_DISEASE_DETAILS, new DiseaseDetailsRowMapper());

	}

	@Override
	public List<DiseaseProcedures> getProceduresByDisId(int diseaseId) {
		return jdbcTemplate.query(GET_PROCEDURES_BY_DIS_ID, new Object[] { diseaseId }, new DiseaseProceduresRowMapper());
	}
}