package com.Insurance.DiseaseProcedures.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Insurance.DiseaseProcedures.Models.DiseaseDetails;

public class DiseaseDetailsRowMapper implements RowMapper<DiseaseDetails> {

	@Override
	public DiseaseDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		DiseaseDetails dd = new DiseaseDetails();
		dd.setDiseaseId(rs.getInt(1));
		dd.setDiseaseName(rs.getString(2));
		dd.setIcdCode(rs.getString(3));
		dd.setDiseaseDiscription(rs.getString(4));
		dd.setDiseaseStatus(rs.getString(5));

		return dd;
	}

}