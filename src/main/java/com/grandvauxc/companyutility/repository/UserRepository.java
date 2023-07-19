package com.grandvauxc.companyutility.repository;

import com.grandvauxc.companyutility.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CompanyUtilityRepository<User, UUID> {

    Optional<User> findByKeycloakId(UUID keycloakId);
}
