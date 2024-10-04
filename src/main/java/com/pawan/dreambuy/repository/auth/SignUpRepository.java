package com.pawan.dreambuy.repository.auth;
import com.pawan.dreambuy.model.auth.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<UserRegistration,Integer> {
    UserRegistration findByUserName(String username);
}
