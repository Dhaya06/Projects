package csi.vidaplus.rcm.dataimport.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class BaseModel implements Serializable {

	@ApiModelProperty("System generated value. This value should be use for all future operations for this encounter.")
	@Id
	private String id;
	
	@ApiModelProperty("External HIS referenceNo.")
	private String referenceNo;// 
	
	@ApiModelProperty(hidden=true)
	private Boolean processed = Boolean.FALSE;
	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	@CreatedDate
	private Date createdDate;
	
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	@LastModifiedDate
	private Date lastModifiedDate;
	
	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
}
