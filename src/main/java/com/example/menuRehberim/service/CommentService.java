package com.example.menuRehberim.service;


import com.example.menuRehberim.dto.CommentDto;

public interface CommentService {
    CommentDto save(CommentDto commentDto, String userName);

}
