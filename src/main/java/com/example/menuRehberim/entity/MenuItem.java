package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "menuItem_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class MenuItem implements Serializable {

    @Id
    @SequenceGenerator(name="seq_menuItem_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_menuItem_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String itemName;
    private String itemDefinition;
    private  byte[] itemPicName;
    private String itemPrice;
    private  String itemCategory;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
