package com.emeraldhieu.app.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> listComments() {
        return commentService.getComments();
    }

    @GetMapping("failed")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> failToListComments() {
        return commentService.failToGetComments();
    }
}
