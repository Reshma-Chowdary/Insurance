package com.insurance.Payments.Repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.insurance.Payments.Contractors.PaymentDao;
import com.insurance.Payments.Models.Payments;
import com.insurance.Payments.RowMappers.PaymentMapper;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	String Get_Payment = "select * from Payments";
	String Get_PaymentById ="select * from Payments where paymentid=?";
	JdbcTemplate jdbc;

	@Autowired
    public PaymentDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}



	@Override
    public List<Payments> getPayments() {
        return jdbc.query(Get_Payment, new PaymentMapper());
    }

	@Override
    public Payments getPaymentById(String paymentId) {
        return jdbc.queryForObject(Get_PaymentById, new Object[] { paymentId }, new PaymentMapper());
    }


}
