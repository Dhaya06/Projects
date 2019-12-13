package com.csi.vidaplus.rcm.masterdata.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment_mode")
public class Policy extends MasterData{

	@NotNull(message = "Policy number must not be null")
	@NotEmpty(message = "Policy number cannot be empty")
	private String policyNumber;
	
	private String group;
	
	private String company;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
