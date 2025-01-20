package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.DkeywordDto;

import java.util.List;

public interface DkeywordMapper {
	DkeywordDto.DetailResDto detail(Long id);
	List<DkeywordDto.DetailResDto> list(DkeywordDto.ListReqDto param);
	List<DkeywordDto.DetailResDto> pagedList(DkeywordDto.PagedListReqDto param);
	int pagedListCount(DkeywordDto.PagedListReqDto param);
	List<DkeywordDto.DetailResDto> scrollList(DkeywordDto.ScrollListReqDto param);
}