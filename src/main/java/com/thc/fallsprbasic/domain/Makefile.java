package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Makefile extends AuditingFields{
    @Setter @Column(nullable=false)
    Long userId;

    @Setter @Column(nullable=false)
    Long documentId;

    @Setter @Column(nullable=false)
    Long keywordId;

    @Setter @Column(nullable=false)
    String docName;

    @Setter @Column(nullable=false)
    String docContent;

    @Setter @Column(nullable=false)
    String prepare;

    @Setter @Column
    String docUrl;

    protected Makefile(){}
    public Makefile(Long userId, Long documentId, Long keywordId, String docName, String docContent, String prepare, String docUrl) {
        this.userId = userId;
        this.documentId = documentId;
        this.keywordId = keywordId;
        this.docName = docName;
        this.docContent = docContent;
        this.prepare = prepare;
        this.docUrl = docUrl;
    }

    public static Makefile of(Long userId, Long documentId, Long keywordId, String docName, String docContent, String prepare, String docUrl) {
        return new Makefile(userId, documentId, keywordId, docName, docContent, prepare, docUrl);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
