package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.User;
import com.example.postgresdemo.model.UserInstrumentExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInstrumentsExperienceRepository extends JpaRepository<UserInstrumentExperience, Long> {
}