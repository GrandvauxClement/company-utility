package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.entity.User;
import com.grandvauxc.companyutility.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends AbstractService<User, UUID, UserRepository> {

    public UserService() {
    }

    public UserService(UserRepository repository) {
        super(repository);
    }

    public User findByKeycloakId(UUID keycloakId){
        return repository.findByKeycloakId(keycloakId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
