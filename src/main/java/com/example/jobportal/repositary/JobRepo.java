package com.example.jobportal.repositary;

import com.example.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {

    List<Job> findByTitleStartingWithIgnoreCase(String title);
}
