package com.springclound.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User implements Serializable {

    @Id
    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 63, unique = true, nullable = false)
    // 账号
    private String login;

//    @JsonIgnore
    @NotNull
    @Size(min = 5, max = 60)
    @Column(length = 63, nullable = false)
    // 密码
    private String password;

//    @JsonIgnore
    @Column()
    // 权限
    private String authority;
}
