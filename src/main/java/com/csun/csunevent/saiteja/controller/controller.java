package com.csun.csunevent.saiteja.controller;

import com.csun.csunevent.saiteja.Repository.DepartmentRepo;
import com.csun.csunevent.saiteja.Repository.UserRepo;
import com.csun.csunevent.saiteja.Repository.eventRepo;
import com.csun.csunevent.saiteja.models.Department;
import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
/*
@CrossOrigin(origins ="*")
*/
@RestController
@RequestMapping("/api/")
public class controller {
    @Autowired
    public eventRepo eventRepository;
    @Autowired
    public UserRepo UserRepository;

    @Autowired
    public DepartmentRepo departmentRepo;
    @CrossOrigin
    @GetMapping("private/myapi")
    public String callme(){
        return "Successfulllllllll";
    }
    @CrossOrigin
    @GetMapping("public/myapi")
    public String publicapi(){
        return "Successfulllllllll";
    }
    @PostMapping("public/postEvent")
    public event postEvent(@RequestBody event ev,Principal principal){
        String email= principal.getName();
User u=UserRepository.findByEmailId(email);
List<Department> department=ev.getDepartmentsAllowed();
departmentRepo.saveAll(department);
        User newUser=new User();
        newUser.setEmailId(email);
if(u==null){
    UserRepository.save(newUser);
}
ev.setPostedByUser(newUser);
        return eventRepository.save(ev);
    }
    @GetMapping("public/getAllDepartments")
    public List<Department> getAllDepartments(){
        return this.departmentRepo.findAll();
    }
    @GetMapping("public/getEvents")
    public List<event> getEvents(){
        return eventRepository.findAll();
    }
    @GetMapping("public/geteventbyuser/{username}")
    public List<event> getEventByUser(@PathVariable String username){
        User u=UserRepository.findByEmailId(username);
        return eventRepository.findByPostedByUser(u);
    }
    @GetMapping("/saveuser")
    public User saveUser(Principal principal){
       String name= principal.getName();
       User u=new User();
       System.out.println("princp obj"+principal);
       u.setEmailId(name);
        return UserRepository.save(u);
    }

}
