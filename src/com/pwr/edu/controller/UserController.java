package com.pwr.edu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pwr.edu.entity.City;
import com.pwr.edu.entity.Company;
import com.pwr.edu.entity.Country;
import com.pwr.edu.entity.Hotel;
import com.pwr.edu.entity.Transport;
import com.pwr.edu.entity.TransportType;
import com.pwr.edu.entity.Travel;
import com.pwr.edu.entity.User;
import com.pwr.edu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// need to inject our service
	@Autowired
	private UserService userService;

	User activeUser = null;

	City tempCity = null;

	Hotel tempHotel = null;

	Transport tempTransport = null;

	Travel tempTravel = null;

	Company tempCompany = null;

	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue foru our validation
	
	 @InitBinder public void initBinder(WebDataBinder dataBinder) {
		 
		 StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	  
		 dataBinder.registerCustomEditor(String.class, stringTrimmerEditor); 
	 }
	 

	@GetMapping("/login")
	public String logIn(Model theModel) {

		//String regex = "^(";
		//String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
		//for (String string : countries) {
		//	regex+=string;
		//	regex+="|";
		//}
		//regex += ")$";
		
		//System.out.println(regex);
		
		theModel.addAttribute("user", new User());
		
		return "log-in-page";
	}

	@PostMapping("/processLogInForm")
	public String processLogInForm(@ModelAttribute("user") User theUser) {

		List<User> theUsers = userService.getUsers();

		for (int i = 0; i < theUsers.size(); i++) {
			User u = theUsers.get(i);
			if (u.getEmail().equals(theUser.getEmail()) && u.getPass().equals(theUser.getPass())) {
				activeUser = u;
				if (u.getUserType() == 1)
					return "redirect:/user/userHomePage";
				if (u.getUserType() == 2 || u.getUserType() == 3)
					return "redirect:/user/employeeHomePage";
			}
		}

		return "redirect:/user/login";
	}

	@GetMapping("/signInForm")
	public String signInForm(Model theModel) {

		theModel.addAttribute("user", new User());

		return "sign-in-form";
	}

	@PostMapping("/processSignInForm")
	public String processSignInForm(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "sign-in-form";
		} else {
			theUser.setUserType(1);

			try {
				// save the user using our service
				userService.saveUser(theUser);
			}catch(org.hibernate.exception.ConstraintViolationException e) {
				return "redirect:/user/signInForm";
			}
			

			return "redirect:/user/login";
		}

	}

	@GetMapping("/userHomePage")
	public String userHomePage(Model theModel) {

		if (activeUser == null) {
			List<User> theUsers = userService.getUsers();
			activeUser = theUsers.get(1);
		}
		List<Travel> theTravels = activeUser.getTravels();

		theModel.addAttribute("travels", theTravels);

		return "user-home-page";
	}

	@GetMapping("/logOut")
	public String logOut() {
		activeUser = null;
		return "redirect:/user/login";
	}

	@GetMapping("/updateUserDataForm")
	public String updateUserDataForm(Model theModel) {

		theModel.addAttribute("user", activeUser);
		return "update-user-form";
	}

	@PostMapping("/processUpdateUserDataForm")
	public String processUpdateUserDataForm(@Valid @ModelAttribute("user") User theUser,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "update-user-form";
		} else {

			// save the user using our service
			userService.saveUser(theUser);

			return "redirect:/user/userHomePage";
		}

	}

	@GetMapping("/searchForTravel")
	public String searchForTransport(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		List<Travel> theTravels = userService.searchTravels(theSearchName, activeUser.getUserId());

		theModel.addAttribute("travels", theTravels);

		return "user-home-page";
	}

	@GetMapping("/addTravelFormOne")
	public String addTravelForm(Model theModel) {

		Travel theTravel = new Travel();

		LinkedHashMap<Integer, String> theFoodOptions = new LinkedHashMap<Integer, String>();
		theFoodOptions.put(200, "Yes");
		theFoodOptions.put(0, "No");

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("travel", theTravel);
		attributes.put("foodOptions", theFoodOptions);

		theModel.addAllAttributes(attributes);

		return "add-travel-form-one";
	}

	@RequestMapping("/processAddTravelFormOne")
	public String processAddTravelForm(@Valid @ModelAttribute("travel") Travel theTravel,
			BindingResult theBindingResult, Model theModel) {

		if (theBindingResult.hasErrors()) {
			LinkedHashMap<Integer, String> theFoodOptions = new LinkedHashMap<Integer, String>();
			theFoodOptions.put(200, "Yes");
			theFoodOptions.put(0, "No");

			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("travel", theTravel);
			attributes.put("foodOptions", theFoodOptions);

			theModel.addAllAttributes(attributes);
			return "add-travel-form-one";
		} else {
			tempTravel = theTravel;
			List<City> theCities = userService.getCities();
			theModel.addAttribute("cities", theCities);
			return "add-travel-form-two";
		}

	}

	@RequestMapping("/processAddTravelFormTwo")
	public String processAddTravelFormTwo(@ModelAttribute("cityId") int theId, Model theModel) {

		City theCity = userService.getCity(theId);

		tempCity = theCity;

		tempTravel.setTravelName(theCity.getCityName());

		List<City> theCities = userService.getCities();

		theModel.addAttribute("cities", theCities);

		return "add-travel-form-three";
	}

	@RequestMapping("/processAddTravelFormThree")
	public String processAddTravelFormThree(@ModelAttribute("cityId") int theId, Model theModel) {

		City theCity = userService.getCity(theId);

		String name = tempTravel.getTravelName();

		name += " - ";
		name += theCity.getCityName();
		tempTravel.setTravelName(name);

		List<Hotel> theHotels = userService.getHotels();
		List<Hotel> theHotelsOptions = new ArrayList<Hotel>();
		for (int i = 0; i < theHotels.size(); i++) {
			if (theHotels.get(i).getCity().getCityId() == theId) {
				theHotelsOptions.add(theHotels.get(i));
			}
		}

		List<Transport> theTransports = userService.getTransports();
		LinkedHashMap<Transport, Transport> theTransportsOptions = new LinkedHashMap<Transport, Transport>();
		for (int i = 0; i < theTransports.size(); i++) {
			if (theTransports.get(i).getFromCity().getCityId() == tempCity.getCityId()
					&& theTransports.get(i).getToCity().getCityId() == theId) {
				theTransportsOptions.put(theTransports.get(i), theTransports.get(i));
			}
		}

		theModel.addAttribute("hotels", theHotelsOptions);

		return "add-travel-form-four";

	}

	@RequestMapping("/processAddTravelFormFour")
	public String processAddTravelFormFour(@ModelAttribute("hotelId") int theId, Model theModel) {

		Hotel theHotel = userService.getHotel(theId);

		tempTravel.setHotel(theHotel);

		List<Transport> theTransports = userService.getTransports();
		List<Transport> theTransportsOptions = new ArrayList<Transport>();
		for (int i = 0; i < theTransports.size(); i++) {
			if (theTransports.get(i).getFromCity().getCityId() == tempCity.getCityId()
					&& theTransports.get(i).getToCity().getCityId() == theHotel.getCity().getCityId()) {
				theTransportsOptions.add(theTransports.get(i));
			}
		}

		theModel.addAttribute("transports", theTransportsOptions);

		return "add-travel-form-five";

	}

	@RequestMapping("/processAddTravelFormFive")
	public String processAddTravelFormFive(@ModelAttribute("transportId") int theId) {

		Transport theTransport = userService.getTransport(theId);

		tempTravel.setTransport(theTransport);

		tempTravel.setUser(activeUser);
		activeUser.addTravel(tempTravel);

		userService.saveTravel(tempTravel);

		tempTravel = null;
		tempCity = null;

		return "redirect:/user/userHomePage";

	}

	@GetMapping("/deleteUsersTravel")
	public String deleteUsersTravel(@RequestParam("travelId") int theId) {

		userService.deleteTravel(theId);
		activeUser.removeTravel(theId);

		return "redirect:/user/userHomePage";
	}

	@GetMapping("/employeeHomePage")
	public String employeeHomePage(Model theModel) {

		return "employee-home-page";
	}

	@GetMapping("/viewCountriesPage")
	public String viewCountriesPage(Model theModel) {

		List<Country> theCountries = userService.getCountries();

		theModel.addAttribute("countries", theCountries);

		return "view-countries-page";
	}

	@GetMapping("/addCountryForm")
	public String addCountryForm(Model theModel) {

		theModel.addAttribute("country", new Country());

		return "add-country-form";
	}

	@PostMapping("/processAddCountryForm")
	public String processAddCountryForm(@Valid @ModelAttribute("country") Country theCountry,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "add-country-form";
		} else {
			
			try {
				// save the country using our service
				userService.saveCountry(theCountry);
			}catch(org.hibernate.exception.ConstraintViolationException e) {
				return "redirect:/user/addCountryForm";
			}
			

			return "redirect:/user/viewCountriesPage";
		}

	}

	@GetMapping("/updateCountryForm")
	public String updateCountryForm(@RequestParam("countryId") int theId, Model theModel) {

		// get the customer from our service
		Country theCountry = userService.getCountry(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("country", theCountry);

		// send over to our form
		return "add-country-form";
	}

	@GetMapping("/deleteCountry")
	public String deleteCountry(@RequestParam("countryId") int theId) {

		// delete the couontry
		userService.deleteCountry(theId);

		return "redirect:/user/viewCountriesPage";
	}

	@GetMapping("/viewCitiesPage")
	public String viewCitiesPage(Model theModel) {

		List<City> theCities = userService.getCities();

		theModel.addAttribute("cities", theCities);

		return "view-cities-page";
	}

	@GetMapping("/addCityFormOne")
	public String addCityFormOne(Model theModel) {

		List<Country> theCountries = userService.getCountries();

		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("city", new City());
		attributes.put("countries", theCountries);

		theModel.addAllAttributes(attributes);

		return "add-city-form-one";
	}

	@RequestMapping("/processAddCityFormOne")
	public String processAddCityFormOne(@Valid @ModelAttribute("city") City theCity, BindingResult theBindingResult,
			Model theModel) {
		
		
			if (theBindingResult.hasErrors()) {
				return "add-city-form-one";
			} else {
				
				List<City> theCities = userService.getCities();
				for (City city : theCities) {
					if(theCity.getCityName().equals(city.getCityName())) {
						return "add-city-form-one";
					}
				}
				tempCity = theCity;
				List<Country> theCountries = userService.getCountries();
				theModel.addAttribute("countries", theCountries);

				return "add-city-form-two";
			}
		
	}

	@RequestMapping("/processAddCityFormTwo")
	public String processAddCityFormTwo(@ModelAttribute("countryId") int theId) {

		System.out.println("Selected Id: " + theId);

		// find selected country and add it to the city
		List<Country> theCountries = userService.getCountries();
		for (int i = 0; i < theCountries.size(); i++) {
			if (theCountries.get(i).getCountryId() == theId) {
				tempCity.setCountry(theCountries.get(i));
				break;
			}
		}
		
		try {
			// save the city using our service
			userService.saveCity(tempCity);
		}catch(org.hibernate.exception.ConstraintViolationException e) {
		
			tempCity = null;
			return "redirect:/user/viewCitiesPage";
		}
		
		tempCity = null;

		return "redirect:/user/viewCitiesPage";

	}

	@GetMapping("/updateCityForm")
	public String updateCityForm(@RequestParam("cityId") int theId, Model theModel) {

		// get the customer from our service
		City theCity = userService.getCity(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("city", theCity);

		// send over to our form
		return "add-city-form-one";
	}

	@GetMapping("/deleteCity")
	public String deleteCity(@RequestParam("cityId") int theId) {

		// delete the city
		userService.deleteCity(theId);

		return "redirect:/user/viewCitiesPage";
	}

	@GetMapping("/viewHotelsPage")
	public String viewHotelsPage(Model theModel) {

		List<Hotel> theHotels = userService.getHotels();

		theModel.addAttribute("hotels", theHotels);

		return "view-hotels-page";
	}

	@GetMapping("/addHotelFormOne")
	public String addHotelFormOne(Model theModel) {

		theModel.addAttribute("hotel", new Hotel());

		return "add-hotel-form-one";
	}

	@RequestMapping("/processAddHotelFormOne")
	public String processAddHotelFormOne(@Valid @ModelAttribute("hotel") Hotel theHotel, BindingResult theBindingResult,
			Model theModel) {

		if (theBindingResult.hasErrors()) {
			return "add-hotel-form-one";
		} else {
			tempHotel = theHotel;
			List<City> theCities = userService.getCities();
			theModel.addAttribute("cities", theCities);

			return "add-hotel-form-two";
		}

	}

	@RequestMapping("/processAddHotelFormTwo")
	public String processAddHotelFormTwo(@Valid @ModelAttribute("cityId") int theId, Model theModel) {

		System.out.println("Selected Id: " + theId);

		// find selected city and add it to the hotel
		List<City> theCities = userService.getCities();
		for (int i = 0; i < theCities.size(); i++) {
			if (theCities.get(i).getCityId() == theId) {
				tempHotel.setCity(theCities.get(i));
				break;
			}
		}
		List<Company> theCompanies = userService.getCompanies();
		theModel.addAttribute("companies", theCompanies);

		return "add-hotel-form-three";

	}

	@RequestMapping("/processAddHotelFormThree")
	public String processAddHotelFormThree(@Valid @ModelAttribute("companyId") int theId) {

		System.out.println("Selected Id: " + theId);

		// find selected company and add it to the hotel
		List<Company> theCompanies = userService.getCompanies();
		for (int i = 0; i < theCompanies.size(); i++) {
			if (theCompanies.get(i).getCompanyId() == theId) {
				tempHotel.setCompany(theCompanies.get(i));
				break;
			}
		}

		// save the hotel using our service
		userService.saveHotel(tempHotel);
		tempHotel = null;

		return "redirect:/user/viewHotelsPage";

	}

	@GetMapping("/updateHotelForm")
	public String updateHotelForm(@RequestParam("hotelId") int theId, Model theModel) {

		// get the hotel from our service
		Hotel theHotel = userService.getHotel(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("hotel", theHotel);

		// send over to our form
		return "add-hotel-form-one";
	}

	@GetMapping("/deleteHotel")
	public String deleteHotel(@RequestParam("hotelId") int theId) {

		// delete the city
		userService.deleteHotel(theId);

		return "redirect:/user/viewHotelsPage";
	}

	@GetMapping("/viewTransportsPage")
	public String viewTransportsPage(Model theModel) {

		List<Transport> theTransports = userService.getTransports();

		theModel.addAttribute("transports", theTransports);

		return "view-transports-page";
	}

	@GetMapping("/addTransportFormOne")
	public String addTransportFormOne(Model theModel) {

		theModel.addAttribute("transport", new Transport());

		return "add-transport-form-one";
	}

	@RequestMapping("/processAddTransportFormOne")
	public String processAddTransportFormOne(@Valid @ModelAttribute("transport") Transport theTransport,
			BindingResult theBindingResult, Model theModel) {

		if (theBindingResult.hasErrors()) {
			return "add-transport-form-one";
		} else {

			tempTransport = theTransport;
			List<City> theCities = userService.getCities();
			theModel.addAttribute("cities", theCities);
			return "add-transport-form-two";
		}

	}

	@RequestMapping("/processAddTransportFormTwo")
	public String processAddTransportFormTwo(@ModelAttribute("cityId") int theId, Model theModel) {

		City theCity = userService.getCity(theId);

		tempTransport.setFromCity(theCity);

		List<City> theCities = userService.getCities();
		theModel.addAttribute("cities", theCities);

		return "add-transport-form-three";

	}

	@RequestMapping("/processAddTransportFormThree")
	public String processAddTransportFormThree(@ModelAttribute("cityId") int theId, Model theModel) {

		City theCity = userService.getCity(theId);

		tempTransport.setToCity(theCity);

		List<TransportType> theTransportTypes = userService.getTransportTypes();

		theModel.addAttribute("transportTypes", theTransportTypes);

		return "add-transport-form-four";

	}

	@RequestMapping("/processAddTransportFormFour")
	public String processAddTransportFormFour(@ModelAttribute("transportTypeId") int theId, Model theModel) {

		TransportType theTransportType = userService.getTransportType(theId);

		tempTransport.setTransportType(theTransportType);

		List<Company> theCompanies = userService.getCompanies();

		theModel.addAttribute("companies", theCompanies);

		return "add-transport-form-five";

	}

	@RequestMapping("/processAddTransportFormFive")
	public String processAddTransportFormFive(@ModelAttribute("companyId") int theId, Model theModel) {

		Company theCompany = userService.getCompany(theId);

		tempTransport.setCompany(theCompany);

		userService.saveTransport(tempTransport);

		tempTransport = null;
		return "redirect:/user/viewTransportsPage";

	}

	@GetMapping("/updateTransportForm")
	public String updateTransportForm(@RequestParam("transportId") int theId, Model theModel) {

		// get the hotel from our service
		Transport theTransport = userService.getTransport(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("transport", theTransport);

		// send over to our form
		return "add-transport-form-one";
	}

	@GetMapping("/deleteTransport")
	public String deleteTransport(@RequestParam("transportId") int theId) {

		// delete
		userService.deleteTransport(theId);

		return "redirect:/user/viewTransportsPage";
	}

	@GetMapping("/viewTransportTypesPage")
	public String viewTransportTypesPage(Model theModel) {

		List<TransportType> theTransports = userService.getTransportTypes();

		theModel.addAttribute("transportTypes", theTransports);

		return "view-transport-types-page";
	}

	@GetMapping("/addTransportTypeForm")
	public String addTransportTypeForm(Model theModel) {

		theModel.addAttribute("transportType", new TransportType());

		return "add-transport-type-form";
	}

	@RequestMapping("/processAddTransportTypeForm")
	public String processAddTransportTypeForm(@Valid @ModelAttribute("transportType") TransportType theTransportType,
			BindingResult theBindingResult, Model theModel) {

		if (theBindingResult.hasErrors()) {
			return "add-transport-type-form";
		} else {

			userService.saveTransportType(theTransportType);
			return "redirect:/user/viewTransportTypesPage";
		}

	}

	@GetMapping("/updateTransportTypeForm")
	public String updateTransportTypeForm(@RequestParam("transportTypeId") int theId, Model theModel) {

		// get the hotel from our service
		TransportType theTransportType = userService.getTransportType(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("transportType", theTransportType);

		// send over to our form
		return "add-transport-type-form";
	}

	@GetMapping("/deleteTransportType")
	public String deleteTransportType(@RequestParam("transportTypeId") int theId) {

		// delete
		userService.deleteTransportType(theId);

		return "redirect:/user/viewTransportTypesPage";
	}

	@GetMapping("/viewUsersPage")
	public String viewUsersPage(Model theModel) {

		List<User> theUsers = userService.getUsers();

		theModel.addAttribute("users", theUsers);

		return "view-users-page";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int theId) {

		// delete
		userService.deleteUser(theId);

		return "redirect:/user/viewUsersPage";
	}

	@GetMapping("/viewTravelsPage")
	public String viewTravelsPage(Model theModel) {

		List<Travel> theTravels = userService.getTravels();

		theModel.addAttribute("travels", theTravels);

		return "view-travels-page";
	}

	@GetMapping("/deleteTravel")
	public String deleteTravel(@RequestParam("travelId") int theId) {

		// delete
		userService.deleteTravel(theId);

		return "redirect:/user/viewTravelsPage";
	}

	@GetMapping("/viewCompaniesPage")
	public String viewCompaniesPage(Model theModel) {

		if (activeUser.getUserType() == 3) {
			List<Company> theCompanies = userService.getCompanies();

			theModel.addAttribute("companies", theCompanies);

			return "view-companies-page";
		} else {
			return "redirect:/user/employeeHomePage";
		}

	}

	@GetMapping("/addCompanyFormOne")
	public String addCompanyFormOne(Model theModel) {

		theModel.addAttribute("company", new Company());

		return "add-company-form-one";
	}

	@RequestMapping("/processAddCompanyFormOne")
	public String processAddCompanyFormOne(@Valid @ModelAttribute("company") Company theCompany,
			BindingResult theBindingResult, Model theModel) {

		if (theBindingResult.hasErrors()) {
			return "add-company-form-one";
		} else {
			tempCompany = theCompany;
			List<City> theCities = userService.getCities();
			theModel.addAttribute("cities", theCities);
			return "add-company-form-two";
		}

	}

	@RequestMapping("/processAddCompanyFormTwo")
	public String processAddCompanyFormTwo(@ModelAttribute("cityId") int theId, Model theModel) {

		City theCity = userService.getCity(theId);

		tempCompany.setCity(theCity);

		userService.saveCompany(tempCompany);

		tempCompany = null;

		return "redirect:/user/viewCompaniesPage";

	}

	@GetMapping("/updateCompanyForm")
	public String updateCompanyForm(@RequestParam("companyId") int theId, Model theModel) {

		// get the hotel from our service
		Company theCompany = userService.getCompany(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("company", theCompany);

		// send over to our form
		return "add-company-form-one";
	}

	@GetMapping("/deleteCompany")
	public String deleteCompany(@RequestParam("companyId") int theId) {

		// delete
		userService.deleteCompany(theId);

		return "redirect:/user/viewCompaniesPage";
	}

}
