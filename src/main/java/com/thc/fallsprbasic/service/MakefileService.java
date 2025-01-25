package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.MakefileDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MakefileService {
    /**/
    DefaultDto.CreateResDto create(MakefileDto.CreateReqDto param);
    void update(MakefileDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    MakefileDto.DetailResDto detail(Long id);
    List<MakefileDto.DetailResDto> list(MakefileDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(MakefileDto.PagedListReqDto param);
    List<MakefileDto.DetailResDto> scrollList(MakefileDto.ScrollListReqDto param);

}
