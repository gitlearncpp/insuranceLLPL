package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByClientId(Long clientId);
}