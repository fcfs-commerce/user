package com.sparta.userservice.user.service;

import com.sparta.userservice.user.dto.request.SignUpRequestDto;
import com.sparta.userservice.user.dto.response.SignUpResponseDto;

public interface UserService {

  SignUpResponseDto signup(SignUpRequestDto requestDto);

}
