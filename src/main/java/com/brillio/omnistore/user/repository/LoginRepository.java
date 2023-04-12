package com.brillio.omnistore.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	Optional<Login> findByUsername(String username);

	Boolean existsByUsername(String username);

}
