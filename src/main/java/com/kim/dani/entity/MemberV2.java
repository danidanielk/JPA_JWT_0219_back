package com.kim.dani.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberV2 {

    @Id //primarykey
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;
}


