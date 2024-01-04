package com.example.menuRehberim.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private long id;
    private String commentText;
    private Long score;
    private Long itemId;
    private Date commentDate;
    private String userName;
}
