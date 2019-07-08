package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post addNewPost(Post post);

    Post deletePostById(Long id);

    Post updatePostById(Long id, Post post);
}
