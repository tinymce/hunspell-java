# Hunspell for Java

Copied and adapted from [hunspell-java project](https://gitlab.com/dumonts/hunspell-java)

Provides Java bindings and wrappers for [Hunspell 1.7](https://github.com/hunspell/hunspell). We generate JNA
bindings with [jnaerator](https://github.com/nativelibs4java/JNAerator) and wrap the automatically generated bindings. 


## Upgrading libhunspell
The libhunspell source code is included as a git submodule under `src/main/cpp/hunspell`. Update the submodule and then
rebuild hunspell. 

## Building libhunspell
Building for Linux is fairly straightforward. Install required build dependencies [hunspell documentation](https://github.com/hunspell/hunspell#dependencies).
After installing dependencies, the following steps should work. If it doesn't, refer to the build instructions of hunspell.

```
git submodule init
git submodule update
cd src/main/cpp/hunspell
autoreconf -vfi
./configure
make
cp src/hunspell/.libs/libhunspell-1.7.so ../../resources/linux-x86-64/libhunspell.so
```

The last step copies the dynamic library to the appropriate resource folder (assuming you build on a 64 bit system).
You can use `strip` to save some space on debug symbols. 

After building libhunspell for all desired platforms and moving the binaries to the proper resources folder, you 
can use the usual maven lifecycle to build, test, package and deploy the java side of things. For example to generate
jars run `mvm package`.

Then you can push the artifact manually into the Eng CI S3 bucket to keep it available for other projects (Spelling-monorepo for example).
Currently it's been published into `tiny-sbt-snapshots` and `tiny-sbt-releases` folders.