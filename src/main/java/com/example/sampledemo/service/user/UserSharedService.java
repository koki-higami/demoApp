package com.example.sampledemo.service.user;

import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.request.UserUpdateRequest;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.dto.response.UserUpdateResponse;
import java.util.List;

public interface UserSharedService {
  public UserFindResponse getUserById(UserFindRequest req);

  public List<UserFindResponse> getUsers();

  public UserUpdateResponse createUser(UserUpdateRequest req);
}
