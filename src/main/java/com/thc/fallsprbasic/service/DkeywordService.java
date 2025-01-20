package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DkeywordDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface DkeywordService {
    /**/
    DefaultDto.CreateResDto create(DkeywordDto.CreateReqDto param);
    void update(DkeywordDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    DkeywordDto.DetailResDto detail(Long id);
    List<DkeywordDto.DetailResDto> list(DkeywordDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(DkeywordDto.PagedListReqDto param);
    List<DkeywordDto.DetailResDto> scrollList(DkeywordDto.ScrollListReqDto param);

}
