package com.example.sampledemo.service.user;

import com.example.sampledemo.client.user.UserClient;
import com.example.sampledemo.client.dto.request.UserFindBindRequest;
import com.example.sampledemo.client.dto.request.UserUpdateBindRequest;
import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.request.UserUpdateRequest;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.dto.response.UserUpdateResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserSharedServiceImpl implements UserSharedService {

  private final UserClient client;

  @SneakyThrows
  @Override public UserFindResponse getUserById(UserFindRequest req) {
    UserFindBindRequest requestUserInfo = new UserFindBindRequest(req.getUserId());
    ResponseEntity<UserFindBindResponse> result = client.getUserbyId(requestUserInfo);

    return new UserFindResponse(result.getBody());
  }

  @SneakyThrows
  @Override public List<UserFindResponse> getUsers() {
    ResponseEntity<List<UserFindBindResponse>> result = client.getUsers();

    return
        // OutPutUserinfos クラスを作ってもいいかも
        result.getBody().stream()
            .map(res -> new UserFindResponse(res)).toList();
  }

  @Override public UserUpdateResponse createUser(UserUpdateRequest req) {

    UserUpdateBindRequest createUser =  new UserUpdateBindRequest(req.getFirstName(), req.getLastName(), req.getEmail());
    ResponseEntity<UserFindBindResponse> result = client.createUser(createUser);


    return new UserUpdateResponse(result.getBody());
  }
}
