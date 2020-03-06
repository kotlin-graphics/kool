# kool

[![Build Status](https://github.com/kotlin-graphics/kool/workflows/build/badge.svg)](https://github.com/kotlin-graphics/kool/actions?workflow=build)
[![license](https://img.shields.io/badge/License-MIT-orange.svg)](https://github.com/kotlin-graphics/kool/blob/master/LICENSE) 
[![Release](https://jitpack.io/v/kotlin-graphics/kool.svg)](https://jitpack.io/#kotlin-graphics/kool) 
![Size](https://github-size-badge.herokuapp.com/kotlin-graphics/kool.svg)
[![Github All Releases](https://img.shields.io/github/downloads/kotlin-graphics/kool/total.svg)]()

Small util library featuring:

- functional programming for `IntBuffer`s
- short buffer and `CustomBuffer` plain parameters (`adr`, `pos`, `cap`, `rem`, `remSize`, `lim`)
- buffers set operators
- convenient conversions buffers <-> arrays
- dummy buffer constructors: `(size: Int)` and `(size: Int, init: (Int) -> *)`
- convenient `MemoryStack` extensions (like lambdas retrieving primitives via native memory)
- inline classes of primitive pointers
- `Stack` getters and setters
- other minor utils
