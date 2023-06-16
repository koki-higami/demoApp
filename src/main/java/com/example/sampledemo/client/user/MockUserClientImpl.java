package com.example.sampledemo.client.user;

import com.example.sampledemo.client.dto.request.UserFindBindRequest;
import com.example.sampledemo.client.dto.request.UserUpdateBindRequest;
import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MockUserClientImpl implements UserClient {

  private List<UserFindBindResponse> users = new ArrayList<>();
  public MockUserClientImpl() {
    users.add(new UserFindBindResponse(1, "test", "test", "test-mail.com"));
    users.add(new UserFindBindResponse(2, "test-1", "test-1", "test-1-mail.com"));
    users.add(new UserFindBindResponse(3, "test-2", "test-2", "test-2-mail.com"));
    users.add(new UserFindBindResponse(4, "test-3", "test-3", "test-3-mail.com"));
  }

  @Override public ResponseEntity<UserFindBindResponse> getUserbyId(UserFindBindRequest request) throws Exception {

    Optional<UserFindBindResponse> result = users.stream().filter(user -> user.getUserId() == (request.getUserId())).findFirst();
    if(result.isEmpty()) {
      throw new Exception("not found user");
    };
    return ResponseEntity.ok(result.get());
  }

  @Override public ResponseEntity<List<UserFindBindResponse>> getUsers() {
    return ResponseEntity.ok(users);
  }

  @Override public ResponseEntity<UserFindBindResponse> createUser(UserUpdateBindRequest request) {
    UserFindBindResponse addUser =
        new UserFindBindResponse(users.size() + 1, request.getFirstName(), request.getLastName(), request.getEmail());
    users.add(addUser);

    return ResponseEntity.ok(addUser);
  }

  @Override public void updateUser(UserUpdateBindRequest request) {
  }

  @Override public void deleteUser(UserUpdateBindRequest request) {
  }
}
