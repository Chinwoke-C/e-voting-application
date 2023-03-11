package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
