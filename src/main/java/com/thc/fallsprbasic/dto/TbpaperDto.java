package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Postimg;
import com.thc.fallsprbasic.domain.Tbpaper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

public class TbpaperDto {

    /**/
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {
        private Long papertype_id;
        private String papername;
        private String content;
        public Tbpaper toEntity(){
            return Tbpaper.of(getPapertype_id(), getPapername(), getContent());
        }
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private Long id;
        private Long papertype_id;
        private String papername;
        private String content;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private Long id;
        private Long papertype_id;
        private String papername;
        private String content;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private Long id;
        private Long papertype_id;
        private String papername;
        private String content;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private Long id;
        private Long papertype_id;
        private String papername;
        private String content;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private Long id;
        private Long papertype_id;
        private String papername;
        private String content;
    }

}
