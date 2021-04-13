package com.pwr.edu.entity;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="transport_types")
public class TransportType {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private int transportTypeId;
	@NotNull(message = "is required")
	@Column(name = "transport_name")
	private String transportTypeName;
	

	
	
	public TransportType() {
	}

	public TransportType(String transportTypeName) {
		this.transportTypeName = transportTypeName;
	}

	public int getTransportTypeId() {
		return transportTypeId;
	}

	public void setTransportTypeId(int transportTypeId) {
		this.transportTypeId = transportTypeId;
	}

	public String getTransportTypeName() {
		return transportTypeName;
	}

	public void setTransportTypeName(String transportTypeName) {
		this.transportTypeName = transportTypeName;
	}

	@Override
	public String toString() {
		return "TransportType [transportTypeId=" + transportTypeId + ", transportTypeName=" + transportTypeName + "]";
	}
	
	
	
}
