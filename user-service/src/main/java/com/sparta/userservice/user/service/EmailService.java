package com.sparta.userservice.user.service;

import com.sparta.userservice.user.dto.request.EmailRequestDto;
import com.sparta.userservice.user.dto.request.EmailVerificationRequestDto;
import com.sparta.userservice.user.dto.response.EmailResponseDto;
import com.sparta.userservice.user.dto.response.EmailVerificationResponseDto;

public interface EmailService {

  EmailResponseDto sendEmail(EmailRequestDto requestDto);

  EmailVerificationResponseDto matchRandomCode(EmailVerificationRequestDto requestDto);
}
