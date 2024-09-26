package com.ithotgi.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") //application.tml에서 jwt속성 값을 가져옴
public class JWTProperties {
    private String issuer;
    private String secretKey;
}
