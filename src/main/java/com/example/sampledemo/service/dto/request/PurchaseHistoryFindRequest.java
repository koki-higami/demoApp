package com.example.sampledemo.service.dto.request;

import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import lombok.Getter;

@Getter
public class PurchaseHistoryFindRequest {

  private Integer userId;

  public PurchaseHistoryFindRequest(UserPurchaseHistoryRequest request) {
    this.userId = request.getUserId();
  }
}
