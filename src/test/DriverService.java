package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DriverService {
	protected double distanceTraveled ;
	protected double traveledUnit;
	protected double costPerDistanceTraveled;
	 Set<Driver> drivers = new TreeSet<Driver>();
	 protected List<Double> fare;
	public DriverService() {
		this.drivers =  new TreeSet<Driver>();
	}
	public boolean addDriver(Driver driver)
	{
		return this.drivers.add(driver);
	}
	public boolean deleteDriver(Driver parameter) {
				Driver driver = Driver.find(parameter.getEmail(), this.drivers);
				if(driver!=null) return 	this.drivers.remove(driver);
				return false;	
	}
	public boolean updateDriver(Driver parameter)
	{
		Driver driver = Driver.find(parameter.getEmail(), this.drivers);
		if(driver!=null) {
			this.drivers.remove(driver);
			this.drivers.add(parameter);
			return true;
		}
		
		return false;	
		
	}
	public void show()
	{
		// Traversing TreeSet
				for (Driver b : this.drivers ) {
				System.out.println(b.email +"   "+ b.name);
				}
	}
	
	public boolean find(Driver driver)
	{
		 return this.drivers.contains(driver);
		//return  Driver.find(email, this.drivers);
		
	}
	public void caculate()
	{
		
		int length = this.drivers.size();
		
		this.fare = new ArrayList<Double>(length);
		String csvFile = "D:/test.csv";
		String csvSplitBy = ",";
		String line = "";

		int row = 0;
		int rowCount = 0;
		int colCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				rowCount++;
				String[] row1 = line.split(csvSplitBy);
				if (rowCount == 1) {
					colCount = row1.length;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		double[][] data = new double[rowCount][colCount];
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(csvSplitBy);
				for (int col = 0; col < fields.length; col++) {
					try {
						data[row][col] = Double.parseDouble(fields[col]);
					} catch (NumberFormatException e) {
						System.out.println("Invalid number: " + fields[col]);
					}
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.distanceTraveled = data[0][0];
		this.traveledUnit = data[0][1];
		this.costPerDistanceTraveled = data[0][2];
		
		for(Driver driver: this.drivers)
		{
			if(driver.getBaseFareDistance() < this.distanceTraveled)
			{
				this.fare.add(((this.distanceTraveled - driver.getBaseFareDistance())/
				this.traveledUnit* this.costPerDistanceTraveled) + driver.getBaseFarePrice()); 
				
			}
			else {
				this.fare.add(driver.getBaseFarePrice());
			}
				
		}
		for (Double ds : this.fare) {
			System.out.println(ds);
		}
		
	}
	

}
