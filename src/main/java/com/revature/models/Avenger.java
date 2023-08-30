package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String superheroName;
	private String superPower;
	private String firstName;
	private String lastName;
	private double powerLevel;
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Home home;
	
	public Avenger(int id, String superheroName, String superPower, String firstName, String lastName,
			double powerLevel, Home home) {
		super();
		this.id = id;
		this.superheroName = superheroName;
		this.superPower = superPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger(String superheroName, String superPower, String firstName, String lastName, double powerLevel,
			Home home) {
		super();
		this.superheroName = superheroName;
		this.superPower = superPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
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

	public double getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(double powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(powerLevel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
		result = prime * result + ((superheroName == null) ? 0 : superheroName.hashCode());
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
		Avenger other = (Avenger) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(powerLevel) != Double.doubleToLongBits(other.powerLevel))
			return false;
		if (superPower == null) {
			if (other.superPower != null)
				return false;
		} else if (!superPower.equals(other.superPower))
			return false;
		if (superheroName == null) {
			if (other.superheroName != null)
				return false;
		} else if (!superheroName.equals(other.superheroName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avenger [id=" + id + ", superheroName=" + superheroName + ", superPower=" + superPower + ", firstName="
				+ firstName + ", lastName=" + lastName + ", powerLevel=" + powerLevel + ", home=" + home + "]";
	}
	
	
	

}
