package com.studyproject.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name="USER")
@Getter
@Setter
public class LoginEntity {
    @Id
    private String id;

    private String password;
}
