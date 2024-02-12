package com.thc.fallsprbasic.security;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ExternalProperties {
    // 여기 있는 값들은 모두 yaml 파일에 저장된 값들만 사용해야 함

    // 시큐리키를 생성하는 암호화 코드
    @Value("${external.jwt.tokenSecretKey}")
    private String tokenSecretKey;

    // 토큰앞에 붙여 암호화 하는 코드
    @Value("${external.jwt.tokenPrefix}")
    private String tokenPrefix;

    // 승인 키
    @Value("${external.jwt.accessKey}")
    private String accessKey;

    // access토큰이 만료되는 시간
    @Value("${external.jwt.accessTokenExpirationTime}")
    private Integer accessTokenExpirationTime;


    // 리프레쉬 토큰
    @Value("${external.jwt.refreshKey}")
    private String refreshKey;

    // 리프레쉬 토큰 만료 시간
    @Value("${external.jwt.refreshTokenExpirationTime}")
    private Integer refreshTokenExpirationTime;
}
