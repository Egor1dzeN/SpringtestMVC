package com.egor.SpringtestMVC.Controllers;

import com.egor.SpringtestMVC.models.Post;
import com.egor.SpringtestMVC.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("name","egor");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","О нас");
        return "aboutUS";
    }
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blog_main(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "blog_main";
    }


}