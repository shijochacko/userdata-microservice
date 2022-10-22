# USER DATA -  CREATE & FETCH SERVICE

How to run this application


Step 1 : clone git directory url
git clone https://github.com/shijochacko/UserData-CRUD.git


Step 2 : move to directory using below command

cd UserData-CRUD

step 3 : build application using gradle

gradle clean build

step 4 : run application using gradle

gradle bootRun

step 5 : use below  url in browser to view  the application


curl command to create user:
curl -X POST http://localhost:8080/api/create-user -H "Content-Type: application/json" -d '{"id":1,"userName":"test1","profession":"IT","description":"remark"}'


curl command to load user:
curl http://localhost:8080/api/user/1 