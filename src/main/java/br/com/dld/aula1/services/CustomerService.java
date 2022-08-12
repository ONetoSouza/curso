package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.Customer;
import br.com.dld.aula1.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllByName(String name) {
        return customerRepository.findAllByNameContains(name);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
