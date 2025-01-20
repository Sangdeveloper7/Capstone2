package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Dkeyword;
import com.thc.fallsprbasic.domain.Dkeyword;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

public class DkeywordDto {

    /**/
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {
        private String keyword;

        public Dkeyword toEntity(){
            return Dkeyword.of(getKeyword());
        }
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String keyword;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private String keyword;

    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private String keyword;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String keyword;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private String keyword;
    }

}
