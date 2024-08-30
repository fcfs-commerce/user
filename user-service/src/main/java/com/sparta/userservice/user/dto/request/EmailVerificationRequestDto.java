package com.sparta.userservice.user.dto.request;

import lombok.Getter;

@Getter
public class EmailVerificationRequestDto {

  private String email;
  private String code;

}
