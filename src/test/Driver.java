package test;

import java.util.Set;

public class Driver implements Comparable<Driver> {
	String subname;
	String name;
	String email;
	String vehicleType;
	double baseFarePrice;
	double baseFareDistance;

	public Driver(String subname, String name, String email, String vehicleType, double baseFarePrice,
			double baseFareDistance) {
		this.email = email;
		this.subname = subname;
		this.name = name;
		this.vehicleType = vehicleType;
		this.baseFarePrice = baseFarePrice;
		this.baseFareDistance = baseFareDistance;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getBaseFarePrice() {
		return baseFarePrice;
	}

	public void setBaseFarePrice(double baseFarePrice) {
		this.baseFarePrice = baseFarePrice;
	}

	public double getBaseFareDistance() {
		return baseFareDistance;
	}

	public void setBaseFareDistance(double baseFareDistance) {
		this.baseFareDistance = baseFareDistance;
	}

	// implementing the abstract method
	public int compareTo(Driver b) {
		return email.compareTo(b.email);
	}

	public static Driver find(String parameter, Set<Driver> set) {
		for (Driver driver : set) {
			if (driver.getEmail() == parameter) {
				return driver;
			}
		}
		return null;
	}
}
