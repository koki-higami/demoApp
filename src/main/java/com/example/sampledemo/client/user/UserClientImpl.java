package com.example.sampledemo.client.user;

import com.example.sampledemo.client.dto.request.UserFindBindRequest;
import com.example.sampledemo.client.dto.request.UserUpdateBindRequest;
import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserClientImpl implements UserClient {

  @Override public ResponseEntity<UserFindBindResponse> getUserbyId(UserFindBindRequest request) {
    return null;
  }

  @Override public ResponseEntity<List<UserFindBindResponse>> getUsers() {
    return null;
  }

  @Override public ResponseEntity<UserFindBindResponse> createUser(UserUpdateBindRequest request) {
    return null;
  }

  @Override public void updateUser(UserUpdateBindRequest request) {

  }

  @Override public void deleteUser(UserUpdateBindRequest request) {

  }

}
