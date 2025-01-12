package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.Enum.RoleType;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.UserDto;
import com.thc.fallsprbasic.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User extends AuditingFields{
    @Setter @Column(nullable=false, unique=true)
    String email;
    @Setter @Column(nullable=false)
    String password;
    @Setter @Column(nullable=false, unique=false)
    String name;
    @Setter
    RoleType roleType;
    @Setter
    String phone;

    protected User(){}
    private User(Boolean deleted, String email, String password, String name, RoleType roleType, String phone) {
        this.deleted = deleted;
        this.email = email;
        this.password = password;
        this.name = name;
        this.roleType = roleType;
        this.phone = phone;
    }

    public static User of(String email, String password, String name, String phone) {
        return new User(false, email, password, name, RoleType.CITIZEN, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
