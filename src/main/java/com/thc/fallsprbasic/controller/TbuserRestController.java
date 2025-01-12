package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbuserDto;
import com.thc.fallsprbasic.service.TbuserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserService tbuserService;
    public TbuserRestController(
            TbuserService tbuserService
    ) {
        this.tbuserService = tbuserService;
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultDto.CreateResDto> login(@RequestBody TbuserDto.LoginReqDto param){
        return ResponseEntity.ok(tbuserService.login(param));
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody TbuserDto.CreateReqDto param){
        return ResponseEntity.ok(tbuserService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody TbuserDto.UpdateReqDto param){
        tbuserService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody TbuserDto.UpdateReqDto param){
        tbuserService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        tbuserService.deletes(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<TbuserDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(tbuserService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<TbuserDto.DetailResDto>> list(TbuserDto.ListReqDto param){
        return ResponseEntity.ok(tbuserService.list(param));
    }
    @GetMapping("/plist")
    public ResponseEntity<DefaultDto.PagedListResDto> plist(TbuserDto.PagedListReqDto param){
        return ResponseEntity.ok(tbuserService.pagedList(param));
    }
    @GetMapping("/mlist")
    public ResponseEntity<List<TbuserDto.DetailResDto>> mlist(TbuserDto.ScrollListReqDto param){
        return ResponseEntity.ok(tbuserService.scrollList(param));
    }
}
