package com.example.hbv501g.Contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hbv501g.Persistence.Entities.Forum;
import com.example.hbv501g.Persistence.Entities.Post;
import com.example.hbv501g.Persistence.Entities.User;
import com.example.hbv501g.Services.ForumService;
import com.example.hbv501g.Services.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {

    private PostService postService;
    private ForumService forumService;

    @Autowired
    public PostController(PostService postService, ForumService forumService){
        this.postService = postService;
        this.forumService = forumService;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public String addPostForm(Post post){
        return "newPost";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String addPost( Post post, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "newPost";
        }

        User loggedInUser = (User) session.getAttribute("LoggedInUser");
        System.out.println(loggedInUser.getUserId());
        Forum forumData = (Forum) session.getAttribute("ForumData");

        
        
        if (loggedInUser != null) {

            // setja user sem creator
            post.setUser(loggedInUser);
            post.setForum(forumData);
            postService.save(post);
            
            //System.out.println("Forum creater: " + loggedInUser.getUsername());
            return "redirect:";
        } else {
            return "redirect:";
        }
        
    }

    @RequestMapping(value = "/posts/delete/{postId}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("postId") long id, Model model){
        Post postToDelete = postService.findById(id);
        postService.delete(postToDelete);
        return "redirect:/";
    }
}
