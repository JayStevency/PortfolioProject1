FROM podbox/java8

RUN apt-get update

RUN apt-get install -y language-pack-ko

# set locale ko_KR
RUN locale-gen ko_KR.UTF-8

ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR.UTF-8
ENV LC_ALL ko_KR.UTF-8

RUN apt-get install -y \
	vim \
	git \
	net-tools \
	iputils-ping \
	curl


RUN curl -sL https://deb.nodesource.com/setup_6.x | bash -

RUN apt-get install -y nodejs

RUN git clone https://github.com/JayStevency/PortfolioProject1.git

RUN npm install -g gulp

CMD /bin/bash

EXPOSE 7000





