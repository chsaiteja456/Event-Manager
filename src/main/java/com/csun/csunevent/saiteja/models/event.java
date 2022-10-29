package com.csun.csunevent.saiteja.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class event {
    @Id
    @GeneratedValue
    public int eventId;
    public String eventName;
    @OneToMany
    public List<Comment> comments;

     @ManyToOne
    public User postedByUser;

    public String eventBody;

    public String eventLocation;

    @ManyToMany
    public List<Department> departmentsAllowed;


}
