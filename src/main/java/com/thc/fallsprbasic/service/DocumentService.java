package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DocumentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {
    /**/
    DefaultDto.CreateResDto create(DocumentDto.CreateReqDto param);
    void update(DocumentDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    DocumentDto.DetailResDto detail(Long id);
    List<DocumentDto.DetailResDto> list(DocumentDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(DocumentDto.PagedListReqDto param);
    List<DocumentDto.DetailResDto> scrollList(DocumentDto.ScrollListReqDto param);

}
