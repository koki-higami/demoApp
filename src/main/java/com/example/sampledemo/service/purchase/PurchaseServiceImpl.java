package com.example.sampledemo.service.purchase;

import com.example.sampledemo.client.dto.request.PurchaseHistoryFindBindRequest;
import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import com.example.sampledemo.client.purchase.PurchaseHistoryClient;
import com.example.sampledemo.service.dto.request.PurchaseHistoryFindRequest;
import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.response.PurchaseHistoriesFindResponse;
import com.example.sampledemo.service.dto.response.PurchaseHistoryFindResponse;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.user.UserSharedService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseHistoryClient client;

  private final UserSharedService userService;

  @Override public PurchaseHistoriesFindResponse  getPurchaseHistoriesByUser(PurchaseHistoryFindRequest request) {

    PurchaseHistoryFindBindRequest clientRequest = new PurchaseHistoryFindBindRequest(request.getUserId());
    ResponseEntity<List<PurchaseHistoryFindBindResponse>> historiesRes = client.getPurchaseHistoryByUser(clientRequest);
    List<PurchaseHistoryFindResponse> histories =
        historiesRes.getBody().stream().map(his -> new PurchaseHistoryFindResponse(his)).toList();

    UserFindResponse userInfo = userService.getUserById(new UserFindRequest(request));

    return new PurchaseHistoriesFindResponse(userInfo, histories);
  }
}
