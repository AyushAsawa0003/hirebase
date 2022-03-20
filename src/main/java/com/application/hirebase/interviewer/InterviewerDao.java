package com.application.hirebase.interviewer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerDao extends CrudRepository<Interviewer, Integer> {
}
