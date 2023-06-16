package com.example.sampledemo.service.dto.response;

import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class PurchaseHistoryFindResponse {
  private Integer userId;
  private LocalDate purchaseDate;
  private String itemName;
  private Integer itemAmount;

  public PurchaseHistoryFindResponse(PurchaseHistoryFindBindResponse his) {
    this.userId = his.getUserId();
    this.purchaseDate = his.getPurchaseDate();
    this.itemAmount = his.getItemAmount();
    this.itemName = his.getItemName();
  }
}
