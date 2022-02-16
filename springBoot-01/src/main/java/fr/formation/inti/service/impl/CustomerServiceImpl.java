package fr.formation.inti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CustomerDao;
import fr.formation.inti.entity.Customer;
import fr.formation.inti.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Integer saveCustomer(Customer cust) {
		
		return customerDao.save(cust).getCustId();
	}

	@Override
	public void updateCustomer(Customer cust) {
		saveCustomer(cust);
	}

	@Override
	public void deleteCustomer(Customer cust) {
		customerDao.delete(cust);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteById(id);
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findByState(String state) {
		return customerDao.findByState(state);
	}
	
	/**
	 * customer with fed_id xxx-xx-xxxx => on veut ce format pas l'autre
	 * on veut en gros comme un like 
	 * @Query("SELECT u FROM User u WHERE u.status = 1")
	 * Collection<User> findAllActiveUsers();
	 */
	@Override
	public List<Customer> findByFedId() {
		return customerDao.selectFedIdPattern();
	}
	

	@Override
	public List<Customer> findByAddress(String address) {
		return customerDao.findByAddressContaining(address);
	}
	
	@Override
	public List<Customer> findByPostalCode(String code) {
		return customerDao.findByPostalCodeContaining(code);
	}
	
	
	
}
