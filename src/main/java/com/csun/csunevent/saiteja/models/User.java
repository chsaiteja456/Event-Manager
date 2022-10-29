package com.csun.csunevent.saiteja.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    public String emailId;
    public String givenName;
    public String familyName;

}
