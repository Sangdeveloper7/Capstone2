package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Tbpapertype;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbpapertypeDto;
import com.thc.fallsprbasic.mapper.TbpapertypeMapper;
import com.thc.fallsprbasic.repository.TbpapertypeRepository;
import com.thc.fallsprbasic.service.TbpapertypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbpapertypeServiceImpl implements TbpapertypeService {
    private final TbpapertypeRepository TbpapertypeRepository;
    private final TbpapertypeMapper TbpapertypeMapper;
    public TbpapertypeServiceImpl(
            TbpapertypeRepository TbpapertypeRepository,
            TbpapertypeMapper TbpapertypeMapper
    ) {
        this.TbpapertypeRepository = TbpapertypeRepository;
        this.TbpapertypeMapper = TbpapertypeMapper;
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(TbpapertypeDto.CreateReqDto param) {
        System.out.println("create");
        DefaultDto.CreateResDto res = TbpapertypeRepository.save(param.toEntity()).toCreateResDto();
        return res;
    }
    @Override
    public void update(TbpapertypeDto.UpdateReqDto param) {
        System.out.println("update");
        Tbpapertype Tbpapertype = TbpapertypeRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            Tbpapertype.setDeleted(param.getDeleted());
        }
        TbpapertypeRepository.save(Tbpapertype);
    }
    @Override
    public void delete(Long id) {
        update(TbpapertypeDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public TbpapertypeDto.DetailResDto get(Long id) {
        TbpapertypeDto.DetailResDto res = TbpapertypeMapper.detail(id);
        if(res == null) { throw new RuntimeException("no data"); }
        return res;
    }
    public List<TbpapertypeDto.DetailResDto> detailList(List<TbpapertypeDto.DetailResDto> list) {
        List<TbpapertypeDto.DetailResDto> newList = new ArrayList<>();
        for(TbpapertypeDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public TbpapertypeDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<TbpapertypeDto.DetailResDto> list(TbpapertypeDto.ListReqDto param) {
        return detailList(TbpapertypeMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(TbpapertypeDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, TbpapertypeMapper.pagedListCount(param));
        retrunVal.setList(detailList(TbpapertypeMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<TbpapertypeDto.DetailResDto> scrollList(TbpapertypeDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Tbpapertype Tbpapertype = TbpapertypeRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(Tbpapertype.getCreatedAt() + "");
        }
        return detailList(TbpapertypeMapper.scrollList(param));
    }

}
