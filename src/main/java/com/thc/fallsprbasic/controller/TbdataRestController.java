//package com.thc.fallsprbasic.controller;
//
//import com.thc.fallsprbasic.dto.DefaultDto;
//import com.thc.fallsprbasic.dto.TbdataDto;
//import com.thc.fallsprbasic.service.TbdataService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequestMapping("/api/tbdata")
//@RestController
//public class TbdataRestController {
//
//    private final TbdataService tbdataService;
//    public TbdataRestController(
//            TbdataService tbdataService
//    ) {
//        this.tbdataService = tbdataService;
//    }
//
//    /**/
//    @PostMapping("")
//    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody TbdataDto.CreateReqDto param){
//        return ResponseEntity.ok(tbdataService.create(param));
//    }
//    @PutMapping("")
//    public ResponseEntity<String> update(@RequestBody TbdataDto.UpdateReqDto param){
//        tbdataService.update(param);
//        return ResponseEntity.ok().build();
//    }
//    @DeleteMapping("")
//    public ResponseEntity<String> delete(@RequestBody TbdataDto.UpdateReqDto param){
//        tbdataService.delete(param.getId());
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/detail")
//    public ResponseEntity<TbdataDto.DetailResDto> detail(@RequestParam Long id){
//        return ResponseEntity.ok(tbdataService.detail(id));
//    }
//    @GetMapping("/list")
//    public ResponseEntity<List<TbdataDto.DetailResDto>> list(TbdataDto.ListReqDto param){
//        return ResponseEntity.ok(tbdataService.list(param));
//    }
//    @GetMapping("/plist")
//    public ResponseEntity<DefaultDto.PagedListResDto> plist(TbdataDto.PagedListReqDto param){
//        return ResponseEntity.ok(tbdataService.pagedList(param));
//    }
//    @GetMapping("/mlist")
//    public ResponseEntity<List<TbdataDto.DetailResDto>> mlist(TbdataDto.ScrollListReqDto param){
//        return ResponseEntity.ok(tbdataService.scrollList(param));
//    }
//}
