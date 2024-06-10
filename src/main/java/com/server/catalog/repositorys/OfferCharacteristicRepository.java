package com.server.catalog.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.catalog.models.Offer;
import com.server.catalog.models.OfferCharacteristic;

@Repository
public interface OfferCharacteristicRepository extends JpaRepository<OfferCharacteristic, Long> {

	List<OfferCharacteristic> findByOffer(Offer offer);

	void deleteAllByOffer(Offer offer);

	
	
}
