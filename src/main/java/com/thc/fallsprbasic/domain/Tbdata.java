//package com.thc.fallsprbasic.domain;
//
//import com.thc.fallsprbasic.dto.DefaultDto;
//import com.thc.fallsprbasic.dto.PostimgDto;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.UUID;
//
////2024-07-11 추가(클래스 처음 추가함)
//@Getter
//@Table
//@Entity
//public class Tbdata extends AuditingFields{
//    @Setter @Column(nullable = false) private String tbuserId;
//    @Setter @Column(nullable = false) private String tbpaperId;
//    @Setter @Column(nullable = false) private String tapapertypeId;
//
//    protected Tbdata(){}
//    private Tbdata(String tbuserId, String tbpaperId, String tapapertypeId) {
//        this.tbuserId = tbuserId;
//        this.tbpaperId = tbpaperId;
//        this.tapapertypeId = tapapertypeId;
//    }
//    public static Tbdata of(String tbuserId, String tbpaperId, String tapapertypeId){
//        return new Tbdata(tbuserId, tbpaperId, tapapertypeId);
//    }
//
//    public DefaultDto.CreateResDto toCreateResDto() {
//        return DefaultDto.CreateResDto.builder().id(getId()).build();
//    }
//
//}
