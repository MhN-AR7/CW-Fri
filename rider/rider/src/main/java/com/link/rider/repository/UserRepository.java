package com.link.rider.repository;

import com.link.rider.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
    Optional<UserDao> findByUsername(String username);

    boolean existsByUsername(String username);
}
