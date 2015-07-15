package com.digitexx.ancestry.bean;

import java.sql.Timestamp;
import java.util.Calendar;

public class TimeKeeping {
	
	private Timestamp session_start;
	private Timestamp session_end;
	private Timestamp working_time_start;
	private Timestamp working_time_end;
	
	public void setSession_start(Timestamp session_start) {
		this.session_start = session_start;
	}
	public Timestamp getSession_start() {
		return session_start;
	}
	
	public void setSession_end(Timestamp session_end) {
		this.session_end = session_end;
	}
	
	public Timestamp getSession_end() {
		return session_end;
	}
	
	public void setWorking_time_start(Timestamp working_time_start) {
		this.working_time_start = working_time_start;
	}
	public Timestamp getWorking_time_start() {
		return working_time_start;
	}
	
	public void setWorking_time_end(Timestamp working_time_end) {
		this.working_time_end = working_time_end;
	}
	public Timestamp getWorking_time_end() {
		return working_time_end;
	}
	
	/**
	 * get current time and put to session time start
	 */
	public void startSesion() {
		this.session_start = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	/**
	 * get current time and put to session time end
	 */
	public void endSesion() {
		this.session_end = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	/**
	 * get current time and put to working time start
	 */
	public void startWorkingTime() {
		this.working_time_start = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	/**
	 * get current time and put to working time end
	 */
	public void endWorkingTime() {
		this.working_time_end = new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	/** 
	 * get total session time in second
	 */
	public float getTotalSessionTime() {
		if(this.session_start == null || this.session_end == null) return 0;
		final float session_total = ( session_end.getTime() - session_start.getTime()) / (float) 1000 ;
		return session_total;
	}
	
	/** 
	 * get total working time in second
	 */
	public float getTotalWorkingTime() {
		if(this.working_time_start == null || this.working_time_end == null) return 0;
		final float working_time_total = (this.working_time_end.getTime() - this.working_time_start.getTime()) / (float) 1000;
		return working_time_total;
	}
}
