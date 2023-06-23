package com.example.sampledemo.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.sampledemo.client.user.MockUserClientImpl;
import com.example.sampledemo.controller.dto.request.UserInfoRequest;
import com.example.sampledemo.controller.dto.request.UserInfoUpdateRequest;
import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.request.UserUpdateRequest;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserSharedServiceImplTest {

  UserSharedServiceImpl target = new UserSharedServiceImpl(new MockUserClientImpl());

  @Nested
  class GetUserById {

    @Test
    void successTestExistUser() {
      UserFindRequest clientGetRequest = new UserFindRequest(new UserInfoRequest(1));
      UserFindResponse expect = target.getUserById(clientGetRequest);

      assertEquals(1, expect.getUserId());
      assertEquals("test", expect.getFirstName());
      assertEquals("test", expect.getLastName());
      assertEquals("test-mail.com", expect.getEmail());
    }

    @Test
    void failedTestNotExistUser() {
      UserFindRequest clientGetRequest = new UserFindRequest(new UserInfoRequest(100000));

      Exception expectError = assertThrows(Exception.class, () -> target.getUserById(clientGetRequest));
      assertEquals("not found user", expectError.getMessage());
    }
  }

  @Test
  void getUsers() {
  }

  @Test
  void createUser() {
    UserInfoUpdateRequest userInfo = new UserInfoUpdateRequest();
    userInfo.setEmail("email");
    userInfo.setFirstName("first");
    userInfo.setLastName("last");
    UserUpdateRequest updateRequest = new UserUpdateRequest(userInfo);

    List<UserFindResponse> beforeCreateUsers = target.getUsers();
    target.createUser(updateRequest);
    List<UserFindResponse> afterCreateUsers = target.getUsers();
    UserFindResponse latestUser = afterCreateUsers.get(afterCreateUsers.size() - 1);

    assertEquals(4, beforeCreateUsers.size());
    assertEquals(5, afterCreateUsers.size());
    assertEquals("email", latestUser.getEmail());
  }
}