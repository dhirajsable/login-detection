package com.contact.login.logindetectionservice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Integer> {
}
