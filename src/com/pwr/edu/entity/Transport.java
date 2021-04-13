package com.pwr.edu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="transport")
public class Transport {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "transport_id")
	private int transportId;
	@NotNull(message = "is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Column(name = "transport_price")
	private Integer transportPrice;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="type_id")
	private TransportType transportType;

	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="from_city_id")
	private City fromCity = null;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="to_city_id")
	private City toCity = null;
	

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="company_id")
	private Company company;

	
	public Transport() {
	}
	
	
	public Transport(int transportPrice) {
		this.transportPrice = transportPrice;
	}


	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}


	

	public Integer getTransportPrice() {
		return transportPrice;
	}


	public void setTransportPrice(Integer transportPrice) {
		this.transportPrice = transportPrice;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public City getFromCity() {
		return fromCity;
	}


	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}


	public City getToCity() {
		return toCity;
	}


	public void setToCity(City toCity) {
		this.toCity = toCity;
	}

	

	public TransportType getTransportType() {
		return transportType;
	}


	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}


	@Override
	public String toString() {
		return "Transport [transportId=" + transportId + ", transportPrice=" + transportPrice + "]";
	}
	
	
	
	
}
