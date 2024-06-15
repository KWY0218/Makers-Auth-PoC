FROM amd64/amazoncorretto:17

COPY ./build/libs/platform-back-0.0.1-SNAPSHOT.jar /platform-back.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]