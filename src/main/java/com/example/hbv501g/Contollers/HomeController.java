package com.example.hbv501g.Contollers;
import com.example.hbv501g.Persistence.Entities.Post;
import com.example.hbv501g.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class HomeController {
    private PostService postService;

    @Autowired
    public HomeController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping("/")
    public String homePage(Model model){
        //call a method in a Service Class
        List<Post> allPosts = postService.findAll();
        //Add some data to the Model
        model.addAttribute("posts", allPosts);
        return "home";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public String addPageForm(Post post){
        return "newPost";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String addPost(Post post, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newPost";
        }
        postService.save(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{postId}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("postId") long id, Model model){
        Post postToDelete = postService.findById(id);
        postService.delete(postToDelete);
        return "redirect:/";
    }
}
