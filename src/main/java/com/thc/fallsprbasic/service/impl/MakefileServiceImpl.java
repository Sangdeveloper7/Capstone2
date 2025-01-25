package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Makefile;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.MakefileDto;
import com.thc.fallsprbasic.mapper.MakefileMapper;
import com.thc.fallsprbasic.repository.DkeywordRepository;
import com.thc.fallsprbasic.repository.MakefileRepository;
import com.thc.fallsprbasic.service.MakefileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakefileServiceImpl implements MakefileService {

    private final MakefileRepository makefileRepository;
    private final MakefileMapper makefileMapper;
    private final DkeywordRepository dkeywordRepository;
    public MakefileServiceImpl(
            MakefileRepository makefileRepository
            , MakefileMapper makefileMapper
            , DkeywordRepository dkeywordRepository
    ) {
        this.makefileRepository = makefileRepository;
        this.makefileMapper = makefileMapper;
        this.dkeywordRepository = dkeywordRepository;
    }

    @Override
    public DefaultDto.CreateResDto create(MakefileDto.CreateReqDto param) {
        System.out.println("create");

        boolean keywordExists = dkeywordRepository.existsById(param.getKeywordId());
        boolean userIdExists = makefileRepository.existsById(param.getUserId());
        boolean documentExists = makefileRepository.existsById(param.getDocumentId());
        if (!keywordExists) {
            throw new IllegalArgumentException("유효하지 않은 키워드 ID입니다: " + param.getKeywordId());
        }
        if (!userIdExists) {
            throw new IllegalArgumentException("존재하지 않는 유저 ID입니다: " + param.getUserId());
        }
        if (!documentExists) {
            throw new IllegalArgumentException("존재하지 않는 문서 타입입니다: " + param.getUserId());
        }
        return makefileRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(MakefileDto.UpdateReqDto param) {
        System.out.println("update");
        Makefile Makefile = makefileRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            Makefile.setDeleted(param.getDeleted());
        }
        if(param.getKeywordId() != null) {
            Makefile.setKeywordId(param.getKeywordId());
        }
        if(param.getDocName() != null) {
            Makefile.setDocName(param.getDocName());
        }
        if(param.getDocContent() != null) {
            Makefile.setDocContent(param.getDocContent());
        }
        makefileRepository.save(Makefile);
    }
    @Override
    public void delete(Long id) {
        update(MakefileDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public MakefileDto.DetailResDto get(Long id) {
        return makefileMapper.detail(id);
    }
    public List<MakefileDto.DetailResDto> detailList(List<MakefileDto.DetailResDto> list) {
        List<MakefileDto.DetailResDto> newList = new ArrayList<>();
        for(MakefileDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public MakefileDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<MakefileDto.DetailResDto> list(MakefileDto.ListReqDto param) {
        return detailList(makefileMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(MakefileDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, makefileMapper.pagedListCount(param));
        retrunVal.setList(detailList(makefileMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<MakefileDto.DetailResDto> scrollList(MakefileDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Makefile Makefile = makefileRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(Makefile.getCreatedAt() + "");
        }
        return detailList(makefileMapper.scrollList(param));
    }

}
