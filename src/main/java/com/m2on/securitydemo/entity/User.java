package com.m2on.securitydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/12:23
 * @Description:
 */
@Data
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField(value = "name")
    private String username;

    private String password;

    private boolean enabled;
}
