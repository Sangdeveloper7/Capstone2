package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Document;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DocumentDto;
import com.thc.fallsprbasic.mapper.DocumentMapper;
import com.thc.fallsprbasic.repository.DkeywordRepository;
import com.thc.fallsprbasic.repository.DocumentRepository;
import com.thc.fallsprbasic.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final DkeywordRepository dkeywordRepository;
    public DocumentServiceImpl(
            DocumentRepository documentRepository
            , DocumentMapper documentMapper
            , DkeywordRepository dkeywordRepository
    ) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
        this.dkeywordRepository = dkeywordRepository;
    }

    @Override
    public DefaultDto.CreateResDto create(DocumentDto.CreateReqDto param) {
        System.out.println("create");

        boolean keywordExists = dkeywordRepository.existsById(param.getKeywordId());
        if (!keywordExists) {
            throw new IllegalArgumentException("유효하지 않은 키워드 ID입니다: " + param.getKeywordId());
        }
        return documentRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(DocumentDto.UpdateReqDto param) {
        System.out.println("update");
        Document document = documentRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            document.setDeleted(param.getDeleted());
        }
        if(param.getKeywordId() != null) {
            document.setKeywordId(param.getKeywordId());
        }
        if(param.getDocName() != null) {
            document.setDocName(param.getDocName());
        }
        if(param.getDocContent() != null) {
            document.setDocContent(param.getDocContent());
        }
        documentRepository.save(document);
    }
    @Override
    public void delete(Long id) {
        update(DocumentDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public DocumentDto.DetailResDto get(Long id) {
        return documentMapper.detail(id);
    }
    public List<DocumentDto.DetailResDto> detailList(List<DocumentDto.DetailResDto> list) {
        List<DocumentDto.DetailResDto> newList = new ArrayList<>();
        for(DocumentDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public DocumentDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<DocumentDto.DetailResDto> list(DocumentDto.ListReqDto param) {
        return detailList(documentMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(DocumentDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, documentMapper.pagedListCount(param));
        retrunVal.setList(detailList(documentMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<DocumentDto.DetailResDto> scrollList(DocumentDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Document document = documentRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(document.getCreatedAt() + "");
        }
        return detailList(documentMapper.scrollList(param));
    }

}
