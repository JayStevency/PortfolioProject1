# PortfolioProject1

본 프로젝트는 GitHub 에서 제공하는 API 데이터를 시각화 하는 프로그램입니다. 

## System Architecture 

- 전체 시스템 구성도

![System-Architecture](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Server-Architecture.png)

- Front-End Detail

![Front](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Front.png)

- Server1 Detail

![Server1](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Server1.png)

- Server2 Detail

![Server2](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/Server2.png)

## How to run project?
> Linux/Mac OS :
    
    - Requirement :
     > java 8
     > npm 3.9.3
     > gulp 3.9.1
      
    - git clone https://github.com/JayStevency/PortfolioProject1.git 
     
      1. WebFront 실행 : cd WebFront -> npm install
      2. WebServer 실행 : cd WebServer -> ./mvnw spring-boot:run
      3. MapReduce 실행 : cd MapReduce -> ./mvnw spring-boot:run

> Docker Container :

    - docker build -t image_name .
    - docker run -dit --name=docker_process_name -p $(WebFront_port):$(WebFront_port) image_name
    - docker exec -it docker_process_name /bin/bash
    - root# cd PortfolioProject1
        
      1. WebFront 실행 : cd WebFront -> npm install
      2. WebServer 실행 : cd WebServer -> ./mvnw spring-boot:run
      3. MapReduce 실행 : cd MapReduce -> ./mvnw spring-boot:run

    
   
    