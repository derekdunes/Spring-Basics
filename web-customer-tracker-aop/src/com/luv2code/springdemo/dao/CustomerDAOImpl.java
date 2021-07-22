package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomer() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query to sort by lastname
		Query<Customer> query = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		//Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		
		//return the result
		
		return customers;
		
	}


	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(customer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//execute query and get result list
		Customer customer = currentSession.get(Customer.class, theId);
		
		//return the result
		return customer;
		
	}


	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query to sort by lastname
		Query<Customer> query = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
		//return the result
		
	}


	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		//only search the name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			
			//search for firstName or LastNamr case insensitive
			query = currentSession.createQuery("from Customer as c where lower(c.firstName) like :theName or lower(c.lastName) like :theName", Customer.class);
			
			query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
			
		} else {
			
			//if the search name is empty get all names
			//create a query to sort by lastname
			query = currentSession.createQuery("from Customer", Customer.class);

		}
		
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		
		//return the result
		return customers;
	}

}
