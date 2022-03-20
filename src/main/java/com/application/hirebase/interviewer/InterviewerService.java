package com.application.hirebase.interviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewerService {


    private InterviewerDao interviewerDao;

    @Autowired
    public InterviewerService(InterviewerDao interviewerDao) {
        this.interviewerDao = interviewerDao;
    }

    //fetch all the interviewer
    public List<Interviewer> getAllInterviewer(){
         List<Interviewer> listOfInterviewers = (List<Interviewer>) interviewerDao.findAll();
         return Optional.of(listOfInterviewers).orElse(null);
    }

    //fetch a particular interviewer based on ID
    public Interviewer getInterviewerByID(int id){
        return interviewerDao.findById(id).orElse(null);
    }

    //add interviewer to table
    public Interviewer addInterviewer(Interviewer interviewer){
         Interviewer interviewer1 = interviewerDao.save(interviewer);
        return interviewer1;
    }

    //update interviewer in table
    public Interviewer updateInterviewerByID(int id, Interviewer interviewer){
        if(getInterviewerByID(id) != null){
            interviewer.setInterviewerID(id);
            Interviewer interviewer1 = interviewerDao.save(interviewer);
            System.out.println(interviewer1.toString());
            return interviewer1;
        }
        return null;
    }


    public void deleteAll(){
        interviewerDao.deleteAll();
    }
}
