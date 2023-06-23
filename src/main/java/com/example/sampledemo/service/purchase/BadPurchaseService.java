package com.example.sampledemo.service.purchase;

import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import com.example.sampledemo.controller.dto.response.BadUserPurchaseHistoriesResponse;

public interface BadPurchaseService {

  public BadUserPurchaseHistoriesResponse badGetPurchaseHistoriesByUser(UserPurchaseHistoryRequest req);
}
