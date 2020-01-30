package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.UsersInstruments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersInstrumentsRepository extends JpaRepository<UsersInstruments, Long> {
}
