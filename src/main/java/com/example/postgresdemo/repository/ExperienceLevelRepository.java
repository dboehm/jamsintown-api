package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.ExperienceLevel;
import com.example.postgresdemo.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceLevelRepository extends JpaRepository<ExperienceLevel, Long> {
}