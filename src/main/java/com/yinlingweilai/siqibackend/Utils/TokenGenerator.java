package com.yinlingweilai.siqibackend.Utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String tokenGenerate(String... strings);
}
