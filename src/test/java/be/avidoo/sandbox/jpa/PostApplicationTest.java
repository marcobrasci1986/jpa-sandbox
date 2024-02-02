package be.avidoo.sandbox.jpa;

import be.avidoo.sandbox.jpa.model.Post;
import be.avidoo.sandbox.jpa.model.PostComment;
import be.avidoo.sandbox.jpa.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = JpaApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
class PostApplicationTest {

    @Autowired
    private PostRepository postRepository;


    @Test
    void name() {
        Post post = new Post("First post");

        post.addComment(
                new PostComment("My first review")
        );
        post.addComment(
                new PostComment("My second review")
        );
        post.addComment(
                new PostComment("My third review")
        );

        post.setId(1L);

        Post save = postRepository.save(post);

        assertThat(save.getId()).isNotNull();
    }
}