package com.example.sampledemo.service.dto.request;

import com.example.sampledemo.controller.dto.request.UserInfoRequest;
import lombok.Data;

@Data
public class UserFindRequest {
  private Integer userId;

  public UserFindRequest(UserInfoRequest req) {
    this.userId = req.getUserId();
  }

  //インスタンス生成が増えていく？
  public UserFindRequest(PurchaseHistoryFindRequest request) {
    this.userId = request.getUserId();
  }
}
