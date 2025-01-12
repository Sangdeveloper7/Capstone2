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
public class Tbpaper extends AuditingFields{
    @Setter @Column(nullable = false) private Long papertype_id;
    @Setter @Column(nullable = false) private String papername;
    @Setter @Column(nullable = false) private String content;


    protected Tbpaper(){}
    private Tbpaper(Long papertype_id, String papername, String content) {
        this.papertype_id = papertype_id;
        this.papername = papername;
        this.content = content;
    }
    public static Tbpaper of(Long papertype_id, String papername, String content){
        return new Tbpaper(papertype_id, papername, content);
    }
    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }

}
