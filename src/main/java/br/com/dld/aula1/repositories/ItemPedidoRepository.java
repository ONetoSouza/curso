package br.com.dld.aula1.repositories;

import org.springframework.stereotype.Repository;

public interface ItemPedidoRepository {

    @Repository
    public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
