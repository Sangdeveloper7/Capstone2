package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbuserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbuserService {
    DefaultDto.CreateResDto login(TbuserDto.LoginReqDto param);
    /**/
    DefaultDto.CreateResDto create(TbuserDto.CreateReqDto param);
    void update(TbuserDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    TbuserDto.DetailResDto detail(Long id);
    List<TbuserDto.DetailResDto> list(TbuserDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(TbuserDto.PagedListReqDto param);
    List<TbuserDto.DetailResDto> scrollList(TbuserDto.ScrollListReqDto param);
    
}
