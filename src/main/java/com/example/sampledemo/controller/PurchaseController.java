package com.example.sampledemo.controller;

import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import com.example.sampledemo.controller.dto.response.BadUserPurchaseHistoriesResponse;
import com.example.sampledemo.controller.dto.response.UserPurchaseHistoriesResponse;
import com.example.sampledemo.service.dto.request.PurchaseHistoryFindRequest;
import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;
import com.example.sampledemo.service.purchase.BadPurchaseService;
import com.example.sampledemo.service.purchase.PurchaseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PurchaseController {

  private final PurchaseService service;

  private final BadPurchaseService badService;

  @GetMapping("/userPurchase")
  public UserPurchaseHistoriesResponse getUser(@Valid UserPurchaseHistoryRequest req) {

    PurchaseHistoryFindRequest requestData = new PurchaseHistoryFindRequest(req);
    PurchaseHistoriesFindResponse result = service.getPurchaseHistoriesByUser(requestData);

    return new UserPurchaseHistoriesResponse(result);
  }

  @GetMapping("/bad/userPurchase")
  public BadUserPurchaseHistoriesResponse badGetUser(@Valid UserPurchaseHistoryRequest req) {

    return badService.badGetPurchaseHistoriesByUser(req);
  }

}
