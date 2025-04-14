

##### 도커 명령어
```
# MySQL 이미지 다운로드
docker pull mysql:8.0.38

# 볼륨 생성
docker volume create msa-board-mysql-volume

# MySQL 컨테이너 생성
docker run --name msa-board-mysql -e MYSQL_DATABASE=article -e MYSQL_ROOT_PASSWORD=12345678 -e TZ=Asia/Seoul -d -p 3306:3306 -v msa-board-mysql-volume:/var/lib/mysql mysql:8.0.38

# Redis 컨테이너 생성
docker run --name msa-board-redis -d -p 6379:6379 redis:7.4

# MySQL 컨테이너 접속
docker exec -it msa-board-mysql bash

# mysql 접속
mysql -u root -p 
use article;
```