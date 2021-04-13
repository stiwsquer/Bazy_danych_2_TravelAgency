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



@Entity
@Table(name ="countries")
public class Country {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int countryId;
	@NotNull(message = "is required")
	@Column(name = "country_name", unique=true)
	@Pattern(message = "Wrong country name", regexp= "^(Afghanistan|Albania|Algeria|American Samoa|Andorra|Angola|Anguilla|Antarctica|Antigua and Barbuda|Argentina|Armenia|Aruba|Australia|Austria|Azerbaijan|Bahamas|Bahrain|Bangladesh|Barbados|Belarus|Belgium|Belize|Benin|Bermuda|Bhutan|Bolivia|Bosnia and Herzegowina|Botswana|Bouvet Island|Brazil|British Indian Ocean Territory|Brunei Darussalam|Bulgaria|Burkina Faso|Burundi|Cambodia|Cameroon|Canada|Cape Verde|Cayman Islands|Central African Republic|Chad|Chile|China|Christmas Island|Cocos (Keeling) Islands|Colombia|Comoros|Congo|Congo, the Democratic Republic of the|Cook Islands|Costa Rica|Cote d'Ivoire|Croatia (Hrvatska)|Cuba|Cyprus|Czech Republic|Denmark|Djibouti|Dominica|Dominican Republic|East Timor|Ecuador|Egypt|El Salvador|Equatorial Guinea|Eritrea|Estonia|Ethiopia|Falkland Islands (Malvinas)|Faroe Islands|Fiji|Finland|France|France Metropolitan|French Guiana|French Polynesia|French Southern Territories|Gabon|Gambia|Georgia|Germany|Ghana|Gibraltar|Greece|Greenland|Grenada|Guadeloupe|Guam|Guatemala|Guinea|Guinea-Bissau|Guyana|Haiti|Heard and Mc Donald Islands|Holy See (Vatican City State)|Honduras|Hong Kong|Hungary|Iceland|India|Indonesia|Iran (Islamic Republic of)|Iraq|Ireland|Israel|Italy|Jamaica|Japan|Jordan|Kazakhstan|Kenya|Kiribati|Korea, Democratic People's Republic of|Korea, Republic of|Kuwait|Kyrgyzstan|Lao, People's Democratic Republic|Latvia|Lebanon|Lesotho|Liberia|Libyan Arab Jamahiriya|Liechtenstein|Lithuania|Luxembourg|Macau|Macedonia, The Former Yugoslav Republic of|Madagascar|Malawi|Malaysia|Maldives|Mali|Malta|Marshall Islands|Martinique|Mauritania|Mauritius|Mayotte|Mexico|Micronesia, Federated States of|Moldova, Republic of|Monaco|Mongolia|Montserrat|Morocco|Mozambique|Myanmar|Namibia|Nauru|Nepal|Netherlands|Netherlands Antilles|New Caledonia|New Zealand|Nicaragua|Niger|Nigeria|Niue|Norfolk Island|Northern Mariana Islands|Norway|Oman|Pakistan|Palau|Panama|Papua New Guinea|Paraguay|Peru|Philippines|Pitcairn|Poland|Portugal|Puerto Rico|Qatar|Reunion|Romania|Russian Federation|Rwanda|Saint Kitts and Nevis|Saint Lucia|Saint Vincent and the Grenadines|Samoa|San Marino|Sao Tome and Principe|Saudi Arabia|Senegal|Seychelles|Sierra Leone|Singapore|Slovakia (Slovak Republic)|Slovenia|Solomon Islands|Somalia|South Africa|South Georgia and the South Sandwich Islands|Spain|Sri Lanka|St. Helena|St. Pierre and Miquelon|Sudan|Suriname|Svalbard and Jan Mayen Islands|Swaziland|Sweden|Switzerland|Syrian Arab Republic|Taiwan, Province of China|Tajikistan|Tanzania, United Republic of|Thailand|Togo|Tokelau|Tonga|Trinidad and Tobago|Tunisia|Turkey|Turkmenistan|Turks and Caicos Islands|Tuvalu|Uganda|Ukraine|United Arab Emirates|United Kingdom|United States|United States Minor Outlying Islands|Uruguay|Uzbekistan|Vanuatu|Venezuela|Vietnam|Virgin Islands (British)|Virgin Islands (U.S.)|Wallis and Futuna Islands|Western Sahara|Yemen|Yugoslavia|Zambia|Zimbabwe|)$")
	private String countryName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> cities;
	
	public Country() {
	}
	
	public Country(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	public void addCity(City theCity) {
		
		if(cities ==null) {
			cities = new ArrayList<>();
		}
		cities.add(theCity);
	}
	
	
}
