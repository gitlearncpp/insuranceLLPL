package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.InsuranceCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalculationRepository extends JpaRepository<InsuranceCalculation, Long> {
    List<InsuranceCalculation> findByClientId(Long clientId);
    List<InsuranceCalculation> findByPropertyId(Long propertyId);
}