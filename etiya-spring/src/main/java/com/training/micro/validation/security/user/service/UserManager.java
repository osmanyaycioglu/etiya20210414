package com.training.micro.validation.security.user.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.micro.validation.security.user.UserObject;
import com.training.micro.validation.security.user.repo.IUserDao;

@Service
public class UserManager {

    @Autowired
    private IUserDao                userDao;

    private Map<String, UserObject> userMap;


    @PostConstruct
    public void init() {
        this.refresh();
    }

    @Scheduled(fixedDelay = 60_000)
    public void refresh() {
        Iterable<UserObject> findAllLoc = this.userDao.findAll();
        Map<String, UserObject> tempUserMap = new ConcurrentHashMap<>();
        for (UserObject userLoc : findAllLoc) {
            tempUserMap.put(userLoc.getUsername(),
                            userLoc);
        }
        if (tempUserMap.size() == 0) {
            UserObject userLoc = new UserObject();
            userLoc.setUsername("root");
            userLoc.setPassword(new BCryptPasswordEncoder().encode("1234"));
            userLoc.setRole("ADMIN");
            tempUserMap.put("root",
                            userLoc);
        }
        this.userMap = tempUserMap;
    }


    public void add(final UserObject user) {
        this.userDao.save(user);
    }

    public UserObject getUser(final String str) {
        return this.userMap.get(str);
    }

}
