package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
