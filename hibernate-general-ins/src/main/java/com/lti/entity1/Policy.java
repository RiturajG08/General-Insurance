package com.lti.entity1;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="policy_tbl")
public class Policy {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="policy_type")
	private String type;
	
	private char renewal;
	
	@Column(name="policy_start_date")
	private LocalDate policyStartDate;
	
	@Column(name="policy_end_date")
	private LocalDate policyEndDate;
	
	private String provider;
	private int Premium;
	private int idv;
	
	@Column(name="remaining_claim_amount")
	private int remainingClaimAmount;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@OneToMany(cascade= CascadeType.ALL , mappedBy= "policy")
	private List<Claim> claims;

	@OneToOne
	@JoinColumn(name="depreciation_id")
	private Depreciation depreciation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getRenewal() {
		return renewal;
	}

	public void setRenewal(char renewal) {
		this.renewal = renewal;
	}

	public LocalDate getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(LocalDate policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public LocalDate getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(LocalDate policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getPremium() {
		return Premium;
	}

	public void setPremium(int premium) {
		Premium = premium;
	}

	public int getIdv() {
		return idv;
	}

	public void setIdv(int idv) {
		this.idv = idv;
	}

	public int getRemainingClaimAmount() {
		return remainingClaimAmount;
	}

	public void setRemainingClaimAmount(int remainingClaimAmount) {
		this.remainingClaimAmount = remainingClaimAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Depreciation getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(Depreciation depreciation) {
		this.depreciation = depreciation;
	}
	
}
