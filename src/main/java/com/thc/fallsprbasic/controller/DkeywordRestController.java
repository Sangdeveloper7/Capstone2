package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DkeywordDto;
import com.thc.fallsprbasic.service.DkeywordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/dkeyword")
@RestController
public class DkeywordRestController {

    private final DkeywordService dkeywordService;
    public DkeywordRestController(
            DkeywordService dkeywordService
    ) {
        this.dkeywordService = dkeywordService;
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody DkeywordDto.CreateReqDto param){
        return ResponseEntity.ok(dkeywordService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody DkeywordDto.UpdateReqDto param){
        dkeywordService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody DkeywordDto.UpdateReqDto param){
        dkeywordService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        dkeywordService.deletes(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<DkeywordDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(dkeywordService.detail(id));
    }
    @GetMapping("/plist")
    public ResponseEntity<List<DkeywordDto.DetailResDto>> list(DkeywordDto.ListReqDto param){
        return ResponseEntity.ok(dkeywordService.list(param));
    }

    @GetMapping("/mlist")
    public ResponseEntity<List<DkeywordDto.DetailResDto>> mlist(DkeywordDto.ScrollListReqDto param){
        return ResponseEntity.ok(dkeywordService.scrollList(param));
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        dkeywordService.delete(id);
        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }
}
