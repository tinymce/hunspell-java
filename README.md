# Hunspell for Java

Provides Java bindings and wrappers for [Hunspell 1.7](https://github.com/hunspell/hunspell). We generate [bridj](https://github.com/nativelibs4java/BridJ)
bindings with [jnaerator](https://github.com/nativelibs4java/JNAerator) and wrap the
automatically generated bindings. 


## Upgrading libhunspell
The libhunspell source code is included as a git submodule under `src/main/cpp/hunspell`. Update the submodule and then
rebuild hunspell. 


## Building libhunspell
Building for Linux is easy, just follow the official Hunspell documentation. Building for Windows is tricky because we
want to create a dll that statically links most dependencies. In general we want to create a static library with MXE and
then create a dynamic library from these static sources, including statically build runtime dependencies.


## Releasing
The CI deploys all changes on master to clojars. To create a new version (without -SNAPSHOT) create a MR that changes
the version in `pom.xml`, changes the changelog etc. When you are satisfied with the release merge it to master and the
CI will automatically deploy a new jar to clojars.
