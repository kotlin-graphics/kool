# kool

[![Build Status](https://github.com/kotlin-graphics/kool/workflows/build/badge.svg)](https://github.com/kotlin-graphics/kool/actions?workflow=build)
[![license](https://img.shields.io/badge/License-MIT-orange.svg)](https://github.com/kotlin-graphics/kool/blob/master/LICENSE) 
[![Release](https://jitpack.io/v/kotlin-graphics/kool.svg)](https://jitpack.io/#kotlin-graphics/kool) 
![Size](https://github-size-badge.herokuapp.com/kotlin-graphics/kool.svg)
[![Github All Releases](https://img.shields.io/github/downloads/kotlin-graphics/kool/total.svg)]()

[comment]: <> ([![Contributor Covenant]&#40;https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg&#41;]&#40;code_of_conduct.md&#41;)

[<img src="https://unsigned.netlify.app/images/docs_logo.svg">](https://kx-kool.netlify.app)

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

### Publishing

Same for the snapshots of this project, they are published on the same repository, if you want to use it, just add to
your `build.gradle.kts`

```kotlin
repositories {
    maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
}
```

Releases, which are less frequent, would be instead published on [scijava](https://maven.scijava.org/).

Every build is, nonetheless, still on Jitpack, which although is quite cool and comfortable, its design has some severe criticality.
