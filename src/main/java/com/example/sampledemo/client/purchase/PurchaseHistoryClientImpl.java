package com.example.sampledemo.client.purchase;

import com.example.sampledemo.client.dto.request.PurchaseHistoryFindBindRequest;
import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurchaseHistoryClientImpl implements PurchaseHistoryClient {

  @Override public ResponseEntity<List<PurchaseHistoryFindBindResponse>> getPurchaseHistoryByUser(
      PurchaseHistoryFindBindRequest request) {
    return null;
  }
}
