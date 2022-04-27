package br.com.estoque.repository;

import br.com.estoque.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienttRepository extends JpaRepository<Client, Integer> {
}
