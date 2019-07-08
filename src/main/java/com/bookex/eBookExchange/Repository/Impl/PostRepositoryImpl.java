package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Post;
import com.bookex.eBookExchange.Repository.JpaRepository.PostJpaRepository;
import com.bookex.eBookExchange.Repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private PostJpaRepository repository;

    public PostRepositoryImpl(PostJpaRepository repository) { this.repository = repository; }

    @Override
    public List<Post> getAllPosts() {
        return repository.sortedPostsByDate();
    }

    @Override
    public Post getPostById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Post addNewPost(Post post) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        post.setCreated_at(localTimeString);
        post.setUpdated_at(localTimeString);
        repository.save(post);
        return post;
    }

    @Override
    public Post deletePostById(Long id) {
        Optional<Post> post = repository.findById(id);
        repository.delete(post.get());
        return post.get();
    }

    @Override
    public Post updatePostById(Long id, Post post) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        Post p = repository.findById(id).get();

        p.setUpdated_at(localTimeString);
        p.setTitle(post.getTitle());
        p.setDescription(post.getDescription());
        p.setPicture(post.getPicture());
        repository.save(p);

        return p;
    }
}
