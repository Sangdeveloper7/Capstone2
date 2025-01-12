//package com.thc.fallsprbasic.dto;
//
//import com.thc.fallsprbasic.domain.Tbdata;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.SuperBuilder;
//
//public class TbdataDto {
//
//    /**/
//    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
//    public static class CreateReqDto extends DefaultDto.CreateReqDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//        public Tbdata toEntity(){
//            return Tbdata.of(getTbuserId(), getTbpaperId(), getTbpapertypeId());
//        }
//    }
//
//    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
//    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//    }
//
//    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
//    public static class DetailResDto extends DefaultDto.DetailResDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//    }
//
//    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
//    public static class ListReqDto extends DefaultDto.ListReqDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//    }
//
//    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
//    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//    }
//    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
//    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
//        private String tbuserId;
//        private String tbpaperId;
//        private String tbpapertypeId;
//    }
//
//}
