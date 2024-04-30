package com.example.menuRehberim.service;


import com.example.menuRehberim.dto.CommentDto;
import com.example.menuRehberim.dto.MenuItemDto;

import java.util.List;

public interface CommentService {
    CommentDto save(CommentDto commentDto, String userName);
    List<CommentDto> getMenuItemComments(Long itemId);
}
