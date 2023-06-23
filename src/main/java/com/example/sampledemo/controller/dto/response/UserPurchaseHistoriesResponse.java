package com.example.sampledemo.controller.dto.response;

import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class UserPurchaseHistoriesResponse {

  PurchaseUser userInfo;
  List<UserPurchaseHistoryResponse> histories;

  @Getter
  static class PurchaseUser {
    private Integer userId;
    private String firstName;
    private String lastName;

    public PurchaseUser(UserFindResponse data) {
      this.userId = data.getUserId();
      this.firstName = data.getFirstName();
      this.lastName = data.getLastName();
    }
  }
  public UserPurchaseHistoriesResponse(PurchaseHistoriesFindResponse data) {

    this.histories =
        data.getHistories().stream().map(UserPurchaseHistoryResponse::new).toList();

    UserFindResponse userData = data.getUserInfo();
    this.userInfo = new PurchaseUser(userData);
  }
}
