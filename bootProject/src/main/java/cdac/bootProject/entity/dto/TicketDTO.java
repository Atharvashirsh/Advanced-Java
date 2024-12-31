package cdac.bootProject.entity.dto;

import java.util.Date;

import cdac.bootProject.entity.enums.TicketCategory;
import cdac.bootProject.entity.enums.TicketStatus;

public class TicketDTO {

	Integer id;

	String phoneNum;

	TicketCategory category;

	TicketStatus status;

	String issueDetails;

	String resolutionDetails;

	Date createdAt;

	Date resolvedAt;

	public TicketDTO() {
	}

	public TicketDTO(Integer id, String phoneNum, TicketCategory category, TicketStatus status, String issueDetails,
			String resolutionDetails, Date createdAt, Date resolvedAt) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.category = category;
		this.status = status;
		this.issueDetails = issueDetails;
		this.resolutionDetails = resolutionDetails;
		this.createdAt = createdAt;
		this.resolvedAt = resolvedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public TicketCategory getCategory() {
		return category;
	}

	public void setCategory(TicketCategory category) {
		this.category = category;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getResolutionDetails() {
		return resolutionDetails;
	}

	public void setResolutionDetails(String resolutionDetails) {
		this.resolutionDetails = resolutionDetails;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getResolvedAt() {
		return resolvedAt;
	}

	public void setResolvedAt(Date resolvedAt) {
		this.resolvedAt = resolvedAt;
	}
	
	

}
