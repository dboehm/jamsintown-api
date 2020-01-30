package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString (exclude = {"usersInstruments", "userInstrumentExperienceSet"})
@EqualsAndHashCode // (exclude = {"usersInstruments", "userInstrumentExperienceSet"})
@Entity
@Table(name = "users") //, catalog = "postgres", schema = "user")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = User.class)
public class User extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "users_generator")
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "vorname", nullable = true)
    private String vorname;

    @Column(name = "nachname", nullable = true)
    private String nachname;

    @Column(name = "entry_date", nullable = true)
    private Date entryDate;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL, orphanRemoval = true) //, fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JsonIgnore
    private Set<UsersInstruments> usersInstruments;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL, orphanRemoval = true) //, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UserInstrumentExperience> userInstrumentExperienceSet;

}
