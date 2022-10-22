Rest Api to create and fetch user:


curl command to create user:
curl -X POST http://localhost:8080/api/create-user -H "Content-Type: application/json" -d '{"id":1,"userName":"test1","profession":"IT","description":"remark"}'


curl command to load user:
curl http://localhost:8080/api/user/1 