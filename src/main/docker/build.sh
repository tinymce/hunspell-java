#!/usr/bin/env bash
set -o errexit nounset xtrace pipefail
autoreconf -vfi

./configure --disable-static --host=x86_64-w64-mingw32
make clean
make
cp ./src/hunspell/.libs/libhunspell-*.dll ../../resources/org/bridj/lib/win64/hunspell.dll
# strip ../../resources/org/bridj/lib/win64/hunspell.dll

./configure --disable-static
make clean
make
cp ./src/hunspell/.libs/libhunspell-*.so ../../resources/org/bridj/lib/linux_x64/libhunspell.so
# strip ../../resources/org/bridj/lib/linux_x64/libhunspell.so
