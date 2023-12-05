package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "restouran_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Restourant implements Serializable {

    @Id
    @SequenceGenerator(name="seq_restouran_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_restouran_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String restourantName;
    private String restourantPassword;
    @OneToOne(mappedBy = "restourant", cascade = CascadeType.ALL)
    private Place placeInfo;

}
