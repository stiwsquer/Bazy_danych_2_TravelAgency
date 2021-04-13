package com.pwr.edu.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="companies")
public class Company {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private int companyId;
	
	@NotNull(message = "is required")
	@Column(name = "full_name")
	private String fullName;
	@NotNull(message = "is required")
	@Column(name = "short_name")
	private String shortName;
	@NotNull(message = "is required")
	@Column(name = "email")
	private String email;
	@NotNull(message = "is required")
	@Column(name = "phone_1")
	private String phone1;
	@NotNull(message = "is required")
	@Column(name = "phone_2")
	private String phone2;
	@NotNull(message = "is required")
	@Column(name = "NIP")
	private String nip;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Hotel> hotels;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="city_id")
	private City city;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
	private List<Transport> transports;
	
	
	public Company() {
	}
	
	public Company(int cityId, String fullName, String shortName, String email, String phone1, String phone2,
			String nip) {
		
		this.fullName= fullName;
		this.shortName = shortName;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.nip = nip;
	}

	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}

	
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
	public List<Transport> getTransports() {
		return transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", full_name=" + fullName + ", short_name=" + shortName
				+ ", email=" + email + ", phone1=" + phone1 + ", phone2=" + phone2 + ", nip=" + nip + "]";
	}

	public void addHotel(Hotel theHotel) {
		
		if(hotels ==null) {
			hotels = new ArrayList<>();
		}
		hotels.add(theHotel);
	}
	
	public void addTransport(Transport theTransport) {
		
		if(transports ==null) {
			transports = new ArrayList<>();
		}
		transports.add(theTransport);
	}
	
	
	
}
