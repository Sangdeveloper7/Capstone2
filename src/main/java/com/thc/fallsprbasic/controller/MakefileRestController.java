package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.MakefileDto;
import com.thc.fallsprbasic.service.MakefileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/makefile")
@RestController
public class MakefileRestController {

    private final MakefileService makefileService;
    public MakefileRestController(
            MakefileService makefileService
    ) {
        this.makefileService = makefileService;
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody MakefileDto.CreateReqDto param){
        return ResponseEntity.ok(makefileService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody MakefileDto.UpdateReqDto param){
        makefileService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody MakefileDto.UpdateReqDto param){
        makefileService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        makefileService.deletes(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<MakefileDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(makefileService.detail(id));
    }
    @GetMapping("/plist")
    public ResponseEntity<List<MakefileDto.DetailResDto>> list(MakefileDto.ListReqDto param){
        return ResponseEntity.ok(makefileService.list(param));
    }

    @GetMapping("/mlist")
    public ResponseEntity<List<MakefileDto.DetailResDto>> mlist(MakefileDto.ScrollListReqDto param){
        return ResponseEntity.ok(makefileService.scrollList(param));
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        makefileService.delete(id);
        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }
}
