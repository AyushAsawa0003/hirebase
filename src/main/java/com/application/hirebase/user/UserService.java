package com.application.hirebase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    //fetching all the users from users table
    public List<User> getAllUsers(){
       return userDao.getAllUsers();
    }

    //fetching a particular user based on ID from users table
    public User getUserByID(int id){
        return userDao.findById(id).orElse(null);
    }

    //adding user to users table
    public User addUser(User user){
        User newUser = userDao.save(user);
        if (newUser != null){
            return newUser;
        }
        return null;
    }

    //update user data in users table
    public void updateUserByID(int id, User user){
        //setting the user id same as the user id passed in url so that
        //same user get updated in database
        user.setUserID(id);
        userDao.save(user);
    }

    //soft deleting user
    public User deleteUserById(int id){
         User user = userDao.getUserById(id);
         if(user.isUserActive() == true) {
             user.setUserActive(false);
             userDao.save(user);
        }
        else{
            return null;
        }
        return user;
    }





}
