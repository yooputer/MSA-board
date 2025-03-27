

##### MySQL 컨테이너 생성 명령어
```
docker pull mysql:8.0.38
docker run --name msa-board-mysql -e MYSQL_DATABASE=article -e MYSQL_ROOT_PASSWORD=12345678 -e TZ=Asia/Seoul -d -p 3306:3306 mysql:8.0.38
```