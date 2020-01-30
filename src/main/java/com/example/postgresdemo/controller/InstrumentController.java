package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceAlreadyExistentException;
import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.ExperienceLevel;
import com.example.postgresdemo.model.Instrument;
import com.example.postgresdemo.model.User;
import com.example.postgresdemo.model.UsersInstruments;
import com.example.postgresdemo.repository.InstrumentRepository;
import com.example.postgresdemo.repository.UserRepository;
import com.example.postgresdemo.repository.UsersInstrumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InstrumentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InstrumentRepository instrumentRepository;

    @Autowired
    UsersInstrumentsRepository usersInstrumentsRepository;

    @GetMapping("/instruments")
    public Page<Instrument> getInstruments(Pageable pageable) {
        return instrumentRepository.findAll(pageable);
    }

    @GetMapping("/instruments/{instrumentId}")
    public Instrument getExperienceLevelById(@PathVariable Long instrumentId) {
        return instrumentRepository.findById(instrumentId).orElseThrow(()
                -> new ResourceNotFoundException("instrumentId not found with id " + instrumentId));
    }

    @GetMapping("/instruments/{instrumentId}/users")
    public List<User> getUserByInstrumentId(@PathVariable Long instrumentId) {
        List<User> userList = new ArrayList<>();
        List<UsersInstruments> usersInstrumentsList =
                usersInstrumentsRepository.findAll();

        for (UsersInstruments usersInstruments : usersInstrumentsList) {
            if (usersInstruments.getInstrument().getId().equals(instrumentId)) {
                userList.add(usersInstruments.getUser());
            }
        }
        return userList;
    }

    @PostMapping("/instruments")
    public Instrument createInstrument(@Valid @RequestBody Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @PostMapping("/instruments/{instrumentId}/users/{userId}")
    public UsersInstruments addUserToInstrument(@PathVariable Long instrumentId,
                                                @PathVariable Long userId,
                                                @Valid @RequestBody
                                                        UsersInstruments usersInstrumentsRequest)
    {
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
                .stream().filter(s-> s.getInstrument().getId().equals(instrumentId))
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


    @PutMapping("/instruments/{instrumentId}")
    public Instrument updateInstrument(@PathVariable Long instrumentId,
                                       @Valid @RequestBody Instrument instrumentRequest) {
        return instrumentRepository.findById(instrumentId)
                .map(instrument -> {
                    instrument.setInstrumentName(instrumentRequest.getInstrumentName());
                    return instrumentRepository.save(instrument);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + instrumentId));
    }


    @DeleteMapping("/instruments/{instrumentId}")
    public ResponseEntity<?> deleteInstrument(@PathVariable Long instrumentId) {
        return instrumentRepository.findById(instrumentId)
                .map(instrument -> {
                    instrumentRepository.delete(instrument);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + instrumentId));
    }
}
