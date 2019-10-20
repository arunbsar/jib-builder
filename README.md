# A simple java(Jib) based image builder


### How to run
```bash
./gradlew build
```
```bash
java -jar build/libs/jib-builder.jar \
-src helloworld.sh \
-from alpine:latest \
-to arunbsar/jib-test:v1.0 \
-e /bin/sh \
-e /helloworld.sh \
--type registry \
-user <username> \
-pass <password> \
```
### TODO

- [ ] Add more options, like ports, env variables
- [ ] Ability to use Dockerfile or use config file 
- [ ] Ability to build other type of image currently only builds Dockerdaemon image
- [ ] Ability to use layer chaching 