package com.example.sampledemo.controller.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoUpdateRequest {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;
  @NotBlank
  private String email;
}
