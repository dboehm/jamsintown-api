package com.example.postgresdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode // (exclude = "publishers")
@Entity
@Table(name = "experience_level") //, catalog = "postgres", schema = "user")
public class ExperienceLevel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "experience_level_generator")
    @SequenceGenerator(
            name = "experience_level_generator",
            sequenceName = "experience_level_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

}
