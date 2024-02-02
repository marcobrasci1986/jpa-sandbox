package be.avidoo.sandbox.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post_comment")
@Getter
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_comment_seq_generator")
    @SequenceGenerator(name = "post_comment_seq_generator", sequenceName = "post_comment_seq", allocationSize = 1)
    private Long id;

    @Column(name = "review")
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public PostComment() {
    }

    public PostComment(String review) {
        this.review = review;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PostComment))
            return false;
        return id != null && id.equals(((PostComment) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}