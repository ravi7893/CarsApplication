package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dao.ICustomerRepository;
import com.model.Address;
import com.model.Customer;
@SpringBootTest
class CustomerServiceTest {
	 @Autowired
	 CustomerService cusservice; 
	 
	 @MockBean
	    ICustomerRepository icrepo;

	 CustomerServiceTest() {
	    }

	

	@Test
	void testAddCustomer() {
		Customer c1 = new Customer();
        c1.setUserId(1);
        c1.setName("Ravich");
        c1.setEmail("ravi@gmail.com");
        c1.setAddress(null);
        c1.setContactNo("7893462545");
        c1.setDob("05-02-1995");
       
        Mockito.when((Customer)this.icrepo.save(c1)).thenReturn(c1);
        Assertions.assertThat(this.cusservice.addCustomer(c1)).isEqualTo(c1);
	}

	@Test
	void testRemoveCustomer() {
		 Customer c1 = new Customer();
		c1.setUserId(1);
	    c1.setName("Ravich");
	    c1.setEmail("ravi@gmail.com");
	    c1.setAddress(null);
	    c1.setContactNo("7893462545");
	    c1.setDob("05-02-1995");
	       
	    Optional<Customer> c2 = Optional.of(c1);
        Mockito.when(this.icrepo.findById((long) 1)).thenReturn(c2);
        Mockito.when(this.icrepo.existsById(c1.getUserId())).thenReturn(false);
        org.junit.jupiter.api.Assertions.assertFalse(this.icrepo.existsById(c1.getUserId()));
		
	}

	@Test
	void testUpdateCustomer() throws Exception {
		Address a=new Address();
		
		a.setArea("Mallayapeta");
		a.setCity("Rajahmundry");
		a.setDoorNo("852-545");
		a.setPincode(533101);
		a.setState("Andhra Pradesh");
		a.setStreet("Industrial Colony");
		
		Customer c1 = new Customer();
        c1.setUserId(10);
        c1.setName("Ravich");
        c1.setEmail("ravi@gmail.com");
        c1.setAddress(a);
        c1.setContactNo("9490806700");
        c1.setDob("05-02-1995");
        
        Optional<Customer> c=Optional.of(c1);
        Mockito.when(icrepo.findById((long) 10)).thenReturn(c);
		c1.setContactNo("7490806700");
		Mockito.when(icrepo.save(c1)).thenReturn(c1);
		Assertions.assertThat(this.cusservice.updateCustomer(c1)).isEqualTo(c1);
	}

	@Test
	void testGetCustomer() throws Exception {
		Customer c1 = new Customer();
        c1.setUserId(1);
        c1.setName("charan");
        c1.setContactNo("9849036793");
        c1.setEmail("rc@gmail.com");
        c1.setDob("08-02-1995");
    	Customer c2 = new Customer();
        c2.setUserId(2);
        c2.setName("ravi");  
        c2.setContactNo("9849036791");
        c2.setEmail("rca@gmail.com");
        c2.setDob("08-02-1995");
	    List<Customer> cusList = new ArrayList();
	    cusList.add(c1);
	    cusList.add(c2);
	    Mockito.when(this.icrepo.findAll()).thenReturn(cusList);
	    Assertions.assertThat(this.cusservice.getAllCustomers()).isEqualTo(cusList);
	}

	@Test
	void testGetAllCustomers() {
		Customer c1 = new Customer();
        c1.setUserId(1);
        c1.setName("Ravi");      
        c1.setContactNo("9849036793");
        c1.setEmail("rc@gmail.com");
        c1.setDob("08-02-1995");       
    	Customer c2 = new Customer();
        c2.setUserId(1);
        c2.setName("Ravi");      
        c2.setContactNo("9849036793");
        c2.setEmail("rc@gmail.com");
        c2.setDob("08-02-1995");      
        List<Customer> cusList = new ArrayList(); 
        Mockito.when(this.icrepo.findAll()).thenReturn(cusList);
        Assertions.assertThat(this.cusservice.getAllCustomers()).isEqualTo(cusList);
		
	}
 
	@Test
	void testGetCustomersByLocation() {
		List<Customer> c=new ArrayList<>(); 
		Address a=new Address();	
		a.setArea("Mallayapeta");
		a.setCity("Rajahmundry");
		a.setDoorNo("852-545");
		a.setPincode(533101);
		a.setState("Andhra Pradesh");
		a.setStreet("Industrial Colony");
		Customer c1=new Customer();
		c1.setUserId(10);
		c1.setAddress(a);
		c1.setContactNo("9490806700");
		c1.setName("Sunil");
		c1.setDob("2019-20-5");
		c1.setEmail("yaghnasunil@gmail.com");
		
		Customer c2=new Customer();
		c2.setUserId(12);
		c2.setAddress(a);
		c2.setContactNo("9490806700");
		c2.setName("Sunil");
		c2.setDob("2019-20-5");
		c2.setEmail("yaghnasunil@gmail.com");
		
		c.add(c1);
		c.add(c2);
		
		Mockito.when(icrepo.findByCitySorted("Rajahmundry")).thenReturn(c);
	    
	   Assertions.assertThat(cusservice.getCustomersByLocation("Rajahmundry")).isEqualTo(c);
	
	}

	@Test
	void testAddAddress() {
		Address a1 = new Address();
        a1.setArea("hitechcity");
        a1.setCity("Hyderabad");
        a1.setDoorNo("48-11");
        a1.setPincode(530012);
        a1.setState("AP");
        a1.setStreet("ram_Street");
       
        Mockito.when((Address)this.icrepo.save(a1)).thenReturn(a1);
        Assertions.assertThat(this.cusservice.addAddress(a1)).isEqualTo(a1);
		
	}

	@Test
	void testAddCustomers() {
		Customer c1 = new Customer();
	    c1.setUserId(1);
	    c1.setName("Ravich");
	    c1.setEmail("ravi@gmail.com");
	    c1.setAddress(null);
	    c1.setContactNo("7893462545");
	    c1.setDob("05-02-1995");  
	    Customer c2 = new Customer();
	    c2.setUserId(1);
	    c2.setName("Ravi");	       
	    c2.setContactNo("9849036793");
	    c2.setEmail("rc@gmail.com");
	    c2.setDob("08-02-1995");
	        
	    List<Customer> cusList = new ArrayList();
	    cusList.add(c1);
	    cusList.add(c2);
	    Mockito.when(this.icrepo.saveAll(cusList)).thenReturn(cusList);
	    Assertions.assertThat(this.cusservice.addCustomers(cusList)).isEqualTo(cusList);
		
	}

}
