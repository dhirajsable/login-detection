package com.contact.login.logindetectionservice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Integer> {

    List<DeviceMetadata> findByUserId(Long userId);
}
