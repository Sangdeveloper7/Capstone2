package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Document extends AuditingFields{
    @Setter @Column(nullable=false)
    Long keywordId;

    @Setter @Column(nullable=false)
    String docName;

    @Setter @Column(nullable=false)
    String docContent;

    @Setter @Column(nullable=false)
    String prepare;

    @Setter @Column(nullable=false)
    String docUrl;

    protected Document(){}
    public Document(Long keywordId, String docName, String docContent, String prepare, String docUrl) {
        this.keywordId = keywordId;
        this.docName = docName;
        this.docContent = docContent;
        this.prepare = prepare;
        this.docUrl = docUrl;
    }

    public static Document of(Long keywordId, String docName, String docContent, String prepare, String docUrl){
        return new Document(keywordId, docName, docContent, prepare, docUrl);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
