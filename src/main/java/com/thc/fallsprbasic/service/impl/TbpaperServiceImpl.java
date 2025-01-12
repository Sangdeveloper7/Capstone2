package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Tbpaper;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbpaperDto;
import com.thc.fallsprbasic.mapper.TbpaperMapper;
import com.thc.fallsprbasic.repository.TbpaperRepository;
import com.thc.fallsprbasic.service.TbpaperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbpaperServiceImpl implements TbpaperService {

    private final TbpaperRepository TbpaperRepository;

    private final TbpaperMapper TbpaperMapper;
    public TbpaperServiceImpl(
            TbpaperRepository TbpaperRepository,
            TbpaperMapper TbpaperMapper
    ) {
        this.TbpaperRepository = TbpaperRepository;
        this.TbpaperMapper = TbpaperMapper;
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(TbpaperDto.CreateReqDto param) {
        System.out.println("create");
        DefaultDto.CreateResDto res = TbpaperRepository.save(param.toEntity()).toCreateResDto();
        return res;
    }
    @Override
    public void update(TbpaperDto.UpdateReqDto param) {
        System.out.println("update");
        Tbpaper Tbpaper = TbpaperRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getPapername() != null) {
            Tbpaper.setPapername(param.getPapername());
        }
        if(param.getContent() != null) {
            Tbpaper.setContent(param.getContent());
        }
        TbpaperRepository.save(Tbpaper);
    }
    @Override
    public void delete(Long id) {
        update(TbpaperDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public TbpaperDto.DetailResDto get(Long id) {
        TbpaperDto.DetailResDto res = TbpaperMapper.detail(id);
        if(res == null) { throw new RuntimeException("no data"); }
        return res;
    }
    public List<TbpaperDto.DetailResDto> detailList(List<TbpaperDto.DetailResDto> list) {
        List<TbpaperDto.DetailResDto> newList = new ArrayList<>();
        System.out.println("ㄹㅣ스트 나갑니다 " + list);
        for(TbpaperDto.DetailResDto each : list) {
            System.out.println("아이디 나갑니다 " + each);
            newList.add(get(each.getId()));
        }
        System.out.println("ㄹㅣ스트 나갑니다 " + newList);
        return newList;
    }
    @Override
    public TbpaperDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<TbpaperDto.DetailResDto> list(TbpaperDto.ListReqDto param){
        return detailList(TbpaperMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(TbpaperDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, TbpaperMapper.pagedListCount(param));
        retrunVal.setList(detailList(TbpaperMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<TbpaperDto.DetailResDto> scrollList(TbpaperDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Tbpaper Tbpaper = TbpaperRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(Tbpaper.getCreatedAt() + "");
        }
        return detailList(TbpaperMapper.scrollList(param));
    }

}
