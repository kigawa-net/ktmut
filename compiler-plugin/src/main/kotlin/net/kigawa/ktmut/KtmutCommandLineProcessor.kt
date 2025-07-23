package net.kigawa.ktmut

import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

@OptIn(org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi::class)
class KtmutCommandLineProcessor : CommandLineProcessor {
    
    companion object {
        const val PLUGIN_ID = "ktmut"
        
        val ARG_ENABLED = CompilerConfigurationKey<Boolean>("enabled")
        val ARG_GENERATE_VALIDATION_METHODS = CompilerConfigurationKey<Boolean>("generateValidationMethods")
        
        val OPTION_ENABLED = CliOption(
            optionName = "enabled",
            valueDescription = "true|false",
            description = "Enable KTMUT plugin",
            required = false
        )
        
        val OPTION_GENERATE_VALIDATION_METHODS = CliOption(
            optionName = "generateValidationMethods", 
            valueDescription = "true|false",
            description = "Generate validation methods",
            required = false
        )
    }
    
    override val pluginId: String = PLUGIN_ID
    
    override val pluginOptions: Collection<AbstractCliOption> = listOf(
        OPTION_ENABLED,
        OPTION_GENERATE_VALIDATION_METHODS
    )
    
    override fun processOption(
        option: AbstractCliOption,
        value: String,
        configuration: CompilerConfiguration
    ) {
        when (option) {
            OPTION_ENABLED -> configuration.put(ARG_ENABLED, value.toBoolean())
            OPTION_GENERATE_VALIDATION_METHODS -> configuration.put(ARG_GENERATE_VALIDATION_METHODS, value.toBoolean())
        }
    }
}