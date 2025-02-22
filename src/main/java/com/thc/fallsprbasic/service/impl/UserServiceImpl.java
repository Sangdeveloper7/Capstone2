package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.Enum.RoleType;
import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.UserDto;
import com.thc.fallsprbasic.exception.NoAuthorizationException;
import com.thc.fallsprbasic.mapper.UserMapper;
import com.thc.fallsprbasic.repository.UserRepository;
import com.thc.fallsprbasic.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(
            UserRepository userRepository
            , UserMapper userMapper,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public DefaultDto.CreateResDto login(UserDto.LoginReqDto param) {
        System.out.println("login");
        User user = userRepository.findByEmailAndPassword(param.getEmail(), param.getPassword());
        if(user == null){
            throw new RuntimeException("username or password incorrect");
        }
        return DefaultDto.CreateResDto.builder().id(user.getId()).build();
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        System.out.println("create");
        User user = userRepository.findByEmail(param.getEmail());
        if(user != null){
            //return DefaultDto.CreateResDto.builder().id((long) -400).build();
            throw new RuntimeException("already exist");
        }

        // 비번 암호와 코드
        param.setPassword(bCryptPasswordEncoder.encode(param.getPassword()));
        User newUser = userRepository.save(param.toEntity());

        if(param.getRole() == RoleType.ADMIN){
            throw new NoAuthorizationException("관리자 권한의 계정은 생성할 수 없습니다.");
        }

        return userRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(UserDto.UpdateReqDto param) {
        System.out.println("update");
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            user.setDeleted(param.getDeleted());
        }
        if(param.getName() != null) {
            user.setName(param.getName());
        }
        if(param.getPhone() != null) {
            user.setPhone(param.getPhone());
        }
        if(param.getRole() == RoleType.ADMIN){
            throw new NoAuthorizationException("해당 메서드에 대한 권한이 없습니다. 관리자 권한만 접속 가능합니다.");
        }
        userRepository.save(user);
    }
    @Override
    public void delete(Long id) {
        update(UserDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public UserDto.DetailResDto get(Long id) {
        return userMapper.detail(id);
    }
    public List<UserDto.DetailResDto> detailList(List<UserDto.DetailResDto> list) {
        List<UserDto.DetailResDto> newList = new ArrayList<>();
        for(UserDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public UserDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        return detailList(userMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, userMapper.pagedListCount(param));
        retrunVal.setList(detailList(userMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            User user = userRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(user.getCreatedAt() + "");
        }
        return detailList(userMapper.scrollList(param));
    }

}
