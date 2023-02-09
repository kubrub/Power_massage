package com.powermassage.web.controllers;

import com.powermassage.web.models.Comment;
import com.powermassage.web.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    @GetMapping("/all")
    public String allResponse(Model model){
        Iterable<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "all-response";
    }

    @GetMapping("/add")
    public String responseAdd(Model model){
        return "add-response";
    }
    @PostMapping("/add")
    public String responsePostAdd(@RequestParam String name, @RequestParam String respond, Model model){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Comment comment = new Comment(name, respond, formatter.format(date));
        commentRepository.save(comment);
        return "redirect:/";
    }
}