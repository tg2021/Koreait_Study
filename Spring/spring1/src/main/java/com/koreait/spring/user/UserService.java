package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // bean등록
public class UserService {
// service : logic담당

    @Autowired
    private UserMapper mapper;

    public int join(UserEntity param) {
        return 0;
    }

}
