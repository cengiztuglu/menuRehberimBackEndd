package com.example.menuRehberim.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
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
    @SequenceGenerator(name = "seq_place_info", allocationSize = 1)
    @GeneratedValue(generator = "seq_place_info", strategy = GenerationType.SEQUENCE)
    private long id;
    @Nullable
    private String restourantName;

    @Nullable
    private String placeDefinition;

    @Nullable
    private String placeAdress;

    private byte[] placeBgPicName;
    @Nullable
    private String category;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private Restourant restourant;


}