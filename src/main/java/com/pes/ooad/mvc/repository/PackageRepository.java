package com.pes.ooad.mvc.repository;

import com.pes.ooad.mvc.model.PackageRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<PackageRecord, Long> {
    boolean existsByTrackingId(String trackingId);
    Optional<PackageRecord> findByTrackingId(String trackingId);
}
