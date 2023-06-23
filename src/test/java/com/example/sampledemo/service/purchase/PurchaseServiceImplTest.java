package com.example.sampledemo.service.purchase;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.sampledemo.client.purchase.MockPurchaseHistoryClientImpl;
import com.example.sampledemo.client.user.MockUserClientImpl;
import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import com.example.sampledemo.service.dto.request.PurchaseHistoryFindRequest;
import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;
import com.example.sampledemo.service.dto.response.PurchaseHistoryFindResponse;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.user.UserSharedServiceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class PurchaseServiceImplTest {

  //手動でDI、spring boot test使うより、起動が早くなった
  PurchaseService target =
      new PurchaseServiceImpl(new MockPurchaseHistoryClientImpl(), new UserSharedServiceImpl(new MockUserClientImpl()));

  @Nested
  class GetPurchaseHistoriesByUser {

    @Test
    void successTest() {

      PurchaseHistoryFindRequest req =
          new PurchaseHistoryFindRequest(new UserPurchaseHistoryRequest(1));

      PurchaseHistoriesFindResponse result = target.getPurchaseHistoriesByUser(req);

      PurchaseHistoryFindResponse purchaseInfo = result.getHistories().get(0);
      UserFindResponse userInfo = result.getUserInfo();
      assertAll(
          () -> assertEquals(1, purchaseInfo.getUserId()),
          () -> assertEquals("tv", purchaseInfo.getItemName()),
          () -> assertEquals(10, purchaseInfo.getItemAmount()),
          () -> assertEquals(1, userInfo.getUserId()),
          () -> assertEquals("test", userInfo.getFirstName()),
          () -> assertEquals("test", userInfo.getLastName()),
          () -> assertEquals("test-mail.com", userInfo.getEmail())
      );

    }
  }


}