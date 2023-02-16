package com.lh.userservice.mapper;

import com.lh.userservice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserInfoById(Integer id);
}
