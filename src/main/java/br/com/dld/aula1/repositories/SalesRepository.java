package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository  extends JpaRepository<Sales, Long> {

}
