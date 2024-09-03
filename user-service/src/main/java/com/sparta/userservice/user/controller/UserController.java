package com.sparta.userservice.user.controller;

import com.sparta.userservice.global.dto.ApiResponse;
import com.sparta.userservice.user.dto.request.SignUpRequestDto;
import com.sparta.userservice.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<ApiResponse> signup(@RequestBody @Valid SignUpRequestDto requestDto) {
    log.info("회원 가입 요청");
    ApiResponse apiResponse = userService.signup(requestDto);
    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @GetMapping("/external/{userId}")
  public String username(@PathVariable Long userId) {
    return userService.findUserName(userId);
  }

}
