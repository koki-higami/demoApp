package com.example.sampledemo.client.purchase;

import com.example.sampledemo.client.dto.request.PurchaseHistoryFindBindRequest;
import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MockPurchaseHistoryClientImpl implements PurchaseHistoryClient {

  private List<PurchaseHistoryFindBindResponse> histories = new ArrayList<>();

  MockPurchaseHistoryClientImpl() {
    this.histories.add(new PurchaseHistoryFindBindResponse(1, LocalDate.now(), "tv", 10));
    this.histories.add(new PurchaseHistoryFindBindResponse(2, LocalDate.now(), "car", 10));
    this.histories.add(new PurchaseHistoryFindBindResponse(1, LocalDate.now(), "car", 1));
    this.histories.add(new PurchaseHistoryFindBindResponse(3, LocalDate.now(), "smartPhone", 10));
    this.histories.add(new PurchaseHistoryFindBindResponse(1, LocalDate.now(), "smartPhone", 10));
  }

  @Override public ResponseEntity<List<PurchaseHistoryFindBindResponse>> getPurchaseHistoryByUser(
      PurchaseHistoryFindBindRequest request) {

    List<PurchaseHistoryFindBindResponse> result =
        histories.stream().filter(his -> his.getUserId() == request.getUserId()).toList();

    return ResponseEntity.ok(result);
  }
}
