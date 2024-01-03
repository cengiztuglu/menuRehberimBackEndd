package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "comment_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Comment {
    @Id
    @SequenceGenerator(name="seq_comment_info",allocationSize = 1)
    @GeneratedValue(generator = "seq_comment_info", strategy = GenerationType.SEQUENCE)
    private long id;
    private String commentText;
    private String score;
    private Long itemId;
    @ManyToOne
    @JoinColumn(name = "user_id") // Kullanıcı ID'si ile ilişkilendirme
    private User user;
}
