package com.egor.SpringtestMVC.Controllers;

import com.egor.SpringtestMVC.models.Post;
import com.egor.SpringtestMVC.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


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
    public  void fjf(){

        Iterable<Post> posts1 =  postRepository.findAll();
        for(Post post: posts1){
            System.out.println(post.getViews());
        }
    }

    @GetMapping("/blog")
    public String blog_main( Model model){

        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "blog_main";
    }
    @GetMapping("/blog/add")
    public String blog_add(Model model){
        return "blog_add";
    }
    @PostMapping("/blog/add")
    public String block_post_add(@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model){
        Post post = new Post(title,anons,full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}")
    public String blog_details(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
           // System.out.println("opaoappapapa");
            return "blog_main";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog_details";
    }

}