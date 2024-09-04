package com.sparta.userservice.user.service;

import com.sparta.userservice.global.dto.ApiResponse;
import com.sparta.userservice.user.dto.request.SignUpRequestDto;

public interface UserService {

  ApiResponse signup(SignUpRequestDto requestDto);

  String findUserName(Long userId);
}
