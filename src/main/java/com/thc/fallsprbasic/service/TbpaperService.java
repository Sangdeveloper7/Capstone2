package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbpaperDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbpaperService {
    /**/
    DefaultDto.CreateResDto create(TbpaperDto.CreateReqDto param);
    void update(TbpaperDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    TbpaperDto.DetailResDto detail(Long id);
    List<TbpaperDto.DetailResDto> list(TbpaperDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(TbpaperDto.PagedListReqDto param);
    List<TbpaperDto.DetailResDto> scrollList(TbpaperDto.ScrollListReqDto param);

}
