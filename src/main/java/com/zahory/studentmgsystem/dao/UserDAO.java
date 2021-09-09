package com.zahory.studentmgsystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zahory.studentmgsystem.dao.mapper.UserMapper;
import com.zahory.studentmgsystem.model.entity.StudentEntity;
import com.zahory.studentmgsystem.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends BaseDAO {
    private final UserMapper mapper;

    public UserDAO(UserMapper mapper) {
        this.mapper = mapper;
    }

    public UserEntity getUsertypeByUsername(String username) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getUsername, username);
        return mapper.selectOne(wrapper);
    }

    public UserEntity getByUsername(String username) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getUsername, username);

        return mapper.selectOne(wrapper);
    }

    public int insert(UserEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public UserEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(UserEntity entity) {
        return mapper.updateById(entity);
    }

    public List<UserEntity> list() {
        return mapper.selectList(new LambdaQueryWrapper<>());
    }
}
