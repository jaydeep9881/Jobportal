package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("jobs/{id}")
    public Optional<Job> jobFindById(@PathVariable int id){
        return jobService.jobFindById(id);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Long id,
            @RequestBody Job updatedJob
    ) {
        Optional<Job> existingJob = jobService.jobFindById(id);

        if (existingJob.isPresent()) {
            Job job = existingJob.get();

            // Update fields
            job.setTitle(updatedJob.getTitle());
            job.setCompanyName(updatedJob.getCompanyName());
            job.setLocation(updatedJob.getLocation());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setExperienceRequired(updatedJob.getExperienceRequired());
            job.setDescription(updatedJob.getDescription());
            job.setApplicationDeadline(updatedJob.getApplicationDeadline());
            job.setJobType(updatedJob.getJobType());

            jobService.saveJob(job);

            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable long id) {
        if (jobService.jobFindById(id).isPresent()) {
            jobService.deleteJob(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
    @GetMapping("/jobs/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String title) {
        List<Job> jobs = jobService.findByTitleStartingWithIgnoreCase(title);
        return ResponseEntity.ok(jobs);
    }
}
