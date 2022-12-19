package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface eventRepo extends JpaRepository<event,Integer> {
    public List<event> findByPostedByUser(User u);
    public event findByEventId(int id);
}
