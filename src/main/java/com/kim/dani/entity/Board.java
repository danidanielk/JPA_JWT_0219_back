package com.kim.dani.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = true)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "users_id")
    Users users;

}
