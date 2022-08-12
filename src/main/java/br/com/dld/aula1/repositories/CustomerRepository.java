package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByNameContains(String name);
}
