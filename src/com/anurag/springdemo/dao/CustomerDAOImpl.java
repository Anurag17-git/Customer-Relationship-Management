package com.anurag.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject hibernate sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> createQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

		// execute query and get result
		List<Customer> list = createQuery.getResultList();

		// returns the result
		return list;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save the customer
		currentSession.save(customer);

		// update the customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save the customer
		Customer customer = currentSession.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//deleting the customer
		Customer customer = currentSession.get(Customer.class, theId);
		currentSession.delete(customer);

	}

}
