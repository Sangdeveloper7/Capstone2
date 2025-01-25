package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.DefaultDto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Dkeyword extends AuditingFields{
    @Setter @Column(nullable=false, unique = true)
    String keyword;

    protected Dkeyword(){}
    private Dkeyword(Boolean deleted, String keyword){
        this.deleted = deleted;
        this.keyword = keyword;
    }

    public static Dkeyword of(String keyword){
        return new Dkeyword(false, keyword);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
