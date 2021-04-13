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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int hotelId;
	
	@NotNull(message = "is required")
	@Column(name = "hotel_name")
	@Pattern(regexp="^[A-Z]([a-zA-Z ])*$", message = "Invalid")
	private String hotelName;
	
	@NotNull(message = "is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Column(name = "hotel_price")
	private Double hotelPrice;
	
	@NotNull(message = "is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	@Column(name = "rating")
	private Integer rating;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="city_id")
	private City city;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="company_id")
	private Company company;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Travel> travels;
	
	
	public Hotel() {
	}
	
	public Hotel(String hotelName, double hotelPrice, int rating) {
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.rating = rating;
	}

	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public Double getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(Double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelPrice=" + hotelPrice + ", rating="
				+ rating + "]";
	}

	public void addTravel(Travel theTravel) {
		
		if(travels == null) {
			travels = new ArrayList<>();
		}
		travels.add(theTravel);
	}
	
}
