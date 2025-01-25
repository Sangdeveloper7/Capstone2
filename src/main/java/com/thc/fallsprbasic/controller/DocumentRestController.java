package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DocumentDto;
import com.thc.fallsprbasic.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/document")
@RestController
public class DocumentRestController {

    private final DocumentService documentService;
    public DocumentRestController(
            DocumentService documentService
    ) {
        this.documentService = documentService;
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody DocumentDto.CreateReqDto param){
        return ResponseEntity.ok(documentService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody DocumentDto.UpdateReqDto param){
        documentService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody DocumentDto.UpdateReqDto param){
        documentService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        documentService.deletes(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<DocumentDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(documentService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<DocumentDto.DetailResDto>> list(DocumentDto.ListReqDto param){
        return ResponseEntity.ok(documentService.list(param));
    }

    @GetMapping("/mlist")
    public ResponseEntity<List<DocumentDto.DetailResDto>> mlist(DocumentDto.ScrollListReqDto param){
        return ResponseEntity.ok(documentService.scrollList(param));
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        documentService.delete(id);
        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }
}
