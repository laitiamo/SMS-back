package com.zahory.studentmgsystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zahory.studentmgsystem.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
    Integer getUsertypeByUsername(String username);

}
