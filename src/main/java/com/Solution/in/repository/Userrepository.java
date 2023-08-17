package com.Solution.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Solution.in.model.User;

public interface Userrepository extends JpaRepository<User, String>{

}
