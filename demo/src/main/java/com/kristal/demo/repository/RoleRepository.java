package com.kristal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kristal.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	
}
