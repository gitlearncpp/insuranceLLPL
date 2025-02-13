package org.llpl.insurance_llpl.repository;

import org.llpl.insurance_llpl.model.InsuranceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfferRepository extends JpaRepository<InsuranceOffer, Long> {
    List<InsuranceOffer> findByClientId(Long clientId);
    List<InsuranceOffer> findByPropertyId(Long propertyId);
}