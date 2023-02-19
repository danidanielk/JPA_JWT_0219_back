package com.kim.dani.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class JoinDto {


    private String name;

    private String phone;

    private String email;

    private String password;


}
