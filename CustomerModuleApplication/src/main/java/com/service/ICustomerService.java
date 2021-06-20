package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Address;
import com.model.Customer;
//import com.service.*;

public interface ICustomerService  {

	
	  public Customer addCustomer(Customer customer);
	  public String removeCustomer(long userId) throws Exception; 
	public Customer updateCustomer(Customer customer) throws Exception;
	Customer getCustomer(long uid) throws Exception; public
	  List<Customer> getAllCustomers(); 
	  public List<Customer> getCustomersByLocation(String city);
	  public Address addAddress(Address Address);
	  public List<Customer> addCustomers(List<Customer> ls);
//	Customer updateCustomer(Customer customer);
	 

	 
}
