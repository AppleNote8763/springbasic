package com.cys.springbasic.service;

import com.cys.springbasic.dto.PostUserRequestDto;
import com.cys.springbasic.dto.SignInRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
    String signIn(SignInRequestDto dto);
}
