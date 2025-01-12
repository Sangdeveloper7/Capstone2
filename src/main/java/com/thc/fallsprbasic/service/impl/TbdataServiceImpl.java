//package com.thc.fallsprbasic.service.impl;
//
//import com.thc.fallsprbasic.domain.Tbdata;
//import com.thc.fallsprbasic.dto.DefaultDto;
//import com.thc.fallsprbasic.dto.TbdataDto;
//import com.thc.fallsprbasic.mapper.TbdataMapper;
//import com.thc.fallsprbasic.repository.TbdataRepository;
//import com.thc.fallsprbasic.service.TbdataService;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TbdataServiceImpl implements TbdataService {
//
//    private final TbdataRepository TbdataRepository;
//    private final TbdataMapper TbdataMapper;
//    public TbdataServiceImpl(
//            TbdataRepository TbdataRepository,
//            TbdataMapper TbdataMapper
//    ) {
//        this.TbdataRepository = TbdataRepository;
//        this.TbdataMapper = TbdataMapper;
//    }
//
//    /**/
//
//    @Override
//    public DefaultDto.CreateResDto create(TbdataDto.CreateReqDto param) {
//        System.out.println("create");
//        DefaultDto.CreateResDto res = TbdataRepository.save(param.toEntity()).toCreateResDto();
//        return res;
//    }
//    @Override
//    public void update(TbdataDto.UpdateReqDto param) {
//        System.out.println("update");
//        Tbdata Tbdata = TbdataRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
//        if(param.getDeleted() != null) {
//            Tbdata.setDeleted(param.getDeleted());
//        }
//        TbdataRepository.save(Tbdata);
//    }
//    @Override
//    public void delete(Long id) {
//        update(TbdataDto.UpdateReqDto.builder().id(id).deleted(true).build());
//    }
//    @Override
//    public void deletes(DefaultDto.DeletesReqDto param) {
//        for(Long id : param.getIds()){
//            delete(id);
//        }
//    }
//
//    public TbdataDto.DetailResDto get(Long id) {
//        TbdataDto.DetailResDto res = TbdataMapper.detail(id);
//        if(res == null) { throw new RuntimeException("no data"); }
//        return res;
//    }
//    public List<TbdataDto.DetailResDto> detailList(List<TbdataDto.DetailResDto> list) {
//        List<TbdataDto.DetailResDto> newList = new ArrayList<>();
//        for(TbdataDto.DetailResDto each : list) {
//            newList.add(get(each.getId()));
//        }
//        return newList;
//    }
//    @Override
//    public TbdataDto.DetailResDto detail(Long id) {
//        return get(id);
//    }
//    @Override
//    public List<TbdataDto.DetailResDto> list(TbdataDto.ListReqDto param) {
//        return detailList(TbdataMapper.list(param));
//    }
//
//    @Override
//    public DefaultDto.PagedListResDto pagedList(TbdataDto.PagedListReqDto param){
//        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, TbdataMapper.pagedListCount(param));
//        retrunVal.setList(detailList(TbdataMapper.pagedList(param)));
//        return retrunVal;
//    }
//    @Override
//    public List<TbdataDto.DetailResDto> scrollList(TbdataDto.ScrollListReqDto param){
//        param.init();
//        Long cursor = param.getCursor();
//        if(cursor != null){
//            Tbdata Tbdata = TbdataRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
//            param.setCreatedAt(Tbdata.getCreatedAt() + "");
//        }
//        return detailList(TbdataMapper.scrollList(param));
//    }
//
//}
