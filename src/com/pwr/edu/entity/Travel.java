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
import javax.validation.constraints.Pattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.concurrent.TimeUnit;




@Entity
@Table(name ="travels")
public class Travel {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "travel_id")
	private int travelId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="hotel_id")
	private Hotel hotel;

	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="user_id")
	private User user;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name ="transport_id")
	private Transport transport;
	
	@NotNull(message = "is required")
	@Column(name = "date_from")
	@Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Valid format: mm/dd/yyyy")
	private String dateFrom;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Valid format: mm/dd/yyyy")
	@Column(name = "date_till")
	private String dateTill;
	
	@NotNull(message = "is required")
	@Min(value=1, message="must be greater than or equal to one")
	@Column(name = "number_of_persons")
	private Integer numberOfPersons;
	
	@Column(name = "food")
	private Integer food;
	
	@Column(name = "travel_name")
	private String travelName = null;
	
	
	
	
	
	
	public Travel() {
		
	}
	
	public Travel(  String dateFrom, String dateTill, Integer numberOfPersons,
			int food, String travelName) {
	
		
		this.dateFrom = dateFrom;
		this.dateTill = dateTill;
		this.numberOfPersons = numberOfPersons;
		this.food = food;
		this.travelName = travelName;
	}

	public int calculateWholeTravelPrice() {
		  
	    Date startDate = null;
	    Date endDate = null;
		try {
			startDate = new SimpleDateFormat("mm/dd/yyyy").parse(dateFrom);
			endDate = new SimpleDateFormat("mm/dd/yyyy").parse(dateTill); 
		} catch (ParseException e) {
			
			e.printStackTrace();
		}  

	    long diff = endDate.getTime() - startDate.getTime();
	    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

		int price = (int) ( hotel.getHotelPrice() *  days * numberOfPersons + food 
				+ transport.getTransportPrice())  ;
		return price;
	}
	
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}



	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTill() {
		return dateTill;
	}

	public void setDateTill(String dateTill) {
		this.dateTill = dateTill;
	}

	public Integer getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(Integer numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getTravelName() {
		return travelName;
	}
	public void setTravelName(String travelName) {
		
		this.travelName = travelName;
		
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	public Integer getFood() {
		return food;
	}

	public void setFood(Integer food) {
		this.food = food;
	}



	@Override
	public String toString() {
		return "Travel [dateFrom=" + dateFrom + ", dateTill=" + dateTill + ", numberOfPersons=" + numberOfPersons
				+ ", food=" + food + ", travelName=" + travelName + "]";
	}

	
	
	
	
	
}
