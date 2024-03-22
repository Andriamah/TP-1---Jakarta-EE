/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mg.itu.elodie.tp1.service;

/**
 *
 * @author andri
 */
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mg.itu.elodie.tp1.entities.Customer;

/**
 * Façade pour gérer les Customers.
 * @author xxxx
 */
@RequestScoped
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }
}
