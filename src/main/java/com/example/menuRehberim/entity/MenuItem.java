package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "menuIte_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class MenuItem implements Serializable {

    @Id
    @SequenceGenerator(name="seq_menuIte_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_menuIte_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String itemName;
    private String itemDefinition;
    private  String itemPicName;
    private String itemPrice;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
