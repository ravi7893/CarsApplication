package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Address;
import com.model.Customer;




public interface ICustomerRepository extends JpaRepository<Customer,Long> {

	Address save(Address address);

	
	@Query("select c from Customer c where c.userId=?1")
	Customer updateCustomer(long userId);
	
	 // @Query("Select c from Customer c where c.Address.city=?1")
	   //List<Customer> getCustomersByLocation(String city);
	 
	/*
	 * public Customer addCustomer(Customer customer); public Customer
	 * removeCustomer(long custId); public Customer updateCustomer(long custId,
	 * Customer customer); public Customer getCustomer(long custId); public
	 * List<Customer> getAllCustomers(); public List<Customer>
	 * getCustomersByLocation();
	 */
	
	
	
	  @Query("select c from Customer c where c.address.aid in (select a.aid from Address a where a.city=?1)")
	
	  List<Customer>findByCitySorted(String city);
	 



}
