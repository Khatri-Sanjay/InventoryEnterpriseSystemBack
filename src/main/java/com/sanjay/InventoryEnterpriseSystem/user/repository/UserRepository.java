package com.sanjay.InventoryEnterpriseSystem.user.repository;

import com.sanjay.InventoryEnterpriseSystem.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
