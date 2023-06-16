package com.example.sampledemo.client.user;

import com.example.sampledemo.client.dto.request.UserFindBindRequest;
import com.example.sampledemo.client.dto.request.UserUpdateBindRequest;
import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserClient {
  public ResponseEntity<UserFindBindResponse> getUserbyId(UserFindBindRequest request) throws Exception;

  public ResponseEntity<List<UserFindBindResponse>> getUsers();

  public ResponseEntity<UserFindBindResponse> createUser(UserUpdateBindRequest request);

  public void updateUser(UserUpdateBindRequest request);

  public void deleteUser(UserUpdateBindRequest request);
}
