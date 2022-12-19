package com.csun.csunevent.saiteja.controller;

import com.csun.csunevent.saiteja.Repository.CommentsRepo;
import com.csun.csunevent.saiteja.Repository.DepartmentRepo;
import com.csun.csunevent.saiteja.Repository.UserRepo;
import com.csun.csunevent.saiteja.Repository.eventRepo;
import com.csun.csunevent.saiteja.models.Comment;
import com.csun.csunevent.saiteja.models.Department;
import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

///@CrossOrigin(origins ="http://localhost:4200")
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/")
public class controller {
    @Autowired
    public eventRepo eventRepository;
    @Autowired
    public UserRepo UserRepository;

    @Autowired
    public DepartmentRepo departmentRepo;

    @Autowired
    public CommentsRepo commentsRepo;


    @Autowired
    public JwtDecoder jwtDecoder;
    @Autowired
    public NimbusJwtDecoder nimbusJwtDecoder;
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
    @MessageMapping("public/postEvent")
    @SendTo("/websocket")
    public event postEvent(@RequestBody event ev,Principal principal){
        String email= principal.getName();
User u=UserRepository.findByEmailId(email);
List<Department> department=ev.getDepartmentsAllowed();
/*departmentRepo.saveAll(department);*/
       /* for(int i=0;i<department.size();i++){
String dept_name=department.get(i).getDepartmentName();
Optional<Department> optionalDepartment=departmentRepo.findByDepartmentName(dept_name);
if(!optionalDepartment.isPresent()){
   departmentRepo.save(department.get(i));
}
        }*/
        //departmentRepo.saveAll(department);
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
    public List<event> getEvents(@RequestHeader Map<String,String> headers){
       /* List<String> headersList=headers.keySet().stream().toList();

        String authHeader=headersList.stream().filter(x-> Objects.equals(x, "Authorization")).collect(Collectors.toList()).get(0);
        String token=headers.get(authHeader).substring(7,headers.get(authHeader).length());
        String claim= nimbusJwtDecoder.decode(token).getClaim("role");
        System.out.println("sardaar"+claim);*/
        return eventRepository.findAll();
    }

 /*   @GetMapping("/get-session-count")
    public void testSessionListner(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(false);

    }*/





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
    @PostMapping("public/postComment/{event_id}")
    public Comment addComment(@RequestBody Comment comment,@PathVariable int event_id,Principal principal){
        String name= principal.getName();
        User u=new User();
        u.setEmailId(name);
        comment.setUser(u);
        Optional<event> optionalEvent=eventRepository.findById(event_id);
        if(optionalEvent.isPresent()){
            optionalEvent.get().getComments().add(comment);
        }

        commentsRepo.save(comment);
        eventRepository.save(optionalEvent.get());
       return comment;
    }
    @GetMapping("getComments/{event_id}")
    public List<Comment> getComments(@PathVariable int event_id){
        return eventRepository.findByEventId(event_id).getComments();
    }
    @GetMapping("getEventById/{event_id}")
    public event getEventById(@PathVariable int event_id){
        return eventRepository.findByEventId(event_id);
    }

   /* @GetMapping("/claims")
    public Map<String, Object> getClaims(Principal principal) {
        return ((Jwt) ((OAuth) principal).getPrincipal()).getClaims();
    }*/
}
