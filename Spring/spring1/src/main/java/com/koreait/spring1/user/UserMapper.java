package com.koreait.spring1.user;

import org.apache.ibatis.annotations.Mapper;

// DAO생성
@Mapper
public interface UserMapper {
    int insUser(UserEntity param);
    UserEntity selUser(UserEntity param);
    int updUser(UserEntity parma);
}
