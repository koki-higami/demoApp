# 動作手順

- 適当なフォルダで以下を実施
    - ```git clone git@github.com:koki-higami/demoApp.git```
-

# ユースケース

- ユーザ検索
    - ユーザ情報が返却される
        - メールアドレスはマスクされる
- ユーザ登録
    - ユーザが新規登録される
- ユーザ購買検索
  - 設定したユーザの購買情報、ユーザ情報が返却される

## イメージ
![classImage.png](src%2FclassImage.png)

## API
### ユーザ検索
リクエスト
```
curl --location 'http://localhost:8080/userInfo?userId=1'
```

レスポンス
```
  {
    "userId": 1,
    "firstName": "test",
    "lastName": "test",
    "email": "*************"
  }
```
 
### ユーザ登録
リクエスト
```
curl --location 'http://localhost:8080/userInfo' \
--header 'Content-Type: application/json' \
--data '{
  "firstName":"test-fistName",
  "lastName": "test-lastName",
  "email": "aaa.com"
}'
```

レスポンス
```
  {
  "userId": 6,
  "firstName": "test-fistName",
  "lastName": "test-lastName",
  "email": "aaa.com"
  }
```
### ユーザ購買検索
リクエスト
```
curl --location 'http://localhost:8080/userPurchase?userId=1'
```
レスポンス
```
{
    "userInfo": {
        "userId": 1,
        "firstName": "test",
        "lastName": "test"
    },
    "histories": [
        {
            "purchaseDate": "2023-06-22",
            "itemName": "tv",
            "itemAmount": 10
        },
        {
            "purchaseDate": "2023-06-22",
            "itemName": "car",
            "itemAmount": 1
        },
        {
            "purchaseDate": "2023-06-22",
            "itemName": "smartPhone",
            "itemAmount": 10
        }
    ]
}
```