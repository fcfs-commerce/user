package com.sparta.userservice.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EmailVerificationDto {

  private boolean certified;

  public static EmailVerificationDto from(boolean certified) {
    return EmailVerificationDto.builder()
        .certified(certified)
        .build();
  }
}
