package com.example.menuRehberim.service.implementation;

import com.example.menuRehberim.dto.CommentDto;
import com.example.menuRehberim.dto.MenuItemDto;
import com.example.menuRehberim.entity.Comment;
import com.example.menuRehberim.entity.Menu;
import com.example.menuRehberim.entity.MenuItem;
import com.example.menuRehberim.entity.User;
import com.example.menuRehberim.repository.CommentRepository;
import com.example.menuRehberim.repository.UserRepository;
import com.example.menuRehberim.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentDto save(CommentDto commentDto, String userName) {
        User user = userRepository.findByUserName(userName);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommentText(commentDto.getCommentText());
        comment.setScore(commentDto.getScore());
        comment.setItemId(commentDto.getItemId());
        comment.setCommentDate(commentDto.getCommentDate());
        commentRepository.save(comment);

        return commentDto;
    }


    @Override
    public List<CommentDto> getMenuItemComments(Long itemId) {
        List<Comment> comments = commentRepository.findByItemId(itemId);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentText(comment.getCommentText());
            commentDto.setScore(comment.getScore());
            commentDto.setItemId(comment.getItemId());
            commentDto.setCommentDate(comment.getCommentDate());

            User user = comment.getUser();
            if (user != null) {
                Long userId = user.getId();
                String username = user.getUserName();
                commentDto.setUserName(username);
            }

            commentDtos.add(commentDto);
        }

        return commentDtos;

    }
}
