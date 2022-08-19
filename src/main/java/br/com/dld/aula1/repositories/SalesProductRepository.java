package br.com.dld.aula1.repositories;

import br.com.dld.aula1.models.entities.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesProductRepository  extends JpaRepository<SalesProduct, Long> {

}
