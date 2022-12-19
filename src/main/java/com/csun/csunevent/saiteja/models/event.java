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
    @Transient
    public List<Department> departmentsAllowed;



    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getPostedByUser() {
        return postedByUser;
    }

    public void setPostedByUser(User postedByUser) {
        this.postedByUser = postedByUser;
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public List<Department> getDepartmentsAllowed() {
        return departmentsAllowed;
    }

    public void setDepartmentsAllowed(List<Department> departmentsAllowed) {
        this.departmentsAllowed = departmentsAllowed;
    }
}
