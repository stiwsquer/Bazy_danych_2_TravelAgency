package com.pwr.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.pwr.edu.entity.City;
import com.pwr.edu.entity.Company;
import com.pwr.edu.entity.Country;
import com.pwr.edu.entity.Hotel;
import com.pwr.edu.entity.Transport;
import com.pwr.edu.entity.TransportType;
import com.pwr.edu.entity.Travel;
import com.pwr.edu.entity.User;

public interface UserService {

	public List<Hotel> getHotels();

	public List<User> getUsers();

	public void saveUser(User theUser);

	public List<Country> getCountries();

	public void saveCountry(@Valid Country theCountry);

	public Country getCountry(int theId);

	public void deleteCountry(int theId);

	public List<City> getCities();

	public void saveCity(@Valid City theCity);

	public City getCity(int theId);

	public void deleteCity(int theId);

	public List<Company> getCompanies();

	public void saveHotel(Hotel theHotel);

	public Hotel getHotel(int theId);

	public void deleteHotel(int theId);

	public List<Transport> getTransports();

	public List<TransportType> getTransportTypes();

	public TransportType getTransportType(int theId);

	public Company getCompany(int theId);

	public void saveTransport(Transport theTransport);

	public Transport getTransport(int theId);

	public void deleteTransport(int theId);

	public void saveTransportType(@Valid TransportType theTransportType);

	public void deleteTransportType(int theId);

	public void deleteUser(int theId);

	public List<Travel> getTravels();

	public void deleteTravel(int theId);

	public void saveTravel(Travel theTravel);

	public void saveCompany(Company theCompany);

	public void deleteCompany(int theId);

	public List<Travel> searchTravels(String theSearchName, int theUserId);


}
