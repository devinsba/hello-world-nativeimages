FROM oracle/graalvm-ce:1.0.0-rc16 as graalvm
COPY . /build
WORKDIR /build
RUN native-image --no-server \
                 --class-path target/hello-world.jar \
                 -H:EnableURLProtocols=http \
                 -H:Name=hello-world \
                 -H:Class=com.briandevins.nativeimages.HelloWorld


FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /build/hello-world .
ENTRYPOINT ["./hello-world"]
