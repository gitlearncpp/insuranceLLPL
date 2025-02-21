package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByPesel(String pesel);
}