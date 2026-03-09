package com.pes.ooad.mvc.service;

import com.pes.ooad.mvc.model.PackageRecord;
import com.pes.ooad.mvc.repository.PackageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public PackageRecord savePackage(PackageRecord packageRecord) {
        validateRequiredFields(packageRecord);

        if (packageRepository.existsByTrackingId(packageRecord.getTrackingId())) {
            throw new IllegalArgumentException("Tracking ID already exists: " + packageRecord.getTrackingId());
        }

        return packageRepository.save(packageRecord);
    }

    public List<PackageRecord> getAllPackages() {
        return packageRepository.findAll();
    }

    public Optional<PackageRecord> getByTrackingId(String trackingId) {
        return packageRepository.findByTrackingId(trackingId);
    }

    private void validateRequiredFields(PackageRecord packageRecord) {
        if (!StringUtils.hasText(packageRecord.getTrackingId())
                || !StringUtils.hasText(packageRecord.getSenderName())
                || !StringUtils.hasText(packageRecord.getReceiverName())
                || !StringUtils.hasText(packageRecord.getDestinationCity())
                || !StringUtils.hasText(packageRecord.getDeliveryStatus())) {
            throw new IllegalArgumentException("All fields are required.");
        }
    }
}
