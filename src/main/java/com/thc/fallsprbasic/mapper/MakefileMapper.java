package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.MakefileDto;

import java.util.List;

public interface MakefileMapper {
	MakefileDto.DetailResDto detail(Long id);
	List<MakefileDto.DetailResDto> list(MakefileDto.ListReqDto param);
	List<MakefileDto.DetailResDto> pagedList(MakefileDto.PagedListReqDto param);
	int pagedListCount(MakefileDto.PagedListReqDto param);
	List<MakefileDto.DetailResDto> scrollList(MakefileDto.ScrollListReqDto param);
}