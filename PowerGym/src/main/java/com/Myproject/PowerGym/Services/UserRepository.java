package com.Myproject.PowerGym.Services;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Myproject.PowerGym.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	

}
