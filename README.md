# kurly

![image](https://user-images.githubusercontent.com/46153703/115948416-38baff80-a509-11eb-8b28-11650ff9542d.png)

## api
전체조회  
GET http://www.kulry.shop/api/v1/goods  
개별조회  
GET http://www.kulry.shop/api/v1/goods/{id}  
저장  
POST http://www.kulry.shop/api/v1/goods  

기타  
GET http://www.kulry.shop/api/v2/goods/{id}  
GET http://www.kulry.shop/api/admin/v1/goods  
GET http://www.kulry.shop/api/admin/v1/goods/{id}  

조회 성공 시  
200  

저장 성공 시  
201  

없는값 조회 시  
404  
![image](https://user-images.githubusercontent.com/46153703/115948557-a8c98580-a509-11eb-985e-d53c514a156e.png)  

@Valid 실패 시  
400  
![image](https://user-images.githubusercontent.com/46153703/115948602-f514c580-a509-11eb-866a-ca6bef91a586.png)  
 
