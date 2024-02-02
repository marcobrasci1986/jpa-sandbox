package be.avidoo.sandbox.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_generator")
    @SequenceGenerator(name = "post_seq_generator", sequenceName = "post_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public Post(Long id, String title, List<PostComment> comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }

    public void addComment(PostComment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }
}
