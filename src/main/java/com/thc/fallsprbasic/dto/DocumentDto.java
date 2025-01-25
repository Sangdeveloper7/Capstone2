package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class DocumentDto {

    /**
     * Create Request DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {
        private Long keywordId;
        private String docName;
        private String docContent;
        private String prepare;
        private String docUrl;

        public Document toEntity() {
            return Document.of(keywordId, docName, docContent, prepare, docUrl);
        }
    }

    /**
     * Update Request DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private Long keywordId;
        private String docName;
        private String docContent;
        private String prepare;
        private String docUrl;
    }

    /**
     * Detail Response DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private Long keywordId;
        private String docName;
        private String docContent;
        private String prepare;
        private String docUrl;
    }

    /**
     * List Request DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private Long keywordId;
        private String docName;
    }

    /**
     * Paged List Request DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private Long keywordId;
        private String docName;
    }

    /**
     * Scroll List Request DTO
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private Long keywordId;
        private String docName;
    }
}
