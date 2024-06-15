FROM amd64/amazoncorretto:17

WORKDIR /app

COPY ./platform-back/build/libs/platform-back-0.0.1-SNAPSHOT.jar /app/platform-back.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]