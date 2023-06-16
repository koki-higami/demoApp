package com.example.sampledemo.client.purchase;

import com.example.sampledemo.client.dto.request.PurchaseHistoryFindBindRequest;
import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface PurchaseHistoryClient {

  ResponseEntity<List<PurchaseHistoryFindBindResponse>>  getPurchaseHistoryByUser(PurchaseHistoryFindBindRequest request);

}
