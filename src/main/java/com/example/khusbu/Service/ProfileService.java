package com.example.khusbu.Service;

import com.example.khusbu.Model.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private User profileUser;
    public User getProfileUser(){
        return profileUser;
    }
    public void setProfileUser(User user){
        this.profileUser=user;
    }
}
