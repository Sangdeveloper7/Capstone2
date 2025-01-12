package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.TbpapertypeDto;

import java.util.List;

public interface TbpapertypeMapper {
	TbpapertypeDto.DetailResDto detail(Long id);
	List<TbpapertypeDto.DetailResDto> list(TbpapertypeDto.ListReqDto param);
	List<TbpapertypeDto.DetailResDto> pagedList(TbpapertypeDto.PagedListReqDto param);
	int pagedListCount(TbpapertypeDto.PagedListReqDto param);
	List<TbpapertypeDto.DetailResDto> scrollList(TbpapertypeDto.ScrollListReqDto param);
}