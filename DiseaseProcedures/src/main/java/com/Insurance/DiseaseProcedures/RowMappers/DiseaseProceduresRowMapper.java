package com.Insurance.DiseaseProcedures.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Insurance.DiseaseProcedures.Models.DiseaseProcedures;

public class DiseaseProceduresRowMapper implements RowMapper<DiseaseProcedures> {

	@Override
	public DiseaseProcedures mapRow(ResultSet rs, int rowNum) throws SQLException {

		DiseaseProcedures discProcedure = new DiseaseProcedures();
		discProcedure.setProc_id(rs.getInt(1));
		discProcedure.setProc_disc_id(rs.getInt(2));
		discProcedure.setProc_name(rs.getString(3));
		discProcedure.setProc_disc_icdcode(rs.getString(4));
		return discProcedure;
	}

}