package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.PostDto;
import com.thc.fallsprbasic.dto.TbpaperDto;

import java.util.List;

public interface TbpaperMapper {
	TbpaperDto.DetailResDto detail(Long id);
	List<TbpaperDto.DetailResDto> list(TbpaperDto.ListReqDto param);
	List<TbpaperDto.DetailResDto> pagedList(TbpaperDto.PagedListReqDto param);
	int pagedListCount(TbpaperDto.PagedListReqDto param);
	List<TbpaperDto.DetailResDto> scrollList(TbpaperDto.ScrollListReqDto param);
}