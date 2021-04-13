package com.pwr.edu.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwr.edu.dao.UserDAO;
import com.pwr.edu.entity.City;
import com.pwr.edu.entity.Company;
import com.pwr.edu.entity.Country;
import com.pwr.edu.entity.Hotel;
import com.pwr.edu.entity.Transport;
import com.pwr.edu.entity.TransportType;
import com.pwr.edu.entity.Travel;
import com.pwr.edu.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<Hotel> getHotels() {
		
		return userDAO.getHotels();
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public List<Country> getCountries() {
		
		return userDAO.getCountries();
	}

	@Override
	@Transactional
	public void saveCountry(@Valid Country theCountry) {
		userDAO.saveCountry(theCountry);
		
	}

	@Override
	@Transactional
	public Country getCountry(int theId) {
		
		return userDAO.getCountry(theId);
	}

	@Override
	@Transactional
	public void deleteCountry(int theId) {
		userDAO.deleteCountry(theId);
		
	}

	@Override
	@Transactional
	public List<City> getCities() {
		
		return userDAO.getCities();
	}

	@Override
	@Transactional
	public void saveCity(@Valid City theCity) {
		userDAO.saveCity(theCity);
		
	}

	@Override
	@Transactional
	public City getCity(int theId) {
		
		return userDAO.getCity(theId);
	}

	@Override
	@Transactional
	public void deleteCity(int theId) {
		userDAO.deleteCity(theId);
		
	}

	@Override
	@Transactional
	public List<Company> getCompanies() {
		return userDAO.getCompanies();
	}

	@Override
	@Transactional
	public void saveHotel(Hotel theHotel) {
		userDAO.saveHotel(theHotel);
		
	}

	@Override
	@Transactional
	public Hotel getHotel(int theId) {
		return userDAO.getHotel(theId);
	}

	@Override
	@Transactional
	public void deleteHotel(int theId) {
		userDAO.deleteHotel(theId);
		
	}

	@Override
	@Transactional
	public List<Transport> getTransports() {
		
		return userDAO.getTransports();
	}

	@Override
	@Transactional
	public List<TransportType> getTransportTypes() {
		return userDAO.getTransportTypes();
	}

	@Override
	@Transactional
	public TransportType getTransportType(int theId) {
		
		return userDAO.getTransportType(theId);
	}

	@Override
	@Transactional
	public Company getCompany(int theId) {
		
		return userDAO.getCompany(theId);
	}

	@Override
	@Transactional
	public void saveTransport(Transport theTransport) {
		userDAO.saveTransport(theTransport);
		
	}

	@Override
	@Transactional
	public Transport getTransport(int theId) {
		
		return userDAO.getTransport(theId);
	}

	@Override
	@Transactional
	public void deleteTransport(int theId) {
		userDAO.deleteTransport(theId);
		
	}

	@Override
	@Transactional
	public void saveTransportType(@Valid TransportType theTransportType) {
		userDAO.saveTransportType(theTransportType);
		
	}

	@Override
	@Transactional
	public void deleteTransportType(int theId) {
		userDAO.deleteTransportType(theId);
		
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
		
	}

	@Override
	@Transactional
	public List<Travel> getTravels() {
		
		return userDAO.getTravels();
	}

	@Override
	@Transactional
	public void deleteTravel(int theId) {
		userDAO.deleteTravel(theId);
		
	}

	@Override
	@Transactional
	public void saveTravel(Travel theTravel) {
		userDAO.saveTravel(theTravel);
		
	}

	@Override
	@Transactional
	public void saveCompany(Company theCompany) {
		userDAO.saveCompany(theCompany);
		
	}

	@Override
	@Transactional
	public void deleteCompany(int theId) {
		userDAO.deleteCompany(theId);
		
	}

	@Override
	@Transactional
	public List<Travel> searchTravels(String theSearchName, int theUserId) {
		
		return userDAO.searchTravels(theSearchName, theUserId);
	}


	
	
}
