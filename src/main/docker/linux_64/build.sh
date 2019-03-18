#!/usr/bin/env bash
autoreconf -vfi
./configure
make
cp ./src/hunspell/.libs/libhunspell-*.so ../../resources/org/bridj/lib/linux_x64/libhunspell.so
strip ../../resources/org/bridj/lib/linux_x64/libhunspell.so