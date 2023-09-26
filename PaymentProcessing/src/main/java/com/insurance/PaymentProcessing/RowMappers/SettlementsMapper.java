package com.insurance.PaymentProcessing.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.PaymentProcessing.Models.Settlements;

public class SettlementsMapper implements RowMapper<Settlements> {

	@Override
	public Settlements mapRow(ResultSet rs, int rowNum) throws SQLException {
		Settlements stmt = new Settlements();
		stmt.setStmt_id(rs.getInt(1));
		stmt.setTran_id(rs.getString(2));
		stmt.setPayment_Processed_date(rs.getDate(3));
		stmt.setClaim_id(rs.getInt(4));
		stmt.setTran_amnt(rs.getDouble(5));
		return stmt;
	}

}
