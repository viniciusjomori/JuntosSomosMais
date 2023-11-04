package br.edu.ifsp.spo.JuntosSomosMais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.spo.JuntosSomosMais.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
