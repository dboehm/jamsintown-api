package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.ExperienceLevel;
import com.example.postgresdemo.model.Instrument;
import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.ExperienceLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExpirienceLevelController {
    @Autowired
    ExperienceLevelRepository experienceLevelRepository;

    @GetMapping("/experience-level")
    public Page<ExperienceLevel> getExperienceLevel(Pageable pageable) {
        return experienceLevelRepository.findAll(pageable);
    }

    @GetMapping("/experience-level/{expLevelId}")
    public ExperienceLevel getExperienceLevelById(@PathVariable Long expLevelId) {
        return experienceLevelRepository.findById(expLevelId).orElseThrow(()
                -> new ResourceNotFoundException("ExperienceLevel not found with id " + expLevelId));
    }


    @PostMapping("/experience-level")
    public ExperienceLevel createExperienceLevel(@Valid @RequestBody ExperienceLevel experienceLevel) {
        return experienceLevelRepository.save(experienceLevel);
    }

    @PutMapping("/experience-level/{expLevelId}")
    public ExperienceLevel updateExperienceLevel(@PathVariable Long expLevelId,
                                       @Valid @RequestBody ExperienceLevel request) {
        return experienceLevelRepository.findById(expLevelId)
                .map(experienceLevel -> {
                    experienceLevel.setName(request.getName());
                    experienceLevel.setDescription((request.getDescription()));

                    return experienceLevelRepository.save(experienceLevel);
                }).orElseThrow(() -> new ResourceNotFoundException("ExperienceLevel not found with id " + expLevelId));
    }


    @DeleteMapping("/experience-level/{expLevelId}")
    public ResponseEntity<?> deleteInstrument(@PathVariable Long expLevelId) {
        return experienceLevelRepository.findById(expLevelId)
                .map(experienceLevel -> {
                    experienceLevelRepository.delete(experienceLevel);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ExperienceLevel not found with id " + expLevelId));
    }




}
