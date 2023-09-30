package com.Insurance.DiseaseProcedures.Models;

public class DiseaseProcedures {
	int proc_id;
	int proc_disc_id;
	String proc_name;
	String proc_disc_icdcode;

	public DiseaseProcedures() {
	}

	public DiseaseProcedures(int proc_id, int proc_disc_id, String proc_name, String proc_disc_icdcode) {
		super();
		this.proc_id = proc_id;
		this.proc_disc_id = proc_disc_id;
		this.proc_name = proc_name;
		this.proc_disc_icdcode = proc_disc_icdcode;
	}

	public int getProc_id() {
		return proc_id;
	}

	public void setProc_id(int porc_id) {
		this.proc_id = porc_id;
	}

	public int getProc_disc_id() {
		return proc_disc_id;
	}

	public void setProc_disc_id(int proc_disc_id) {
		this.proc_disc_id = proc_disc_id;
	}

	public String getProc_name() {
		return proc_name;
	}

	public void setProc_name(String proc_name) {
		this.proc_name = proc_name;
	}

	public String getProc_disc_icdcode() {
		return proc_disc_icdcode;
	}

	public void setProc_disc_icdcode(String proc_disc_icdcode) {
		this.proc_disc_icdcode = proc_disc_icdcode;
	}

	@Override
	public String toString() {
		return "DiseaseProcedures [proc_id=" + proc_id + ", proc_disc_id=" + proc_disc_id + ", proc_name=" + proc_name
				+ ", proc_disc_icdcode=" + proc_disc_icdcode + "]";
	}
}
