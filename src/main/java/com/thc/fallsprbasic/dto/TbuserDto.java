package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Tbuser;
import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.domain.Notice;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class TbuserDto {

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class LoginReqDto{
        private String username;
        private String password;
    }

    /**/
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {
        private String username;
        private String password;

        public Tbuser toEntity(){
            return Tbuser.of(getUsername(), getPassword());
        }
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String username;
        private String password;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private String username;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private String username;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String username;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private String username;
    }

}
