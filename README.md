

##### 도커 명령어
```
# 볼륨 생성
docker volume create msa-board-mysql-volume

# MySQL 컨테이너 생성
docker run --name msa-board-mysql -e MYSQL_DATABASE=article -e MYSQL_ROOT_PASSWORD=12345678 -e TZ=Asia/Seoul -d -p 3306:3306 -v msa-board-mysql-volume:/var/lib/mysql mysql:8.0.38

# Redis 컨테이너 생성
docker run --name msa-board-redis -d -p 6379:6379 redis:7.4

# Kafka 컨테이너 생성
docker run -d --name msa-board-kafka -p 9092:9092 apache/kafka:3.8.0


# MySQL 컨테이너 접속
docker exec -it msa-board-mysql bash

# Kafka 컨테이너 접속
docker exec --workdir /opt/kafka/bin/ -it msa-board-kafka sh
```

##### MySQL 명령어
```
# mysql 접속
mysql -u root -p 
use article;
```

##### Kafka 명령어
```
# 토픽 생성
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic msa-board-article --replication-factor 1 --partitions 3
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic msa-board-comment --replication-factor 1 --partitions 3
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic msa-board-like --replication-factor 1 --partitions 3
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic msa-board-view --replication-factor 1 --partitions 3

# 토픽 조회
./kafka-topics.sh --bootstrap-server localhost:9092 --list
```