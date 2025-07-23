package net.kigawa.ktmut

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@OptIn(org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi::class)
class KtmutCompilerPluginRegistrar : CompilerPluginRegistrar() {
    
    override val supportsK2: Boolean = true
    
    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        val enabled = configuration.get(KtmutCommandLineProcessor.ARG_ENABLED, true)
        if (!enabled) return
        
        val generateValidationMethods = configuration.get(
            KtmutCommandLineProcessor.ARG_GENERATE_VALIDATION_METHODS, 
            true
        )
        
        IrGenerationExtension.registerExtension(
            KtmutIrGenerationExtension(generateValidationMethods)
        )
    }
}