package com.gabrielteodoro.trackassets.repository;

import com.gabrielteodoro.trackassets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
