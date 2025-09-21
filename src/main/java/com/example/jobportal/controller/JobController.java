package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {
    @Autowired
    JobService jobService;
    @GetMapping("/jobs")
    public List<Job> getJobs(){
        return jobService.getJobs();
//        return null;
    }
    @PostMapping("/jobs")
    public Job addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }
}
