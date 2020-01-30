package com.example.postgresdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode // (exclude = "publishers")
@Entity
@Table(name = "user_instrument_experience") //, schema = "users", catalog = "jamsintown")
public class UserInstrumentExperience extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "user_instrument_experience_generator")
    @SequenceGenerator(
            name = "user_instrument_experience_generator",
            sequenceName = "user_instrument_experience_sequence",
            initialValue = 1
    )
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    Instrument instrument;


    //@ManyToOne
    //@JoinColumn(name = "user_instr_id")
    //UsersInstruments usersInstruments;

    // private Integer userId;
    // private Integer instrId;

    @Column(name = "experience_start_date_estimate", nullable = false)
    private Date experienceStartDateEstimate;

    @OneToOne
    @JoinColumn(name="exp_id", nullable = true, insertable=true, updatable=true)
    //@Column(name = "experience_level")
    ExperienceLevel experienceLevel;










}
