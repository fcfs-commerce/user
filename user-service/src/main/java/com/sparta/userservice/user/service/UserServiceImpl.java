package com.sparta.userservice.user.service;

import com.sparta.userservice.global.dto.ApiResponse;
import com.sparta.userservice.global.exception.CustomException;
import com.sparta.userservice.global.exception.ExceptionCode;
import com.sparta.userservice.global.security.service.EncryptService;
import com.sparta.userservice.global.util.ApiResponseUtil;
import com.sparta.userservice.user.dto.request.SignUpRequestDto;
import com.sparta.userservice.user.entity.User;
import com.sparta.userservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final EncryptService encryptService;

  @Override
  public ApiResponse signup(SignUpRequestDto requestDto) {
    // 이미 존재하는 회원인지 판별
    boolean isExist = findUserByUsername(requestDto.getUsername());
    if (isExist) {
      throw CustomException.from(ExceptionCode.USER_EXISTS);
    }

    // 개인정보 암호화
    String password = passwordEncoder.encode(requestDto.getPassword());
    String email = encryptService.encrypt(requestDto.getEmail());
    String name = encryptService.encrypt(requestDto.getName());
    String phoneNumber = encryptService.encrypt(requestDto.getPhoneNumber());
    String zipCode = encryptService.encrypt(requestDto.getZipCode());
    String address = encryptService.encrypt(requestDto.getAddress());

    // 사용자 DB 저장
    User user = User.of(requestDto.getUsername(), email, password, name, phoneNumber, zipCode,
        address, requestDto.getRole());
    userRepository.save(user);

    return ApiResponseUtil.createSuccessResponse("Sign up request processed successfully.", null);
  }

  @Override
  public String findUserName(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> CustomException.from(ExceptionCode.USER_NOT_FOUND));
    return user.getName();
  }

  private boolean findUserByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

}
