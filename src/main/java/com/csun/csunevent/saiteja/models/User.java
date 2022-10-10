package com.csun.csunevent.saiteja.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Component
public class User {
    @Id
    public String emailId;
    public String givenName;
    public String familyName;

}
