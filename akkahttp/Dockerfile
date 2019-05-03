FROM maven:3.6.0-jdk-8-alpine as builder
COPY  . /root/app/
WORKDIR /root/app
RUN mvn dependency:resolve
RUN mvn install

FROM oracle/graalvm-ce:1.0.0-rc14 as graalvm
COPY --from=builder /root/app/ /home/app/
WORKDIR /home/app
#RUN native-image --no-server \
#                 --class-path target/hello-world.jar \
#                 -H:EnableURLProtocols=http \
#                 -H:Name=hello-world \
#                 -H:Class=com.briandevins.nativeimages.HelloWorld \
#                 --allow-incomplete-classpath
#
#
#FROM frolvlad/alpine-glibc
#EXPOSE 8080
#COPY --from=graalvm /home/app/hello-world .
#ENTRYPOINT ["./hello-world"]
