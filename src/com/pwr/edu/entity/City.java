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

import org.hibernate.validator.constraints.UniqueElements;



@Entity
@Table(name ="cities")
public class City {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	
	@NotNull(message = "is required")
	@Column(name = "city_name", unique=true)
	@Pattern(regexp="^[A-Z]([a-zA-Z ])*$", message = "Invalid")
	private String cityName;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="country_id")
	private Country country;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
	private List<Hotel> hotels;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fromCity", cascade = CascadeType.ALL)
	private List<Transport> fromCityTransports;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "toCity", cascade = CascadeType.ALL)
	private List<Transport> toCityTransports;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Company> companies;
	
	public City() {
	}

	public City(String cityName) {
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	public void addCompany(Company theCompany) {
		
		if(companies ==null) {
			companies = new ArrayList<>();
		}
		companies.add(theCompany);
	}

	public void addFromCityTransport(Transport theTransport) {
		
		if(fromCityTransports ==null) {
			fromCityTransports = new ArrayList<>();
		}
		fromCityTransports.add(theTransport);
	}
	
	public void addToCityTransport(Transport theTransport) {
		
		if(toCityTransports ==null) {
			toCityTransports = new ArrayList<>();
		}
		toCityTransports.add(theTransport);
	}
}
