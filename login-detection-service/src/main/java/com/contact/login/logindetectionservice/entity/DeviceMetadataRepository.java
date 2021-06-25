package com.contact.login.logindetectionservice.entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Integer> {

  List<DeviceMetadata> findByUserId(Long userId);
}
