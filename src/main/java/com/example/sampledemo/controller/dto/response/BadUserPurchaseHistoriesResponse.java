package com.example.sampledemo.controller.dto.response;

import com.example.sampledemo.service.dto.response.PurchaseHistoryFindResponse;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class BadUserPurchaseHistoriesResponse {

  PurchaseUser userInfo;
  List<UserPurchaseHistoryResponse> histories;

  @Getter
  public static class PurchaseUser {

    private Integer userId;
    private String firstName;
    private String lastName;

    public PurchaseUser(UserFindResponse data) {
      this.userId = data.getUserId();
      this.firstName = data.getFirstName();
      this.lastName = data.getLastName();
    }
  }

  public BadUserPurchaseHistoriesResponse(UserFindResponse userInfo, List<PurchaseHistoryFindResponse> histories) {
    this.histories =
        histories.stream().map(UserPurchaseHistoryResponse::new).toList();
    this.userInfo = new PurchaseUser(userInfo);
  }
}
