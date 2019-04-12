FROM debian
VOLUME /hunspell-java
RUN apt-get update
RUN apt-get -y install git g++ make autoconf automake autopoint libtool
WORKDIR /hunspell-java/src/main/cpp/hunspell
ADD build.sh /build.sh
CMD /build.sh