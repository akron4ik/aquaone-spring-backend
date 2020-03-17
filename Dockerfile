# back
# устанавливаем версию JVM
FROM openjdk:11

# указываем ярлык. Например, разработчика образа и проч. Необязательный пункт.
LABEL maintainer="aron4ik"

# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=target/aquaone-0.0.1-SNAPSHOT.jar


ADD ${JAR_FILE} aquaone.jar

# команда запуска джарника
ENTRYPOINT ["java","-XX:+UseContainerSupport", "-jar","/aquaone.jar"]