package be.avidoo.sandbox.jpa.repository;

import be.avidoo.sandbox.jpa.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
