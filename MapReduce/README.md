# MapReduce Program

GitHub 데이터를 렌더링 하는 API 서버

## Server Architecture

![Server2](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Server2.png)


### 서버 주요 기능 :

#### Spring-boot
 > GitHub 데이터 조회 
 
#### MapReduce
 
 > GitHub Repository Language 데이터 빈도 수 계산

## How to run Server?

### 요구사항 :

- JAVA : 1.8 
- Maven : 3.3.9
- Spring-boot : 1.5.2

### 실행 방법

1. Run
    
>**pom.xml** 파일이 있는 경로에서 ```mvn clean package``` 후 ```java -jar target/webserver-0.0.1-SNAPSHOT.jar``` 
>
> 혹은
>
> ```mvn spring-boot:run```
 
## MapReduce 구현
 
  **JobTracker** 
  
    > Map task 와 Reduce task에 데이터 할당
      
  **JobPool**
    
    > ExecutorService 로 스레드 관리
    > Map task -> FixedThreadPool
    > Reduce task -> SingleThreadPool
    
  **JobMap**
  
    > GitHub Language 데이터 빈도수 계산

  **JobReduce**
  
    > Map 결과를 합치는 작업
  
