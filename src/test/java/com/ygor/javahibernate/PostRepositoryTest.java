package com.ygor.javahibernate;

import com.ygor.javahibernate.model.Comment;
import com.ygor.javahibernate.model.Post;
import com.ygor.javahibernate.repository.PostRepository;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryTest {

    private PostRepository postRepository = new PostRepository();

    @Test
    public void getPostById() {
        int id = 1;

        Post post = postRepository.getById(id);

        assertNotNull(post);

        printPost(post);

        if (!post.getComments().isEmpty()) {

            for (Comment comment : post.getComments()) {
                printComment(comment);
            }

        }
    }

    @Test
    public void getAllPosts() {
        List<Post> posts = postRepository.getAll();

        assertNotNull(posts);

        for (Post post : posts) {
            printPost(post);
            System.out.println("-------------------------------");
        }
    }

    @Test
    public void createPost() {
        Post post = new Post("My Title", "This is my content", new Timestamp(System.currentTimeMillis()));

        post.getComments().add(new Comment("Mike", "mike@gmail.com",
                "This is my comment in the post 1", new Timestamp(System.currentTimeMillis())));

        post.getComments().add(new Comment("Jack", "jack@gmail.com",
                "This is my comment in the post 1", new Timestamp(System.currentTimeMillis())));

        post.getComments().add(new Comment("Lisa", "lisa@gmail.com",
                "This is my comment in the post 1", new Timestamp(System.currentTimeMillis())));

        Post savedPost = postRepository.create(post);
        Post newPost = postRepository.getById(savedPost.getId());

        assertNotNull(newPost);
        assertNotNull(post.getComments());

        assertEquals("My Title", newPost.getTitle());
        assertEquals("This is my content", newPost.getContent());
        assertEquals(post.getCreatedOn(), newPost.getCreatedOn());

        printPost(post);

        for (Comment comment : post.getComments()) {
            System.out.println("--------------------------------");
            printComment(comment);
        }
    }

    @Test
    public void updatePost() {
        int id = 1;

        Post post = postRepository.getById(id);

        post.setTitle("Title edited");
        post.setContent("Content edited");

        postRepository.update(post);

        Post updatePost = postRepository.getById(id);

        assertNotNull(updatePost);
        assertEquals("Title edited", updatePost.getTitle());
        assertEquals("Content edited", updatePost.getContent());

        printPost(updatePost);
    }

    @Test
    public void removePost() {
        int id = 2;

        postRepository.remove(id);

        Post post = postRepository.getById(id);

        assertNull(post);
    }

    private void printPost(Post post) {
        System.out.println("ID: " + post.getId());
        System.out.println("TITLE: " + post.getTitle());
        System.out.println("CONTENT: " + post.getContent());
        System.out.println("CREATED ON: " + post.getCreatedOn());
    }

    private void printComment(Comment comment) {
        System.out.println("ID: " + comment.getId());
        System.out.println("NAME: " + comment.getName());
        System.out.println("EMAIL: " + comment.getEmail());
        System.out.println("CONTENT: " + comment.getContent());
        System.out.println("CREATED ON: " + comment.getCreatedOn());

    }


}
