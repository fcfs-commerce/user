package com.sparta.userservice.user.controller;

import com.sparta.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/internal/v1/users")
@RequiredArgsConstructor
public class UserInternalController {

  private final UserService userService;

  @GetMapping("/{userId}")
  public String username(@PathVariable Long userId) {
    return userService.findUserName(userId);
  }

}
