package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity1.Claim;
import com.lti.entity1.Customer;
import com.lti.entity1.Depreciation;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;

public class GenInsuranceTest {

	@Test
	public void addCust() {
		Customer cust= new Customer();
		cust.setName("Rituraj");
		cust.setEmail("riturajgujare@gmail.com");
		cust.setPassword("Rituraj123");
		cust.setDateOfBirth(LocalDate.of(1999, 7, 28));
		cust.setAddress("Santoshi-Mata Road");
		cust.setCity("Kalyan");
		cust.setState("Maharashtra");
		cust.setPincode(421301);
		cust.setMobileNumber(1234678);
		
		GenericDao dao= new GenericDao();
		dao.save(cust);
	}
	
	@Test
	public void addVehicleToCustomer() {
		GenericDao dao= new GenericDao();
		Customer cust= (Customer)dao.fetch(Customer.class, 353);
		
		Vehicle vehicle= new Vehicle();
		vehicle.setType("Bike");
		vehicle.setNumber("MH-05-2607");;
		vehicle.setPrice(750000);
		vehicle.setRegistrationDate(LocalDate.of(2020, 6, 16));
		vehicle.setEngineNumber("ENG-0616");
		vehicle.setDrivingLicense("CLW-9871");
		vehicle.setChassisNumber("CAS-5412");
		vehicle.setModel("Shine");
		vehicle.setManufacturer("Honda");
		vehicle.setCustomer(cust);;
		
		dao.save(vehicle);
	}
	
	@Test
	public void addDepreciationToVehicle() {
		GenericDao dao= new GenericDao();
		Vehicle vehicle=(Vehicle) dao.fetch(Vehicle.class, 356);
		Depreciation depreciation= new Depreciation();
		
		depreciation.setVehicleAge(2);
		depreciation.setPercentage(10);
		depreciation.setDepreciationAmount(900000);
		depreciation.setVehicle(vehicle);
		
		dao.save(depreciation);
	}
	
	@Test
	public void addPolicyToVehicle() {
		GenericDao dao= new GenericDao();
		Customer cust= (Customer)dao.fetch(Customer.class, 353);
		Vehicle vehicle= (Vehicle)dao.fetch(Vehicle.class, 355);
		Depreciation depreciation= (Depreciation)dao.fetch(Depreciation.class, 358);
		
		Policy policy= new Policy();
		policy.setType("Third-Party");;
		policy.setRenewal('n');
		policy.setPolicyStartDate(LocalDate.of(2020, 7, 4));
		policy.setPolicyEndDate(LocalDate.of(2021, 7, 4));
		policy.setProvider("Bajaj-Finance");
		policy.setPremium(30000);;
		policy.setIdv(900000);
		policy.setRemainingClaimAmount(900000);
		policy.setCustomer(cust);
		policy.setVehicle(vehicle);
		policy.setDepreciation(depreciation);
		
		dao.save(policy);
	}
	
	@Test
	public void addClaimToPolicy() {
		GenericDao dao= new GenericDao();
		Policy policy= (Policy)dao.fetch(Policy.class, 359);
		
		Claim claim= new Claim();
		claim.setDate(LocalDate.of(2021, 4, 2));
		claim.setReason("Road Accident");
		claim.setAmount(150000);
		claim.setStatus("Accepted");
		claim.setPolicy(policy);
		
		policy.setRemainingClaimAmount(750000);
		dao.save(policy);
		dao.save(claim);
	}
	
	@Test
	public void addCustomerAlongWithVehicle() {
		GenericDao dao= new GenericDao();
		
		Customer cust= new Customer();
		cust.setName("Saurabh");
		cust.setEmail("saurabh@gmail.com");
		cust.setPassword("Saurabh123");
		cust.setDateOfBirth(LocalDate.of(1998, 4, 9));
		cust.setAddress("Vasant-Vihar");
		cust.setCity("Thane");
		cust.setState("Maharashtra");
		cust.setPincode(400301);
		cust.setMobileNumber(1238123);
		
		Vehicle vehicle= new Vehicle();
		vehicle.setType("Car");
		vehicle.setNumber("MH-02-0904");
		vehicle.setPrice(500000);
		vehicle.setRegistrationDate(LocalDate.of(2018, 9, 4));
		vehicle.setEngineNumber("ENG-0904");
		vehicle.setDrivingLicense("CLW-0408");
		vehicle.setChassisNumber("CAS-9198");
		vehicle.setModel("swift");
		vehicle.setManufacturer("Maruti-Suzuki");
		
		Vehicle vehicle1= new Vehicle();
		vehicle1.setType("Bike");
		vehicle1.setNumber("MH-02-3122");
		vehicle1.setPrice(80000);
		vehicle1.setRegistrationDate(LocalDate.of(2019, 8, 15));
		vehicle1.setEngineNumber("ENG-2294");
		vehicle1.setDrivingLicense("CLW-0899");
		vehicle1.setChassisNumber("CAS-9840");
		vehicle1.setModel("Pulsar");
		vehicle1.setManufacturer("Bajaj");
		
		vehicle.setCustomer(cust);
		vehicle1.setCustomer(cust);
		
		List<Vehicle>vehicles= new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		vehicles.add(vehicle1);
		
		cust.setVehicles(vehicles);
		dao.save(cust);
	}
}
