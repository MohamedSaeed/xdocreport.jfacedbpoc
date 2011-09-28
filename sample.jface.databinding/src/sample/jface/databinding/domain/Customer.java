package sample.jface.databinding.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	@NotNull
	@Pattern(regexp = "[A-Za-z -]*")
	private String name;
	private String addressLine;
	@Size(min = 1, max = 5)
	@Pattern(regexp = "[0-9]*")
	private String zip;
	@NotNull
	@Pattern(regexp = "[A-Za-z -]*")
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}