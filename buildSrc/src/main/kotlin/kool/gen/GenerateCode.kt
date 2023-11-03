package kool.gen

import kool.*
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.file.ProjectLayout
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

abstract class GenerateCode: DefaultTask() {

    init {
        group = "build"
        description = "Generate code"
    }

    @get:Inject
    abstract val layout: ProjectLayout

    @get:Inject
    abstract val files: FileSystemOperations

    @get:OutputDirectory
    val targetDir: Directory = layout.projectDirectory.dir("src/mainGen/kotlin")

    @TaskAction
    fun generate() {
        files.delete { delete(targetDir) }
        val target = targetDir.asFile

        ubuffers(target)

        buffersJvm(target)

        iterators(target)

        extensions(target)

        builders(target)

        conversions(target)

        pointers(target)

        stackExts(target)

        stack(target)

        unsafe(target)
    }
}

fun generate(targetDir: File, file: String, block: Generator.() -> Unit) {
    Generator(targetDir).apply {
        builder.append('\n')
        block()
        for (import in imports)
            builder.insert(0, "import $import\n")
        if (`package`.isNotEmpty())
            builder.insert(0, "package $`package`\n")
        if (experimentals.isNotEmpty()) {
            val list = experimentals.joinToString { "${it.pkg}.Experimental${it.name}::class" }
            builder.insert(0, "@file:OptIn($list)\n")
        }
        if (disableNameShadowing)
            builder.insert(0, "@file:Suppress(\"NAME_SHADOWING\")\n")
        if (suppressInlineWarning)
            builder.insert(0, "@file:Suppress(\"NOTHING_TO_INLINE\")\n")
        write(file)
    }
}

