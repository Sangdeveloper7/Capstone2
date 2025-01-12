package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Tbuser;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.TbuserDto;
import com.thc.fallsprbasic.mapper.TbuserMapper;
import com.thc.fallsprbasic.repository.TbuserRepository;
import com.thc.fallsprbasic.service.TbuserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbuserServiceImpl implements TbuserService {

    private final TbuserRepository TbuserRepository;
    private final TbuserMapper TbuserMapper;
    public TbuserServiceImpl(
            TbuserRepository TbuserRepository
            , TbuserMapper TbuserMapper
    ) {
        this.TbuserRepository = TbuserRepository;
        this.TbuserMapper = TbuserMapper;
    }



    @Override
    public DefaultDto.CreateResDto login(TbuserDto.LoginReqDto param) {
        System.out.println("login");
        Tbuser Tbuser = TbuserRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(Tbuser == null){
            throw new RuntimeException("Tbusername or password incorrect");
        }
        return DefaultDto.CreateResDto.builder().id(Tbuser.getId()).build();
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(TbuserDto.CreateReqDto param) {
        System.out.println("create");
        Tbuser Tbuser = TbuserRepository.findByUsername(param.getUsername());
        if(Tbuser != null){
            //return DefaultDto.CreateResDto.builder().id((long) -400).build();
            throw new RuntimeException("already exist");
        }
        return TbuserRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(TbuserDto.UpdateReqDto param) {
        System.out.println("update");
        Tbuser Tbuser = TbuserRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            Tbuser.setDeleted(param.getDeleted());
        }
        if(param.getUsername() != null) {
            Tbuser.setUsername(param.getUsername());
        }
        TbuserRepository.save(Tbuser);
    }
    @Override
    public void delete(Long id) {
        update(TbuserDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public TbuserDto.DetailResDto get(Long id) {
        return TbuserMapper.detail(id);
    }
    public List<TbuserDto.DetailResDto> detailList(List<TbuserDto.DetailResDto> list) {
        List<TbuserDto.DetailResDto> newList = new ArrayList<>();
        for(TbuserDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public TbuserDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<TbuserDto.DetailResDto> list(TbuserDto.ListReqDto param) {
        return detailList(TbuserMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(TbuserDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, TbuserMapper.pagedListCount(param));
        retrunVal.setList(detailList(TbuserMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<TbuserDto.DetailResDto> scrollList(TbuserDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Tbuser Tbuser = TbuserRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(Tbuser.getCreatedAt() + "");
        }
        return detailList(TbuserMapper.scrollList(param));
    }

}
