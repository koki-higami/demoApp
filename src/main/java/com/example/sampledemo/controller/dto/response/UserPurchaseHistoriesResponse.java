package com.example.sampledemo.controller.dto.response;

import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class UserPurchaseHistoriesResponse {

  UserInfoResponse userInfo;
  List<UserPurchaseHistoryResponse> histories;

  public UserPurchaseHistoriesResponse(PurchaseHistoriesFindResponse data) {

    this.histories =
        data.getHistories().stream().map(responseHistory -> new UserPurchaseHistoryResponse(responseHistory)).toList();

    this.userInfo = new UserInfoResponse(data.getUserInfo());
  }
}
