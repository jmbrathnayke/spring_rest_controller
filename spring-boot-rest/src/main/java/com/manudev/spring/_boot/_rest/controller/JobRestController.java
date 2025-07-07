package com.manudev.spring._boot._rest.controller;

import com.manudev.spring._boot._rest.model.JobPost;
import com.manudev.spring._boot._rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobRestController {

    @Autowired
    public JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    //use pathvariable
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
}
