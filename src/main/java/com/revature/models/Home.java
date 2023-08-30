package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homes")
public class Home {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String name;
	private String strNum;
	private String strName;
	private String city;
	private String state;
	private String postCode;
	private String country;
	
	public Home(int id, String name, String strNum, String strName, String city, String state, String postCode,
			String country) {
		super();
		this.id = id;
		this.name = name;
		this.strNum = strNum;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.country = country;
	}

	public Home() {
		super();
	}

	public Home(String name, String strNum, String strName, String city, String state, String postCode,
			String country) {
		super();
		this.name = name;
		this.strNum = strNum;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrNum() {
		return strNum;
	}

	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((strName == null) ? 0 : strName.hashCode());
		result = prime * result + ((strNum == null) ? 0 : strNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (strName == null) {
			if (other.strName != null)
				return false;
		} else if (!strName.equals(other.strName))
			return false;
		if (strNum == null) {
			if (other.strNum != null)
				return false;
		} else if (!strNum.equals(other.strNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", strNum=" + strNum + ", strName=" + strName + ", city=" + city
				+ ", state=" + state + ", postCode=" + postCode + ", country=" + country + "]";
	}
	
	
	
}
