package com.example.sampledemo.client.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseHistoryFindBindResponse {

  private Integer userId;
  private LocalDate purchaseDate;
  private String itemName;
  private Integer itemAmount;

}
