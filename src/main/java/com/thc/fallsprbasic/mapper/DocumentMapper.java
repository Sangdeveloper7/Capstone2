package com.thc.fallsprbasic.mapper;

import com.thc.fallsprbasic.dto.DocumentDto;
import com.thc.fallsprbasic.dto.DocumentDto;

import java.util.List;

public interface DocumentMapper {
	DocumentDto.DetailResDto detail(Long id);
	List<DocumentDto.DetailResDto> list(DocumentDto.ListReqDto param);
	List<DocumentDto.DetailResDto> pagedList(DocumentDto.PagedListReqDto param);
	int pagedListCount(DocumentDto.PagedListReqDto param);
	List<DocumentDto.DetailResDto> scrollList(DocumentDto.ScrollListReqDto param);
}