FROM openjdk:8-alpine

RUN apk update && apk add git vim bash wget make

WORKDIR /usr/src/app
ENV CLASSPATH ${CLASSPATH}:/etc/jars/*

# Copy setup script
COPY setup_sdk.sh /usr/src/app/
RUN chmod a+x /usr/src/app/setup_sdk.sh

ENTRYPOINT [ "/usr/src/app/setup_sdk.sh" ]