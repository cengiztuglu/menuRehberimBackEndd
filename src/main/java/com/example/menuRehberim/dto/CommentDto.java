package com.example.menuRehberim.dto;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String commentText;
    private String score;
    private Long itemId;
}
