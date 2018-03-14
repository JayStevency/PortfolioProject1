# Visualization-Github

This project is to visualize own's repository data using github api 

## Demo Page

![Visual-Github](https://github.com/JayStevency/JayStevency/blob/master/PortfolioProject1/VisualGithub.png)

## System Architecture 

- Entire Architecture

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
     > mongodb
      
    - git clone https://github.com/JayStevency/PortfolioProject1.git 
     
      1. WebFront exec : cd WebFront -> npm install -> gulp run
      2. WebServer exec : cd WebServer -> ./mvnw spring-boot:run (optional : mongod)
      3. MapReduce exec : cd MapReduce -> ./mvnw spring-boot:run

> Docker Container :

    - docker build -t image_name .
    - docker run -dit --name=docker_process_name -p $(WebFront_port):$(WebFront_port) image_name
    - docker exec -it docker_process_name /bin/bash
    - root# cd PortfolioProject1
        
      1. WebFront exec : cd WebFront -> npm install
      2. WebServer exec : cd WebServer -> ./mvnw spring-boot:run
      3. MapReduce exec : cd MapReduce -> ./mvnw spring-boot:run

    
   
    