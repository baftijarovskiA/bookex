package com.bookex.eBookExchange.Api;

import com.bookex.eBookExchange.Model.Post;
import com.bookex.eBookExchange.Service.Impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/post")
public class PostApiController {

    private PostServiceImpl postService;

    public PostApiController(PostServiceImpl postService) { this.postService = postService; }

    @GetMapping
    public List<Post> getAllPosts(){ return postService.getAllPosts(); }

    @RequestMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }

    @PostMapping
    public Post addNewPost(@Valid @RequestBody Post post){
        return postService.addNewPost(post);
    }

    @DeleteMapping("/{id}")
    public Post deletePostById(@PathVariable("id") Long id){ return postService.deletePostById(id); }

    @PutMapping("/{id}")
    public Post updatePostById(@PathVariable("id") Long id, @Valid @RequestBody Post post){
        return postService.updatePostById(id, post);
    }
}
