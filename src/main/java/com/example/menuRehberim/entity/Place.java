package com.example.menuRehberim.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "place_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Place implements Serializable {

    @Id
    @SequenceGenerator(name="seq_place_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_place_info", strategy = GenerationType.SEQUENCE)
    private long id;
    @Nullable
    private  String restourantName;
    private String placeDefinition;
    private String placeAdress;
    private  String placeBgPicName;
    private  String category;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private Restourant restourant;

    @OneToOne(mappedBy = "place")
    private Menu menu;

}