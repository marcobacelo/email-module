FROM node:10.17.0

COPY run.sh /

RUN ["chmod", "+x", "/run.sh"]

WORKDIR /app

VOLUME /app

RUN apt-get update && apt-get install -y -q --no-install-recommends \
        apt-transport-https \
        build-essential \
        ca-certificates \
        curl \
        git \
        libssl-dev \
        wget \
    && rm -rf /var/lib/apt/lists/*

RUN npm install -g @angular/cli

EXPOSE 4200

CMD ["sh", "/run.sh"]
