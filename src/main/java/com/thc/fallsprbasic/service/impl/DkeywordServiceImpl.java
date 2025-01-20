package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Dkeyword;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.DkeywordDto;
import com.thc.fallsprbasic.mapper.DkeywordMapper;
import com.thc.fallsprbasic.repository.DkeywordRepository;
import com.thc.fallsprbasic.service.DkeywordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DkeywordServiceImpl implements DkeywordService {

    private final DkeywordRepository dkeywordRepository;
    private final DkeywordMapper dkeywordMapper;
    public DkeywordServiceImpl(
            DkeywordRepository dkeywordRepository
            , DkeywordMapper dkeywordMapper
    ) {
        this.dkeywordRepository = dkeywordRepository;
        this.dkeywordMapper = dkeywordMapper;
    }
    
    @Override
    public DefaultDto.CreateResDto create(DkeywordDto.CreateReqDto param) {
        System.out.println("create");
        return dkeywordRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(DkeywordDto.UpdateReqDto param) {
        System.out.println("update");
        Dkeyword dkeyword = dkeywordRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            dkeyword.setDeleted(param.getDeleted());
        }
        if(param.getKeyword() != null) {
            dkeyword.setKeyword(param.getKeyword());
        }
        dkeywordRepository.save(dkeyword);
    }
    @Override
    public void delete(Long id) {
        update(DkeywordDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public DkeywordDto.DetailResDto get(Long id) {
        return dkeywordMapper.detail(id);
    }
    public List<DkeywordDto.DetailResDto> detailList(List<DkeywordDto.DetailResDto> list) {
        List<DkeywordDto.DetailResDto> newList = new ArrayList<>();
        for(DkeywordDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public DkeywordDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<DkeywordDto.DetailResDto> list(DkeywordDto.ListReqDto param) {
        return detailList(dkeywordMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(DkeywordDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, dkeywordMapper.pagedListCount(param));
        retrunVal.setList(detailList(dkeywordMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<DkeywordDto.DetailResDto> scrollList(DkeywordDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Dkeyword dkeyword = dkeywordRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(dkeyword.getCreatedAt() + "");
        }
        return detailList(dkeywordMapper.scrollList(param));
    }

}
