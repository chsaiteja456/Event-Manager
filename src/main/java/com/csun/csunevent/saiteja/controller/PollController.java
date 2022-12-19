package com.csun.csunevent.saiteja.controller;

import com.csun.csunevent.saiteja.DTOs.VoteDTO;
import com.csun.csunevent.saiteja.DTOs.pollDTO;
import com.csun.csunevent.saiteja.Repository.UserRepo;
import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/poll")
//@CrossOrigin(origins ="http://localhost:4200")
@CrossOrigin(origins ="*")
public class PollController {
    @Autowired
    public com.csun.csunevent.saiteja.Repository.pollRepo pr;
@Autowired
public UserRepo ur;

    @PostMapping("/newPoll")
    public pollDTO postAPoll(@RequestBody pollDTO p, Principal principal){
        poll newpoll=new poll();
        String email=principal.getName();
        User u=ur.findByEmailId(email);
        newpoll.setPostedBy(u);
        newpoll.setPollName(p.pollName);
        newpoll.setPollStatement(p.Statement);
        pr.save(newpoll);
       return p;
    }

    @PostMapping("/vote")
    public String recordAVote(@RequestBody VoteDTO vote){
        int pollid=vote.pollId;
        poll p=pr.findById(pollid).get();
        if(vote.getResponse().equals("upvote")){
            int totalUpvotes=p.getUpVoteCount();
            p.setUpVoteCount(totalUpvotes+1);
        }
        else{
            int totalDownVotes=p.getDownVoteCount();
            p.setDownVoteCount(totalDownVotes+1);
        }
        pr.save(p);
        return "recorded your response";
    }
    @GetMapping("/GetAllPolls")
    public List<poll> getAllPolls(){
        return pr.findAll();
    }
    @GetMapping("GetPoll/{id}")
    public poll getPoll(@PathVariable int id){
        return pr.findById(id).get();
    }
}
