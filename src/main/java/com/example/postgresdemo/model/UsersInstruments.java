package com.example.postgresdemo.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@ToString // (exclude = {"user", "instrument"})
@EqualsAndHashCode // (exclude = {"user", "instrument"})
@Entity
@Table(name = "users_instruments") //, catalog = "postgres", schema = "user")
public class UsersInstruments extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "users_instruments_generator")
    @SequenceGenerator(
            name = "users_instruments_generator",
            sequenceName = "users_instruments_sequence",
            initialValue = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    Instrument instrument;
}
