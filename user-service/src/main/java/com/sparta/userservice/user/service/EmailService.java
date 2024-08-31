package com.sparta.userservice.user.service;

import com.sparta.userservice.global.dto.ApiResponse;
import com.sparta.userservice.user.dto.request.EmailRequestDto;
import com.sparta.userservice.user.dto.request.EmailVerificationRequestDto;

public interface EmailService {

  ApiResponse sendEmail(EmailRequestDto requestDto);

  ApiResponse matchRandomCode(EmailVerificationRequestDto requestDto);

}
