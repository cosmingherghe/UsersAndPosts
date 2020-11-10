package dev.cosmingherghe.rest.webservices.restfulwebservices.services;

import dev.cosmingherghe.rest.webservices.restfulwebservices.users.Post;
import dev.cosmingherghe.rest.webservices.restfulwebservices.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {

    @Autowired
    UserDaoService userDaoService;

    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(0,0,"A plateau is the highest form of flattery." ));
        posts.add(new Post(1,0,"It’s hard to explain puns to kleptomaniacs because they always take things literally." ));
        posts.add(new Post(2,0,"Time flies like an arrow, fruit flies like a banana." ));
        posts.add(new Post(0,1,"A soldier survived mustard gas in battle, and then pepper spray by the police. He's now a seasoned veteran." ));
        posts.add(new Post(1,1,"I'm addicted to brake fluid, but I can stop whenever I want." ));
        posts.add(new Post(0,2,"I told my doctor that I broke my arm in two places. He told me to stop going to those places." ));
        posts.add(new Post(1,2,"What's orange and sounds like a parrot? A carrot." ));
        posts.add(new Post(2,2,"I went on a once in a lifetime holiday. Never again." ));
        posts.add(new Post(3,2,"I asked my North Korean friend how it was there, he said he couldn't complain." ));
    }

    public List<Post> findAll() {
        return posts;
    }

    public List<Post> findAllFromUser(int userId) {
        List<Post> postsFromUser = new ArrayList<>();

        for(Post post:posts)
            if(userId == post.getUserId()) {
                postsFromUser.add(post);
            }
        return postsFromUser;
    }

    public Post save(Post post) {
        User user = userDaoService.findUserById(post.getUserId());
        user.setPostCount(user.getPostCount() + 1);

        posts.add(post);

        return post;
    }

    public Post findOne(Integer userId, Integer postId) {
        for(Post post:posts)
            if(userId == post.getUserId() && postId == post.getId()) {
                return post;
            }
        return null;
    }
}