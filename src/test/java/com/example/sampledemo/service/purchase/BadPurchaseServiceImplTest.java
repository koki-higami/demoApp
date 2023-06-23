package com.example.sampledemo.service.purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.sampledemo.client.purchase.MockPurchaseHistoryClientImpl;
import com.example.sampledemo.client.user.MockUserClientImpl;
import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import com.example.sampledemo.controller.dto.response.BadUserPurchaseHistoriesResponse;
import com.example.sampledemo.controller.dto.response.BadUserPurchaseHistoriesResponse.PurchaseUser;
import com.example.sampledemo.service.user.UserSharedServiceImpl;
import org.junit.jupiter.api.Test;

class BadPurchaseServiceImplTest {

  BadPurchaseService target =
      new BadPurchaseServiceImpl(new MockPurchaseHistoryClientImpl(),
          new UserSharedServiceImpl(new MockUserClientImpl()));

  @Test
  void badGetPurchaseHistoriesByUser() {

    UserPurchaseHistoryRequest req = new UserPurchaseHistoryRequest(1);
    BadUserPurchaseHistoriesResponse response = target.badGetPurchaseHistoriesByUser(req);

    PurchaseUser userInfo = response.getUserInfo();
    assertEquals(1, userInfo.getUserId());
    assertEquals("test", userInfo.getFirstName());
    assertEquals("test", userInfo.getLastName());
  }


}