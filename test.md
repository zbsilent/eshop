## 测试说明

#### oauth2 

* 1 获取token 密码方式
```
http://127.0.0.1:8002/auth/oauth/token?grant_type=password&username=哈哈&password=1
```
* 2 获取当前登录用户信息
```
http://127.0.0.1:8002/auth/api/member?access_token=bd49dce4-78de-46a0-a606-b4acc3c9f6da
```
* 3  选择token存储位置
``` 
//jdbcTokenStore()
tokenServices.setTokenStore(tokenStore());
```
* 4 按access_token 访问网址
``` 
http://127.0.0.1:8002/member/api/query?access_token=35bd8d28-2b11-4304-a4ce-d6b7b94de725
```