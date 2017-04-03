# WebServer

클라이언트 요청 및 응답을 처리하는 API 서버

## Server Architecture

![Server1](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Server1.png)


### 서버 주요 기능 :
#### Spring-boot

> 데이터 전달 및 데이터 저장

#### MongoDB

> 검색 데이터 결과 저장


#### Cache-Module

> 검색 데이터 캐싱 모듈

## How to run Server?

### 요구사항 :

- JAVA : 1.8 
- Maven : 3.3.9 
- Mongo : 3.2.7
- Spring-boot : 1.5.2

### 실행 방법

1. 빌드 방법
    
>**pom.xml** 파일이 있는 경로에서 ```mvn clean package```

 
2. 빌드 후 run


  >```java -jar target/webserver-0.0.1-SNAPSHOT.jar``` 
  >
  >  혹은
  >
  >```mvn spring-boot:run```

#### Cache-Managing

 ###LRU
    
     > Request Queue(size : 10)에 search data 관리 
     > Cache가 가득 차면 Request Queue에 가장 오래 전에 등장한 Search data 반환
     > NoSql에 캐시에 삭제 된 데이터 저장
