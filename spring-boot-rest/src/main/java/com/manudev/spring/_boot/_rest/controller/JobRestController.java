package com.manudev.spring._boot._rest.controller;

import com.manudev.spring._boot._rest.model.JobPost;
import com.manudev.spring._boot._rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();

    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "deleted";
    }
}
