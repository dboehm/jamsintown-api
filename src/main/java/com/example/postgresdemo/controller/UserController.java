package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceAlreadyExistentException;
import com.example.postgresdemo.exception.ResourceCorrelationNotUniqueException;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.*;
import com.example.postgresdemo.repository.InstrumentRepository;
import com.example.postgresdemo.repository.UserInstrumentsExperienceRepository;
import com.example.postgresdemo.repository.UserRepository;
import com.example.postgresdemo.repository.UsersInstrumentsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersInstrumentsRepository usersInstrumentsRepository;

    @Autowired
    InstrumentRepository instrumentRepository;

    @Autowired
    UserInstrumentsExperienceRepository userInstrumentsExperienceRepository;

    @Autowired
    ExpirienceLevelController expirienceLevelController;


    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/users/{userId}")
    public User getExperienceLevelById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @GetMapping("/users/{userId}/instruments")
    public List<Instrument> getInstrumentsByUserId(@PathVariable Long userId) {
        List<Instrument> instrumentList = new ArrayList<>();
        List<UsersInstruments> usersInstrumentsList =
                usersInstrumentsRepository.findAll();
        log.info(String.format("usersInstrumentsList.size %d", usersInstrumentsList.size()));
        for (UsersInstruments usersInstruments : usersInstrumentsList) {
            log.info(String.format("usersInstruments %s", usersInstruments));
            log.info(String.format("usersInstruments.getUser %s", usersInstruments.getUser()));
            log.info(String.format("usersInstruments.getUser,getId %d", usersInstruments.getUser().getId()));
            log.info(String.format("usersInstruments.getInstrument %s", usersInstruments.getInstrument()));
            if (usersInstruments.getUser().getId().equals(userId)) {
                instrumentList.add(usersInstruments.getInstrument());
            }
            log.info(String.format("instrumentList %s", instrumentList));
        }
        return instrumentList;
    }


    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/users/{userId}/instruments/{instrumentId}")
    public UsersInstruments addInstrumentToUser(@PathVariable Long userId,
                                                @PathVariable Long instrumentId,
                                                @Valid @RequestBody
                                                        UsersInstruments usersInstrumentsRequest) {
        if (!instrumentRepository.existsById(instrumentId)) {
            throw new ResourceNotFoundException("Instrument not found with id " + instrumentId);
        }
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }
        // check if the correlation already exists
        List<UsersInstruments> usersInstrumentsList = usersInstrumentsRepository.findAll()
                .stream().filter(t -> t.getUser().getId().equals(userId))
                .collect(Collectors.toList())
                .stream().filter(s -> s.getInstrument().getId().equals(instrumentId))
                .collect(Collectors.toList());
        if (usersInstrumentsList.size() > 0) {
            throw new ResourceAlreadyExistentException(String.format("Instrument '%d' and User '%d' corellation already present ", instrumentId, userId));
        } else {
            UsersInstruments usersInstruments = new UsersInstruments();
            usersInstruments.setUser(userRepository.getOne(userId));
            usersInstruments.setInstrument(instrumentRepository.getOne(instrumentId));
            return usersInstrumentsRepository.save(usersInstruments);
        }
    }

    @PostMapping("/users/{userId}/instruments/{instrumentId}/exp-level/{expLevelId}")
    public UserInstrumentExperience addExperienceToUserInstrument(@PathVariable Long userId,
                                                                  @PathVariable Long instrumentId,
                                                                  @PathVariable Long expLevelId,
                                                                  @Valid @RequestBody
                                                                          UserInstrumentExperience userInstrumentExperienceRequest) {
        ExperienceLevel experienceLevel = expirienceLevelController.getExperienceLevelById(expLevelId);
        log.debug(String.format("exp-level %s", experienceLevel));
        Instrument instrument = null;
        User user = null;
        if (!instrumentRepository.existsById(instrumentId)) {
            throw new ResourceNotFoundException("Instrument not found with id " + instrumentId);
        } else instrument = instrumentRepository.findById(instrumentId).get();
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        } else user = userRepository.findById(userId).get();
        UserInstrumentExperience userInstrumentExperience = new UserInstrumentExperience();
        // check if the correlation already exists
        log.debug(String.format("usersInstrumentsRepository.size %s", usersInstrumentsRepository.findAll().size()));
        List<UsersInstruments> usersInstrumentsList = usersInstrumentsRepository.findAll()
                .stream().filter(t -> t.getUser().getId().equals(userId))
                .collect(Collectors.toList())
                .stream().filter(s -> s.getInstrument().getId().equals(instrumentId))
                .collect(Collectors.toList());

        if (usersInstrumentsList.size() == 0) {
            throw new ResourceNotFoundException(String.format("Instrument '%d' and User '%d' correlation NOT exists  ", instrumentId, userId));
        } else if (usersInstrumentsList.size() > 1)
            throw new ResourceCorrelationNotUniqueException(String.format("Instrument '%d' and User '%d' correlation NOT UNIQUE  ", instrumentId, userId));
        else {
            log.debug(String.format("usersInstrumentsList.size %s", usersInstrumentsList.size()));
            // userInstrumentExperience.setUsersInstruments(usersInstrumentsList.get(0));
        }
        log.debug(String.format("%s user", "Get the "));

        log.debug(String.format("user %s", user));
        userInstrumentExperience.setUser(user);
        userInstrumentExperience.setInstrument(instrument);
        userInstrumentExperience.setExperienceLevel(experienceLevel);
        userInstrumentExperience.setExperienceStartDateEstimate(userInstrumentExperienceRequest.getExperienceStartDateEstimate());
        log.debug(String.format("userInstrumentExperience %s", userInstrumentExperience));
        return userInstrumentsExperienceRepository.save(userInstrumentExperience);
    }


    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id,
                           @Valid @RequestBody User userRequest) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userRequest.getUsername());
                    user.setEmail(userRequest.getEmail());
                    user.setVorname(userRequest.getVorname());
                    user.setNachname(userRequest.getNachname());
                    user.setEntryDate(userRequest.getEntryDate());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }
}
