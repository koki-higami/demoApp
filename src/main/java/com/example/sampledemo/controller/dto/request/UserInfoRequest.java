package com.example.sampledemo.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class UserInfoRequest {

  @NotNull
  private Integer userId;
//  private String email;

}
