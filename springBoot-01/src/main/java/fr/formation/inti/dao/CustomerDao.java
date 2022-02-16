package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	List<Customer> findByState(String state);
	
	@Query(value = "SELECT * FROM CUSTOMER WHERE FED_ID LIKE '%-%-%' ;", nativeQuery = true)
	List<Customer> selectFedIdPattern();
	
	List<Customer> findByAddressContaining(String address);
	
	List<Customer> findByPostalCodeContaining(String postalCode);
	
}
