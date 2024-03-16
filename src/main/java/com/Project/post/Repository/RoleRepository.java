package com.Project.post.Repository;

import com.Project.post.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

  Optional<Role> findByName(String name);
}
