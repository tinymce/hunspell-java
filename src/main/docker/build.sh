#!/usr/bin/env bash
set -o errexit nounset xtrace pipefail
autoreconf -vfi

make clean
./configure --disable-static --host=x86_64-w64-mingw32
make
cp ./src/hunspell/.libs/libhunspell-*.dll ../../resources/org/bridj/lib/win64/libhunspell.dll
strip ../../resources/org/bridj/lib/win64/libhunspell.dll

make clean
./configure --disable-static
make
cp ./src/hunspell/.libs/libhunspell-*.so ../../resources/org/bridj/lib/linux_x64/libhunspell.so
strip ../../resources/org/bridj/lib/linux_x64/libhunspell.so
