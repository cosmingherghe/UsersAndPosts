package dev.cosmingherghe.rest.webservices.restfulwebservices.controllers;

import dev.cosmingherghe.rest.webservices.restfulwebservices.services.PostDaoService;
import dev.cosmingherghe.rest.webservices.restfulwebservices.services.UserDaoService;
import dev.cosmingherghe.rest.webservices.restfulwebservices.users.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postDaoService;

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users/{userId}/posts")
    private List<Post> getAllPosts(@PathVariable Integer userId) {
        return postDaoService.findAllFromUser(userId);
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    private Post getPost(@PathVariable Integer userId,@PathVariable Integer postId) {
        return postDaoService.findOne(userId, postId);
    }

    @PostMapping("/users/{userId}/posts")
    private void createPost(@RequestBody Post post) {
        if(userDaoService.findUserById(post.getUserId()) != null) {
            postDaoService.save(post);
        }
    }
}
