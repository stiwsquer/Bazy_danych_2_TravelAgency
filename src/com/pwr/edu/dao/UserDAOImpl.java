package com.pwr.edu.dao;

import java.util.List;


import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pwr.edu.entity.City;
import com.pwr.edu.entity.Company;
import com.pwr.edu.entity.Country;
import com.pwr.edu.entity.Hotel;
import com.pwr.edu.entity.Transport;
import com.pwr.edu.entity.TransportType;
import com.pwr.edu.entity.Travel;
import com.pwr.edu.entity.User;
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Hotel> getHotels() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Hotel> theQuery = currentSession.createQuery("from Hotel", Hotel.class);
		
		List<Hotel> theHotels = theQuery.getResultList();
		
		return theHotels;
	}

	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		List<User> theUsers = theQuery.getResultList();
		
		return theUsers;
	}

	@Override
	public void saveUser(User theUser) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save/update  
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public List<Country> getCountries() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Country> theQuery = currentSession.createQuery("from Country", Country.class);
		
		List<Country> theCountries = theQuery.getResultList();
		
		return theCountries;
	}

	@Override
	public void saveCountry(@Valid Country theCountry) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//save/update the country 
		currentSession.saveOrUpdate(theCountry);
	}

	@Override
	public Country getCountry(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//now retrieve/read form database using the primary key	
		Country theCountry = currentSession.get(Country.class, theId);
				
		return theCountry;
	}

	@Override
	public void deleteCountry(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Country where id=:countryId");
				
		theQuery.setParameter("countryId", theId);
				
		theQuery.executeUpdate();
		
	}

	@Override
	public List<City> getCities() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<City> theQuery = currentSession.createQuery("from City", City.class);
		
		List<City> theCities = theQuery.getResultList();
		
		return theCities;
	}

	@Override
	public void saveCity(@Valid City theCity) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
								
		//save/update the country 
		currentSession.saveOrUpdate(theCity);
		
	}

	@Override
	public City getCity(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//now retrieve/read form database using the primary key	
		City theCity = currentSession.get(City.class, theId);
						
		return theCity;
	}

	@Override
	public void deleteCity(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from City where id=:cityId");
						
		theQuery.setParameter("cityId", theId);
						
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Company> getCompanies() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Company> theQuery = currentSession.createQuery("from Company", Company.class);
		
		List<Company> theCompanies = theQuery.getResultList();
		
		return theCompanies;
	}

	@Override
	public void saveHotel(Hotel theHotel) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
										
		//save/update the country 
		currentSession.saveOrUpdate(theHotel);
				
	}

	@Override
	public Hotel getHotel(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//now retrieve/read form database using the primary key	
		Hotel theHotel = currentSession.get(Hotel.class, theId);
						
		return theHotel;
	}

	@Override
	public void deleteHotel(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Hotel where id=:hotelId");
								
		theQuery.setParameter("hotelId", theId);
								
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Transport> getTransports() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Transport> theQuery = currentSession.createQuery("from Transport", Transport.class);
		
		List<Transport> theTransports = theQuery.getResultList();
		
		return theTransports;
	}

	@Override
	public List<TransportType> getTransportTypes() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<TransportType> theQuery = currentSession.createQuery("from TransportType", TransportType.class);
		
		List<TransportType> theTransportTypes = theQuery.getResultList();
		
		return theTransportTypes;
	}

	@Override
	public TransportType getTransportType(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
								
		//now retrieve/read form database using the primary key	
		TransportType theTransportType = currentSession.get(TransportType.class, theId);
								
		return theTransportType;
			
	}

	@Override
	public Company getCompany(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
										
		//now retrieve/read form database using the primary key	
		Company theCompany = currentSession.get(Company.class, theId);
						
		return theCompany;
	}

	@Override
	public void saveTransport(Transport theTransport) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
												
		//save/update the country 
		currentSession.saveOrUpdate(theTransport);
	}

	@Override
	public Transport getTransport(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
										
		//now retrieve/read form database using the primary key	
		Transport theTransport = currentSession.get(Transport.class, theId);
						
		return theTransport;
	}

	@Override
	public void deleteTransport(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Transport where id=:TransportId");
								
		theQuery.setParameter("TransportId", theId);
								
		theQuery.executeUpdate();
		
	}

	@Override
	public void saveTransportType(@Valid TransportType theTransportType) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
														
		//save/update the country 
		currentSession.saveOrUpdate(theTransportType);
		
	}

	@Override
	public void deleteTransportType(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from TransportType where id=:TransportTypeId");
								
		theQuery.setParameter("TransportTypeId", theId);
								
		theQuery.executeUpdate();
		
		
	}

	@Override
	public void deleteUser(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from User where id=:userId");
								
		theQuery.setParameter("userId", theId);
								
		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<Travel> getTravels() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Travel> theQuery = currentSession.createQuery("from Travel", Travel.class);
		
		List<Travel> theTravels = theQuery.getResultList();
		
		return theTravels;
	}

	@Override
	public void deleteTravel(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Travel where id=:travelId");
										
		theQuery.setParameter("travelId", theId);
										
		theQuery.executeUpdate();
		
	}

	@Override
	public void saveTravel(Travel theTravel) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
																
		//save/update the country 
		currentSession.saveOrUpdate(theTravel);
				
		
	}

	@Override
	public void saveCompany(Company theCompany) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
																		
		//save/update the country 
		currentSession.saveOrUpdate(theCompany);
	}

	@Override
	public void deleteCompany(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Company where id=:companyId");
								
		theQuery.setParameter("companyId", theId);
								
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Travel> searchTravels(String theSearchName, int theUserId) {
		
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for travel name - case insensitive
            theQuery = currentSession.createQuery("from Travel where lower(travelName) like :theName and user_id=:userId", Travel.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
            theQuery.setParameter("userId", theUserId);

        }
        else {
            // theSearchName is empty so just get all travels
            theQuery =currentSession.createQuery("from Travel where user_id=:userId", Travel.class);         
            theQuery.setParameter("userId", theUserId);
        }
        
        // execute query and get result list
        List<Travel> travels = theQuery.getResultList();
                
        // return the results        
        return travels;
		
	}
	
}
