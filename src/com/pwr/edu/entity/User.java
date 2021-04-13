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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name ="users")
public class User {


	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "first_name")
	@Pattern(regexp="^[A-Z]([a-zA-Z ])*$", message = "Invalid")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "last_name")
	@Pattern(regexp="^[A-Z]([a-zA-Z ])*$", message = "Invalid")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "pass")
//	Password must contain at least one digit [0-9].
//	Password must contain at least one lowercase Latin character [a-z].
//	Password must contain at least one uppercase Latin character [A-Z].
//	Password must contain at least one special character like ! @ # & ( ).
//	Password must contain a length of at least 8 characters and a maximum of 20 characters.
	@Pattern(message="	Password must contain at least one digit [0-9].\r\n"
			+ "	Password must contain at least one lowercase Latin character [a-z].\r\n"
			+ "	Password must contain at least one uppercase Latin character [A-Z].\r\n"
			+ "	Password must contain at least one special character like ! @ # & ( ).\r\n"
			+ "	Password must contain a length of at least 8 characters and a maximum of 20 characters.", regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	private String pass;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter the valid email")
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "user_type")
    private int userType;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Travel> travels;
	
	public User() {
	}
	
	public User(String firstName, String lastName, String pass, String emial, int userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pass = pass;
		this.email = emial;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emial) {
		this.email = emial;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", pass=" + pass
				+ ", emial=" + email + ", userType=" + userType + "]";
	}
	
	public void addTravel(Travel theTravel) {
		
		if(travels ==null) {
			travels = new ArrayList<>();
		}
		travels.add(theTravel);
	}

	public void removeTravel(int theId) {
		
		for(int i=0; i<travels.size(); i++) {
			if(travels.get(i).getTravelId() == theId) {
				travels.remove(i);
			}
		}
		
	}
	
	
}
