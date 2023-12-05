package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "plac_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Place implements Serializable {

    @Id
    @SequenceGenerator(name="seq_plac_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_plac_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String placeDefinition;
    private String placeAdress;
    private  String placeBgPicName;
    private  String category;

    @OneToOne
    @JoinColumn(name = "restourant_id")
    private Restourant restourant;
    @OneToOne(mappedBy = "place")
    private Menu menu;

}