package com.example.menuRehberim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment_info1")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Comment {
    @Id
    @SequenceGenerator(name="seq_comment_info1",allocationSize = 1)
    @GeneratedValue(generator = "seq_comment_info1", strategy = GenerationType.SEQUENCE)
    private long id;
    private String commentText;
    private Long score;
    private Long itemId;
    private Date commentDate;
    @ManyToOne
    @JoinColumn(name = "user_id") // Kullanıcı ID'si ile ilişkilendirme
    private User user;
}
