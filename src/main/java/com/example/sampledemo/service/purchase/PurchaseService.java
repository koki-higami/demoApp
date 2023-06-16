package com.example.sampledemo.service.purchase;

import com.example.sampledemo.service.dto.request.PurchaseHistoryFindRequest;
import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;

public interface PurchaseService {

  public PurchaseHistoriesFindResponse getPurchaseHistoriesByUser(PurchaseHistoryFindRequest request);
}
