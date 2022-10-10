package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    public User findByEmailId(String emailId);
}
