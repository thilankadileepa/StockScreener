package org.sixtynine.stock.entity;

/**
 * @author Thilan
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

	private int id;
	private String merId;
	private String acqId;
	private String orderId;
	private String responseCode;
	private String reasonCode;
	private String reasonCodeDesc;
	private String referenceNo;
	private String paddedcardNo;
	private String authCode;
	private String shiptotofirstname;
	private String signature;
	private String signaturemethod;
	private Date addedDate;
	
	private User user;

	public Payment(){
		
	}
	
	public Payment(int orderId){
		
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "MER_ID", nullable = false, length = 100)
	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	@Column(name = "ACQ_ID", nullable = false, length = 100)
	public String getAcqId() {
		return acqId;
	}

	public void setAcqId(String acqId) {
		this.acqId = acqId;
	}

	@Column(name = "ORDER_ID", nullable = false, length = 100)
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "RESPONSE_CODE", nullable = false, length = 100)
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Column(name = "REASON_CODE", nullable = false, length = 100)
	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Column(name = "REASON_CODE_DESC", nullable = false, length = 100)
	public String getReasonCodeDesc() {
		return reasonCodeDesc;
	}

	public void setReasonCodeDesc(String reasonCodeDesc) {
		this.reasonCodeDesc = reasonCodeDesc;
	}

	@Column(name = "REFERENCE_NO", nullable = false, length = 100)
	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Column(name = "PADDEDCARD_NO", nullable = false, length = 100)
	public String getPaddedcardNo() {
		return paddedcardNo;
	}

	public void setPaddedcardNo(String paddedcardNo) {
		this.paddedcardNo = paddedcardNo;
	}

	@Column(name = "AUTH_CODE", nullable = false, length = 100)
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Column(name = "SHIPTOTOFIRSTNAME", nullable = false, length = 100)
	public String getShiptotofirstname() {
		return shiptotofirstname;
	}

	public void setShiptotofirstname(String shiptotofirstname) {
		this.shiptotofirstname = shiptotofirstname;
	}

	@Column(name = "SIGNATURE", nullable = false, length = 100)
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "SIGNATUREMETHOD", nullable = false, length = 100)
	public String getSignaturemethod() {
		return signaturemethod;
	}

	public void setSignaturemethod(String signaturemethod) {
		this.signaturemethod = signaturemethod;
	}

	@Column(name = "ADDED_DATE", nullable = false, length = 100)
	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@ManyToOne  
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
