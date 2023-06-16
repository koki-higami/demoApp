package com.example.sampledemo.controller;

import com.example.sampledemo.controller.dto.request.UserInfoRequest;
import com.example.sampledemo.controller.dto.request.UserInfoUpdateRequest;
import com.example.sampledemo.controller.dto.response.UserInfoResponse;
import com.example.sampledemo.service.user.UserSharedService;
import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.request.UserUpdateRequest;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.dto.response.UserUpdateResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserSharedService service;

  @GetMapping("/userInfo")
  public UserInfoResponse getUser(@Valid UserInfoRequest req) {

    UserFindRequest requestData = new UserFindRequest(req);
    UserFindResponse outPutData = service.getUserById(requestData);

    return new UserInfoResponse(outPutData);
  }

  @GetMapping("/userInfos")
  public List<UserInfoResponse> getUsers() {

    List<UserFindResponse> users = service.getUsers();

    return users.stream().map(res -> new UserInfoResponse(res)).toList();
  }

  @PostMapping("/userInfo")
  public UserInfoResponse createUser(@RequestBody @Valid UserInfoUpdateRequest req) {

    UserUpdateRequest requestData = new UserUpdateRequest(req);
    UserUpdateResponse result = service.createUser(requestData);

    return new UserInfoResponse(result);
  }

}
