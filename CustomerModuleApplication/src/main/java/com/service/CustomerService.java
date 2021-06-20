package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.dao.ICustomerRepository;
import com.model.Address;
import com.model.Customer;
@Service
public class CustomerService implements ICustomerService {	
	List<Customer> le;
	@Autowired
	ICustomerRepository icrepo;
	String phn = "[6-9][0-9]{9}";
	Pattern phone=Pattern.compile(phn);
	
	Pattern email1 = Pattern.compile("[a-zA-Z_]+[0-9]*[@][a-zAZ]+[/.][a-zA-Z]{2,3}");
	
	public CustomerService() {
	}
	//Method to CreateCustomer
	public Customer addCustomer(Customer customer) {
		Customer e1= icrepo.save(customer);
		return e1;
	}
	
	//Method to  RemoveCustomer
	public String removeCustomer(long userId) throws Exception {
		Supplier<Exception> s = () -> {
            return new ResourceNotFoundException("Customer Id is not present in the database");
        };
        Customer var = (Customer)this.icrepo.findById(userId).orElseThrow(s);
		this.icrepo.deleteById(userId);
		return "Deleted";
	}
	
	//Method for updatecustomer
	@Override
	public Customer updateCustomer(Customer customer) throws Exception  {
	
		long uid=customer.getUserId();
		
		System.out.println(customer.getName());
		Supplier<Exception> s = () -> new ResourceNotFoundException("Customer Id is not present in the database");
		Customer c1=icrepo.findById(uid).orElseThrow(s);
		//c1.setUserId(customer.getUserId());
		c1.setName(customer.getName());
		c1.setAddress(customer.getAddress());
		c1.setContactNo(customer.getContactNo());
		c1.setDob(customer.getDob());
		c1.setEmail(customer.getEmail());
		icrepo.save(c1);	
		return c1;
	}
	//Method for GetCustomer
	public Customer getCustomer(long uid) throws Exception {
        Supplier<Exception> s = () -> {
            return new ResourceNotFoundException("Customer Id is not present in the database");
        };
        Customer e1 = (Customer)this.icrepo.findById(uid).orElseThrow(s);
        return e1;
    }

	//Method for GetAllCustomers
	public List<Customer> getAllCustomers()  {
		le = new ArrayList<>();
		le= icrepo.findAll();
		return le;
	}

   //Method for getCustomersByLocation
	@Override
	public List<Customer> getCustomersByLocation(String city)  {
		List<Customer> ls = icrepo.findByCitySorted(city);
		System.out.println(ls);
		return ls;
	}

    //Method for AddAddress
	@Override
	public Address addAddress(Address Address) {
		Address e1= icrepo.save(Address);
		return e1;
	
	}
	//Method for AddCustomer
	public List<Customer> addCustomers(List<Customer> ls) {
		le = new ArrayList<>();
		le = icrepo.saveAll(ls);
		return le;
	}





	




	







	
	



	
	
	

}
