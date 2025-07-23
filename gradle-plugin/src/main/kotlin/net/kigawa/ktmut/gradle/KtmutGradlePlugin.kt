package net.kigawa.ktmut.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

class KtmutGradlePlugin : KotlinCompilerPluginSupportPlugin {
    
    override fun apply(target: Project) {
        target.extensions.create("ktmut", KtmutExtension::class.java)
    }
    
    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
        return kotlinCompilation.target.project.plugins.hasPlugin(KtmutGradlePlugin::class.java)
    }
    
    override fun getCompilerPluginId(): String = "ktmut"
    
    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId = "net.kigawa",
        artifactId = "ktmut-compiler-plugin",
        version = "1.0.0"
    )
    
    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project
        return project.provider {
            val extension = project.extensions.findByType(KtmutExtension::class.java) ?: KtmutExtension()
            
            listOf(
                SubpluginOption(key = "enabled", value = extension.enabled.toString()),
                SubpluginOption(key = "generateValidationMethods", value = extension.generateValidationMethods.toString())
            )
        }
    }
}

open class KtmutExtension {
    var enabled: Boolean = true
    var generateValidationMethods: Boolean = true
}