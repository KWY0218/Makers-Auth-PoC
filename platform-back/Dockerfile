FROM amd64/amazoncorretto:17

WORKDIR /platform-back/app

COPY ./platform-back/app/build/libs/platform-back-0.0.1-SNAPSHOT.jar /platform-back/app/platform-back.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]
