package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByPesel(String pesel);
    Optional<Client> findByPesel(String pesel);
}