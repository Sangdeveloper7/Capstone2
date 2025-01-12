package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbpapertypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbpapertypeService {
    /**/
    DefaultDto.CreateResDto create(TbpapertypeDto.CreateReqDto param);
    void update(TbpapertypeDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    TbpapertypeDto.DetailResDto detail(Long id);
    List<TbpapertypeDto.DetailResDto> list(TbpapertypeDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(TbpapertypeDto.PagedListReqDto param);
    List<TbpapertypeDto.DetailResDto> scrollList(TbpapertypeDto.ScrollListReqDto param);

}
