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
public class Tbpapertype extends AuditingFields{
    @Setter @Column(nullable = false) private String typename;

    protected Tbpapertype(){}
    private Tbpapertype(String typename) {
        this.typename = typename;
    }
    public static Tbpapertype of(String typename){
        return new Tbpapertype(typename);
    }
    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
