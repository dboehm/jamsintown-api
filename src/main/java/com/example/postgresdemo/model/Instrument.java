package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString (exclude = {"usersInstruments", "userInstrumentExperienceSet"})
@EqualsAndHashCode // (exclude = "publishers")
@Entity
@Table(name = "instruments") //, catalog = "postgres", schema = "user")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = User.class)
public class Instrument extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public Instrument(String name) {
        this.instrumentName = name;
        usersInstruments = new HashSet<>();
    }

    @Id
    @GeneratedValue(generator = "instruments_generator")
    @SequenceGenerator(
            name = "instruments_generator",
            sequenceName = "instruments_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "instrument_name", nullable = false)
    private String instrumentName;

    @OneToMany(mappedBy = "instrument") //, cascade = CascadeType.ALL, orphanRemoval = true)//, fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
     private Set<UsersInstruments> usersInstruments;

    @OneToMany(mappedBy = "instrument")//, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
    private Set<UserInstrumentExperience> userInstrumentExperienceSet;


}
