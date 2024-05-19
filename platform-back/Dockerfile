FROM amd64/amazoncorretto:17 AS BUILD

WORKDIR /app

COPY gradlew .
RUN sed -i 's/\r$//' gradlew
COPY gradle ./gradle
COPY build.gradle .
COPY settings.gradle .

COPY src ./src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

FROM amd64/amazoncorretto:17

WORKDIR /app

COPY --from=build /app/build/libs/platform-back-0.0.1-SNAPSHOT.jar /app/platform-back.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]