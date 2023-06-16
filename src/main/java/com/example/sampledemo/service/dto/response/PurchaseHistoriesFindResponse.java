package com.example.sampledemo.service.dto.response;

import java.util.List;
import lombok.Getter;

@Getter
public class PurchaseHistoriesFindResponse {

  List<PurchaseHistoryFindResponse> histories;

  UserFindResponse userInfo;

  public PurchaseHistoriesFindResponse(UserFindResponse userInfo, List<PurchaseHistoryFindResponse> histories) {
    this.histories = histories;
    this.userInfo = userInfo;
  }
}
