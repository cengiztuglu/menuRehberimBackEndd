package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Menu implements Serializable {

    @Id
    @SequenceGenerator(name="seq_menu_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_menu_info", strategy = GenerationType.SEQUENCE)
    private long id;



    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;



}