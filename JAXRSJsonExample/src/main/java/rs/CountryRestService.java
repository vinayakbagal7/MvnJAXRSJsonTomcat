package rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Country;

@Path("/countries")
public class CountryRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		List<Country> listCountries = new ArrayList<Country>();
		listCountries = createCountryList();
		return listCountries;		
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		List<Country> listCountries = createCountryList();
		for (Country country : listCountries) {
			if(country.getId() == id) {
				return country;
			}
		}
		return null;
	}

	private List<Country> createCountryList() {
		Country india = new Country(1, "India");
		Country china = new Country(2, "China");
		Country nepal = new Country(3, "Nepal");
		Country bhutan = new Country(4, "Bhutan");

		List<Country> listCountries = new ArrayList<Country>();
		listCountries.add(india);
		listCountries.add(china);
		listCountries.add(nepal);
		listCountries.add(bhutan);

		return listCountries;
	}
}
