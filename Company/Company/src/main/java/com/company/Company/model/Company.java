package com.company.Company.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.annotation.security.PermitAll;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Company_Data")
@JsonInclude(value = Include.NON_NULL)
public class Company implements Serializable{
	
	
	
	@Id
	@NotNull
	@Pattern(regexp="^[A-Za-z\\s]*$",message="Invalid name")
	@Column(name="cpname")
	private String cpname;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z\\s0-9]*$", message="Invalid location")
	@Column(name="location")
	private String location;
	
	@Pattern(regexp="[\\d]{10}")
	@Size(min = 10, max = 10)
	@Column(name="google_phno", length = 30)
	private String phoneno;
	
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@NotNull
	@Min(100000)
	@Max(999999)
	@Column(name="pincode")
	private int pincode;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z\\s0-9]*$", message="Invalid area")
	@Column(name="area")
	private String area;
	
	@Pattern(regexp="[\\d]{10}")
	@Size(min = 10, max = 10)
	@Column(name="Hr_phone",length = 30)
	private String hrphone;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z\\s]*$",message="Invalid Input")
	@Column(name="Hr_name")
	private String hrname;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String cpname, String location, String phone_no, String email, int pincode, String area, String hr_phone,
			String hr_name) {
		this.cpname = cpname;
		this.location = location;
		this.phoneno = phoneno;
		this.email = email;
		this.pincode = pincode;
		this.area = area;
		this.hrphone = hrphone;
		this.hrname = hrname;
	}

	
	
	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHrphone() {
		return hrphone;
	}

	public void setHrphone(String hrphone) {
		this.hrphone = hrphone;
	}

	public String getHrname() {
		return hrname;
	}

	public void setHrname(String hrname) {
		this.hrname = hrname;
	}

	@Override
	public String toString() {
		return "Company [ cpname=" + cpname + ", location=" + location + ", phoneno=" + phoneno
				+ ", email=" + email + ", pincode=" + pincode + ", area=" + area + ", hrphone=" + hrphone
				+ ", hrname=" + hrname + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, cpname, email, hrname, hrphone, location, phoneno, pincode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(area, other.area) && Objects.equals(cpname, other.cpname)
				&& Objects.equals(email, other.email) && Objects.equals(hrname, other.hrname)
				&& hrphone == other.hrphone && Objects.equals(location, other.location) && phoneno == other.phoneno
				&& pincode == other.pincode;
	}

		
	}
