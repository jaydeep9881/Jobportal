package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repositary.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    public Optional<Job> jobFindById(long id) {
        return jobRepo.findById((long) id);
    }

    public void saveJob(Job job) {
        jobRepo.save(job);
    }


    public void deleteJob(long id) {
        jobRepo.deleteById(id);
    }




    public List<Job> findByTitleStartingWithIgnoreCase(String title) {
        return jobRepo.findByTitleStartingWithIgnoreCase(title);
    }
}
