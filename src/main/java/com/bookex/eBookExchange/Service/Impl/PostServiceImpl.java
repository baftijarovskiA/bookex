package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Post;
import com.bookex.eBookExchange.Repository.Impl.PostRepositoryImpl;
import com.bookex.eBookExchange.Service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepositoryImpl repository;

    public PostServiceImpl(PostRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> getAllPosts() {
        return repository.getAllPosts();
    }

    @Override
    public Post getPostById(Long id) {
        return repository.getPostById(id);
    }

    @Override
    public Post addNewPost(Post post) {
        return repository.addNewPost(post);
    }

    @Override
    public Post deletePostById(Long id) {
        return repository.deletePostById(id);
    }

    @Override
    public Post updatePostById(Long id, Post post) {
        return repository.updatePostById(id,post);
    }
}
