package be.avidoo.sandbox.jpa.repository;

import be.avidoo.sandbox.jpa.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
