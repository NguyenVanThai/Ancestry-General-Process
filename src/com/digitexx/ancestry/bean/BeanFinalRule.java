package com.digitexx.ancestry.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BeanFinalRule implements Serializable {

	private int id;
	private String ruleNote;
	private String ruleName;
	private String condition;
	private String ruleField;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the ruleNote
	 */
	public String getRuleNote() {
		return ruleNote;
	}

	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @return the ruleField
	 */
	public String getRuleField() {
		return ruleField;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param ruleNote
	 *            the ruleNote to set
	 */
	public void setRuleNote(String ruleNote) {
		this.ruleNote = ruleNote;
	}

	/**
	 * @param ruleName
	 *            the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @param ruleField
	 *            the ruleField to set
	 */
	public void setRuleField(String ruleField) {
		this.ruleField = ruleField;
	}

	@Override
	public String toString() {
		return ruleNote;
	}

}
