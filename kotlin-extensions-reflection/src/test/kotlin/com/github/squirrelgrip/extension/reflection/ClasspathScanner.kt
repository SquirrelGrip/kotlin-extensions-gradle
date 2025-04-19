package com.github.squirrelgrip.extension.reflection

import java.io.File
import java.util.*
import java.util.jar.JarFile
import kotlin.collections.mutableListOf

object ClasspathScanner {
    @JvmStatic
    fun main(args: Array<String>) {
        val classpath = System.getProperty("java.class.path")

        val separator = if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) ";" else ":"
        val paths = classpath.split(separator.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val classDetails = mutableListOf<ClassDetail>()

        for (path in paths) {
            val file = File(path)
            if (file.isDirectory()) {
                classDetails.addAll(scanDirectory(file, ""))
            } else if (path.endsWith(".jar")) {
                classDetails.addAll(scanJar(path))
            }
        }
        classDetails.forEach {
            println(it)
        }
    }

    private fun scanDirectory(directory: File, packageName: String?): List<ClassDetail> {
        val classDetails = mutableListOf<ClassDetail>()
        val files = directory.listFiles()
        if (files != null) {
            for (file in files) {
                if (file.isDirectory()) {
                    scanDirectory(file, packageName + file.getName() + ".")
                } else if (file.getName().endsWith(".class")) {
                    val className =
                        packageName + file.getName().substring(0, file.getName().length - 6) // Remove .class
                    classDetails.add(loadClass(file.parent, className))
                }
            }
        }
        return classDetails
    }

    private fun scanJar(jarFilePath: String): List<ClassDetail> {
        val jarFile = JarFile(jarFilePath)
        val entries = jarFile.entries()
        val classDetails = mutableListOf<ClassDetail>()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            if (entry.getName().endsWith(".class") && !entry.getName().equals("META-INF/versions/9/module-info.class")) {
                val className = entry.getName().replace("/", ".").substring(0, entry.getName().length - 6)
                classDetails.add(loadClass(jarFilePath, className))
            }
        }
        jarFile.close()
        return classDetails.toList()
    }

    private fun loadClass(filePath: String, className: String): ClassDetail {
        var loadable = false
        try {
            Class.forName(className)
            loadable = true
        } catch (_: NoClassDefFoundError) {
        }
        return ClassDetail(className, loadable)
    }
}
