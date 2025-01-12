package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//2024-07-11 추가(클래스 처음 추가함)
@Getter
@Table
@Entity
public class Tbuser extends AuditingFields{
    @Setter @Column(nullable = false) private String username;
    @Setter @Column(nullable = false) private String password;

    protected Tbuser(){}
    private Tbuser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public static Tbuser of(String username, String password){
        return new Tbuser(username, password);
    }


    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }


}
