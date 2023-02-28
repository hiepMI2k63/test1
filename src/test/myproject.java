package test;
import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class myproject {

	public static void main(String[] args) throws FileNotFoundException {

		
		
		Scanner scanner = new Scanner(System.in);
		 DriverService driverService =  new DriverService();
		
		// Creating Drivers
		Driver b1 = new Driver("email", "Let us C", "Yashwant Kanetkar",
		"BPB", 200, 150);
		Driver b2 = new Driver("email",  "Operating System", "Galvin", "Wiley",
		300, 250);
		while (true) {
			System.out.println("1.add");
			System.out.println("2.delete");
			System.out.println("3.update");
			System.out.println("4.caculate");
			System.out.print("5.show");
		
			System.out.println("0.exit");
			String key = scanner.nextLine();
			switch (key) {
					case "0":
					return;
					case "1":
					System.out.println("name");
					String name = scanner.nextLine();
					System.out.println("subname");
					String subname = scanner.nextLine();
					System.out.println("email");
					String email = scanner.nextLine();
					System.out.println("Vehicle Type");
					String vehicleType = scanner.nextLine();
					System.out.println("Base Fare Price");
					double baseFarePrice = scanner.nextDouble();
					System.out.println("base Fare Distance");
					double baseFareDistance = scanner.nextDouble();
					 Driver driver = new Driver(subname,name,email,vehicleType,baseFarePrice,baseFareDistance);
					 driverService.addDriver(driver);
					
					break;
					case "2":
					System.out.println("name");
					 name = scanner.nextLine();
					System.out.println("subname");
					 subname = scanner.nextLine();
					System.out.println("email");
					 email = scanner.nextLine();
					System.out.println("Vehicle Type");
					 vehicleType = scanner.nextLine();
					System.out.println("Base Fare Price");
					baseFarePrice = scanner.nextDouble();
					System.out.println("base Fare Distance");
					baseFareDistance = scanner.nextDouble();
					 driver = new Driver(subname,name,email,vehicleType,baseFarePrice,baseFareDistance);
					driverService.deleteDriver(driver);
					break;
					case "3":
					System.out.println("name");
					 name = scanner.nextLine();
					System.out.println("subname");
					 subname = scanner.nextLine();
					System.out.println("email");
					 email = scanner.nextLine();
					System.out.println("Vehicle Type");
					 vehicleType = scanner.nextLine();
					System.out.println("Base Fare Price");
					baseFarePrice = scanner.nextDouble();
					System.out.println("base Fare Distance");
					baseFareDistance = scanner.nextDouble();
					 driver = new Driver(subname,name,email,vehicleType,baseFarePrice,baseFareDistance);
					
					driverService.updateDriver(driver);
					break;
					case "4":
					driverService.caculate();
					break;
					case "5":
					driverService.show();
					break;
				default:
					break;
			}
		}
	
	}
}