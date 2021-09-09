package com.zahory.studentmgsystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import javax.validation.constraints.NotNull;

@TableName("s_user")
@Data
public class UserEntity {
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USERTYPE = "usertype";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull
    @TableField(USERNAME)
    private String username;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @NotNull
    @TableField(USERTYPE)
    private Integer usertype;

}
