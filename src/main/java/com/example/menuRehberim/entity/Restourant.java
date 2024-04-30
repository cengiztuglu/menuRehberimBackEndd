package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "restourant_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Restourant implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_restourant_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_restourant_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surName;
    private String eMail;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "restourant", cascade = CascadeType.ALL)
    private Place placeInfo;
    @OneToOne(mappedBy = "restourant", cascade = CascadeType.ALL)
    private Menu menuInfo;

}
