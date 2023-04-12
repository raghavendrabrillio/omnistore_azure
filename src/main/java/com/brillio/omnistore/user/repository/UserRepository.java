package com.brillio.omnistore.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByTypeIn(List<String> types);

}
