package me.jinuk;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final BlogMapper blogMapper;

    public BlogController(BlogMapper blogMapper) {this.blogMapper = blogMapper;}

    @GetMapping("/blogs/{blog_id}")
    public Blog getBlog(@PathVariable("blog_id") String blog_id) {
        return blogMapper.getBlog(blog_id);
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogList() {
        return blogMapper.getBlogList();
    }

    @PostMapping("/blogs")
    public int insertBlog(@RequestBody Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @PutMapping("/blogs/{blog_id}")
    public int updateBlog(@PathVariable("blog_id") String blog_id, @RequestBody Blog blog) {
        return blogMapper.updateBlog(blog_id, blog);
    }

    @DeleteMapping("/blogs/{blog_id}")
    public int deleteBlog(@PathVariable("blog_id") Integer blog_id) {
        return blogMapper.deleteBlog(blog_id);
    }

}
