package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repositary.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;
    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    public Job addJob(Job job) {
        return jobRepo.save(job);
    }
}
