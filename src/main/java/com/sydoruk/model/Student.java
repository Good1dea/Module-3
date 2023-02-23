package com.sydoruk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String firstName;
    private String lastName;
    private Timestamp ts;
    private int age;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_group")
    private StudentGroup group;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public Student(String firstName, String lastName, int age, Timestamp ts, StudentGroup group, List<Rating> ratings ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ts = ts;
        this.group = group;
        this.ratings = ratings;
    }
}