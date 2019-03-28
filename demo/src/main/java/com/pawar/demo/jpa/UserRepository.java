package com.pawar.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawar.demo.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
