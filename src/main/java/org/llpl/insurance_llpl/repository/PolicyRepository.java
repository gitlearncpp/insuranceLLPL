package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    List<InsurancePolicy> findByClientId(Long clientId);
    Optional<InsurancePolicy> findByPolicyNumber(String policyNumber);
}