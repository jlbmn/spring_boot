package fr.formation.inti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import fr.formation.inti.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
	
	Integer saveCustomer(Customer cust);
	
	void updateCustomer(Customer cust);
	
	void deleteCustomer(Customer cust);
	
	void deleteCustomer(Integer id);
	
	Optional<Customer> findById(Integer id);
	
	List<Customer> findByState(String state);
	
	List<Customer> findByFedId();
	
	List<Customer> findByAddress(String address);
	
	List<Customer> findByPostalCode(String code);

//	List<Customer> findPaginated(int pageNo, int pageSize);
	
	Page<Customer> findPaginated(int pageNo, int pageSize);
	
}
