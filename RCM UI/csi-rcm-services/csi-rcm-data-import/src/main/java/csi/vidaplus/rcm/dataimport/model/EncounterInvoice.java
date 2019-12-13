package csi.vidaplus.rcm.dataimport.model;

import java.util.List;

import org.springframework.data.annotation.Transient;

import io.swagger.annotations.ApiModelProperty;

public class EncounterInvoice extends BaseModel {

	@ApiModelProperty("Invoice no for the encounter")
	private String invoiceNo;
	
	@ApiModelProperty("Invoice gross amount for the encounter")
    private Double grossAmount;
    
	@ApiModelProperty("Invoice discount amount for the encounter")
    private Double discount;

	@ApiModelProperty("Invoice net amount for the encounter")
    private Double netAmount;

	@ApiModelProperty("Invoice company share amount for the encounter")
    private Double companyShare;

	@ApiModelProperty("Invoice patient share amount for the encounter")
    private Double patientShare;

	@ApiModelProperty("Activity list for the invoice")
	@Transient
	private List<EncounterActivity> encounterActivities;
	
	@ApiModelProperty(hidden=true)
	private String encounterId;

	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getCompanyShare() {
		return companyShare;
	}

	public void setCompanyShare(Double companyShare) {
		this.companyShare = companyShare;
	}

	public Double getPatientShare() {
		return patientShare;
	}

	public void setPatientShare(Double patientShare) {
		this.patientShare = patientShare;
	}

	/**
	 * @return the encounterActivities
	 */
	public List<EncounterActivity> getEncounterActivities() {
		return encounterActivities;
	}

	/**
	 * @param encounterActivities the encounterActivities to set
	 */
	public void setEncounterActivities(List<EncounterActivity> encounterActivities) {
		this.encounterActivities = encounterActivities;
	}

	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}

	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}



	
	
}
