/**
 * 
 */
package com.digitexx.ancestry.bean;

/**
 * @author lqnhu
 * 
 */
public class DigiSoftManagement 
{
	private long id;
	private int capture_status;
	private int qc_status;
	private int ancestry_update_status;
	private long ances_mana_id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the capture_status
	 */
	public int getCapture_status() {
		return capture_status;
	}

	/**
	 * @param capture_status
	 *            the capture_status to set
	 */
	public void setCapture_status(int capture_status) {
		this.capture_status = capture_status;
	}

	/**
	 * @return the qc_status
	 */
	public int getQc_status() {
		return qc_status;
	}

	/**
	 * @param qc_status
	 *            the qc_status to set
	 */
	public void setQc_status(int qc_status) {
		this.qc_status = qc_status;
	}

	/**
	 * @return the ancestry_update_status
	 */
	public int getAncestry_update_status() {
		return ancestry_update_status;
	}

	/**
	 * @param ancestry_update_status
	 *            the ancestry_update_status to set
	 */
	public void setAncestry_update_status(int ancestry_update_status) {
		this.ancestry_update_status = ancestry_update_status;
	}

	/**
	 * @return the ances_mana_id
	 */
	public long getAnces_mana_id() {
		return ances_mana_id;
	}

	/**
	 * @param ances_mana_id the ances_mana_id to set
	 */
	public void setAnces_mana_id(long ances_mana_id) {
		this.ances_mana_id = ances_mana_id;
	}
	
	

}
