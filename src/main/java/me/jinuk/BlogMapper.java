package me.jinuk;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface BlogMapper {

    @Select("SELECT * FROM blogs WHERE ID=#{id}")
    Blog getBlog(@Param("id") String id);

    @Select("SELECT * FROM blogs")
    List<Blog> getBlogList();

    @Insert("INSERT INTO blogs(title, description) VALUES(#{blog.title}, #{blog.description})")
    int insertBlog(@Param("blog") @RequestBody Blog blog);

    @Update("UPDATE blogs SET TITLE=#{blog.title}, DESCRIPTION=#{blog.description} WHERE ID=#{id}")
    int updateBlog(@Param("id") String id, @Param("blog") @RequestBody Blog blog);

    @Delete("DELETE FROM blogs WHERE ID=#{id}")
    int deleteBlog(@Param("id") Integer id);
}
