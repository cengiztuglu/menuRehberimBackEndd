package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

    @Id
    @SequenceGenerator(name="seq_user_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_user_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surName;
    private String eMail;
    private String userName;
    private String password;
}
