package com.example.sampledemo.service.purchase;

import com.example.sampledemo.client.dto.request.PurchaseHistoryFindBindRequest;
import com.example.sampledemo.client.dto.response.PurchaseHistoryFindBindResponse;
import com.example.sampledemo.client.purchase.PurchaseHistoryClient;
import com.example.sampledemo.controller.dto.request.UserPurchaseHistoryRequest;
import com.example.sampledemo.controller.dto.response.BadUserPurchaseHistoriesResponse;
import com.example.sampledemo.service.dto.request.UserFindRequest;
import com.example.sampledemo.service.dto.response.PurchaseHistoryFindResponse;
import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.user.UserSharedService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BadPurchaseServiceImpl implements BadPurchaseService {

  private final PurchaseHistoryClient client;

  private final UserSharedService userService;

  @Override
  public BadUserPurchaseHistoriesResponse badGetPurchaseHistoriesByUser(UserPurchaseHistoryRequest req) {
    //レイヤーを跨いだDTOを使用すると、各層のDTOが入り混じり、混乱する？
    //将来的にクライアントのDTOの項目修正する時に、

    PurchaseHistoryFindBindRequest clientRequest = new PurchaseHistoryFindBindRequest(req.getUserId());
    List<PurchaseHistoryFindBindResponse> historiesRes = client.getPurchaseHistoryByUser(clientRequest).getBody();
    assert historiesRes != null;
    List<PurchaseHistoryFindResponse> histories =
        historiesRes.stream().map(PurchaseHistoryFindResponse::new).toList();

    UserFindRequest u = new UserFindRequest();
    u.setUserId(req.getUserId());
    UserFindResponse userInfo = userService.getUserById(u);

    return new BadUserPurchaseHistoriesResponse(userInfo, histories);
  }
}
