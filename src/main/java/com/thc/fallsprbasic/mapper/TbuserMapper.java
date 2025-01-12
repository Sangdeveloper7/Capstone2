package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.TbuserDto;

import java.util.List;

public interface TbuserMapper {
	TbuserDto.DetailResDto detail(Long id);
	List<TbuserDto.DetailResDto> list(TbuserDto.ListReqDto param);
	List<TbuserDto.DetailResDto> pagedList(TbuserDto.PagedListReqDto param);
	int pagedListCount(TbuserDto.PagedListReqDto param);
	List<TbuserDto.DetailResDto> scrollList(TbuserDto.ScrollListReqDto param);
}