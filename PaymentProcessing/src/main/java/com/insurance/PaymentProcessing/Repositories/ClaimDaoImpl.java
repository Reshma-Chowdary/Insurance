package com.insurance.PaymentProcessing.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insurance.PaymentProcessing.Contractors.ClaimDao;
import com.insurance.PaymentProcessing.Models.Claims;
import com.insurance.PaymentProcessing.RowMappers.ClaimsMapper;

@Repository
public class ClaimDaoImpl implements ClaimDao {
	String Get_Claims = "SELECT * FROM claims WHERE clam_status = 'APPR'";
	String Get_Claim_By_Id = "SELECT * FROM claims WHERE clam_id = ?";
	String Put_Pay_Status = "UPDATE claims SET pay_status = 'Paid' WHERE clam_id = ?";
	String Add_Payment = "INSERT INTO Settlements (tran_id,  payment_Processed_date, claim_id, tran_amnt) "
			+ "SELECT t.tran_id, t.tran_date, c.clam_id, c.clam_processed_amount " + "FROM Transactionss t "
			+ "JOIN Claims c ON t.claim_id = c.clam_id " + "WHERE c.clam_id = ?";

	JdbcTemplate jdbc;

	@Autowired
	public ClaimDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Claims> getApprovedClaims() {
		return jdbc.query(Get_Claims, new ClaimsMapper());
	}

	@Override
	public Claims getClaimById(int claimId) {
		return jdbc.queryForObject(Get_Claim_By_Id, new Object[] { claimId }, new ClaimsMapper());
	}

	@Override
	public void updatePayStatus(int claim_id) {
		jdbc.update(Put_Pay_Status, new Object[] { claim_id });

	}

	@Override
	public void addPayment(int claim_id) {
		jdbc.update(Add_Payment, claim_id);
	}

}
