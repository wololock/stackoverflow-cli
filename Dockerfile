FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/stackoverflow-cli
WORKDIR /home/app/stackoverflow-cli

RUN native-image --no-server -cp build/libs/stackoverflow-cli-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/stackoverflow-cli/stackoverflow-cli /app/stackoverflow-cli
ENTRYPOINT ["/app/stackoverflow-cli"]
