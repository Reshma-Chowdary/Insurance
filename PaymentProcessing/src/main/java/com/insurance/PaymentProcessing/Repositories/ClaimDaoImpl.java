package com.insurance.PaymentProcessing.Repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insurance.PaymentProcessing.Contractors.ClaimDao;
import com.insurance.PaymentProcessing.Models.Claims;
import com.insurance.PaymentProcessing.Models.Settlements;
import com.insurance.PaymentProcessing.RowMappers.ClaimsMapper;
import com.insurance.PaymentProcessing.RowMappers.SettlementsMapper;

@Repository
public class ClaimDaoImpl implements ClaimDao {
	String Get_Claims = "SELECT * FROM claims WHERE clam_status = 'APPR'";
	String Get_Claim_By_Id = "SELECT * FROM claims WHERE clam_id = ?";
	String Put_Pay_Status = "UPDATE claims SET pay_status = 'Paid' WHERE clam_id = ?";
	String Add_Payment = "INSERT INTO Settlements (tran_id,  payment_Processed_date, claim_id, tran_amnt) "
			+ "SELECT t.tran_id, t.tran_date, c.clam_id, c.clam_processed_amount " + "FROM Transactionss t "
			+ "JOIN Claims c ON t.claim_id = c.clam_id " + "WHERE c.clam_id = ?";
	String Get_Processed_Payments = "SELECT * FROM Settlements";

	JdbcTemplate jdbc;

	@Autowired
	public ClaimDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Claims> getApprovedClaims() {
		return jdbc.query(Get_Claims, new ClaimsMapper());
	}

	@SuppressWarnings("deprecation")
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

	public void addTransaction(int claim_id, String transId) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(new Date());
		Date utilDate = dateFormat.parse(formattedDate);

		String stmt = "INSERT INTO Transactionss (tran_id, tran_date, claim_id) VALUES (?, ?, ?)";
		jdbc.update(stmt, transId, utilDate, claim_id);
	}

	@Override
	public List<Settlements> getProcessedPayments() {
		return jdbc.query(Get_Processed_Payments, new SettlementsMapper());
	}

}