package com.koreait.spring.user;

import org.apache.ibatis.annotations.Mapper;

// DAO생성
@Mapper
public interface UserMapper {
    int insUser(UserEntity param);
}
