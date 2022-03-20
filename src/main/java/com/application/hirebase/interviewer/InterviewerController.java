package com.application.hirebase.interviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RequestMapping("interviewers")
@RestController
public class InterviewerController {


    private InterviewerService interviewerService;

    @Autowired
    public InterviewerController(InterviewerService interviewerService) {
        this.interviewerService = interviewerService;
    }

    @GetMapping
    public ResponseEntity<List<Interviewer>> getAllInterviewer(){
        List<Interviewer> interviewers = interviewerService.getAllInterviewer();
        if(interviewers == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body((interviewers));
    }

    //fetch a particular interviewer based on ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Interviewer> getInterviewerByID(@PathVariable("id") int id){
        Interviewer interviewer = interviewerService.getInterviewerByID(id);
        if(interviewer==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body((interviewer));
    }

    //add interviewer to table
    @PostMapping
    public ResponseEntity<Interviewer> addInterviewer(@RequestBody Interviewer interviewer){

        if(interviewer==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Interviewer interviewer1 = interviewerService.addInterviewer(interviewer);

        if (null == interviewer1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(interviewer1);

    }

    //update interviewer in table
    @PutMapping(path = "/{id}")
    public ResponseEntity<Interviewer> updateInterviewerByID( @PathVariable("id") int id, @RequestBody Interviewer interviewer){

        System.out.println(id);
        if(interviewer==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Interviewer interviewer1 = interviewerService.updateInterviewerByID(id, interviewer);

        if (interviewer1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(interviewer1);
    }


    @DeleteMapping()
    public void deleteAll(){
        interviewerService.deleteAll();
    }
}
