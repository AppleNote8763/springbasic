package com.cys.springbasic.service;

import com.cys.springbasic.dto.PostUserRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
}
