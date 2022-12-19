package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comment,Integer> {
    Comment save(Comment c);

}
