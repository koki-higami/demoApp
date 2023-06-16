package com.example.sampledemo.controller.dto.response;

import com.example.sampledemo.service.dto.response.PurchaseHistoryFindResponse;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UserPurchaseHistoryResponse {
  private Integer userId;
  private LocalDate purchaseDate;
  private String itemName;
  private Integer itemAmount;


  public UserPurchaseHistoryResponse(PurchaseHistoryFindResponse data) {
    this.userId = data.getUserId();
    this.purchaseDate = data.getPurchaseDate();
    this.itemName = data.getItemName();
    this.itemAmount = data.getItemAmount();
  }
}
