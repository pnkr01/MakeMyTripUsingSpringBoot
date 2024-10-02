package com.pawan.dreambuy.repository.auth;

import com.pawan.dreambuy.model.Package;
import com.pawan.dreambuy.model.auth.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignUpRepository extends JpaRepository<UserRegistration,Integer> {
    UserRegistration findByUserName(String username);
}
