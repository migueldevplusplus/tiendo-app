package com.miguelmora.tiendo_api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsernameAndDisabledAtIsNull(String username);

    Optional<User> findByIdAndDisabledAtIsNull(UUID id);
}