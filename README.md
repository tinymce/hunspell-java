# Hunspell for Java

Provides Java bindings and wrappers for [Hunspell 1.7](https://github.com/hunspell/hunspell). We generate [bridj](https://github.com/nativelibs4java/BridJ)
bindings with [jnaerator](https://github.com/nativelibs4java/JNAerator) and wrap the
automatically generated bindings. 


## Upgrading libhunspell
The libhunspell source code is included as a git submodule under `src/main/cpp/hunspell`. Update the submodule and then
rebuild hunspell. 


## Building libhunspell
You can find a Dockerfile for building Hunspell for Windows and Linux under `src/main/docker/`.
Build the image with `docker build -t build-hunspell src/main/docker/`
Then run a container with the source code mounted `docker run -v ${PWD}:/hunspell-java build-hunspell`. This will create
the shared libraries under `src/main/resources/org/bridj/lib/`.


## Releasing
The CI deploys all changes on master to clojars. To create a new version (without -SNAPSHOT) create a MR that changes
the version in `pom.xml`, changes the changelog etc. When you are satisfied with the release merge it to master and the
CI will automatically deploy a new jar to clojars.
