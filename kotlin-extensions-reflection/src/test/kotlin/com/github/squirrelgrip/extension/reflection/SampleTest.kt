package com.github.squirrelgrip.extension.reflection

import org.junit.jupiter.api.Test
import java.net.URLClassLoader

class SampleTest{
    @Test
    fun listJars() {
        var classLoader = Thread.currentThread().contextClassLoader
        val jarFiles = mutableListOf<String>()

        while (classLoader != null) {
            if (classLoader is URLClassLoader) {
                jarFiles += classLoader.urLs
//                    .filter { it.path.endsWith(".jar") }
                    .map { it.path }
            }
            classLoader = classLoader.parent
        }

        jarFiles.forEach(::println)
    }
}
