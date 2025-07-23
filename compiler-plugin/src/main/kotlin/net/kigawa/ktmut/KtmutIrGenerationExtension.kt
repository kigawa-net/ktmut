package net.kigawa.ktmut

import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

class KtmutIrGenerationExtension(
    private val generateValidationMethods: Boolean
) : IrGenerationExtension {
    
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        moduleFragment.transform(
            ValidationTransformer(pluginContext, generateValidationMethods),
            null
        )
    }
}

class ValidationTransformer(
    private val pluginContext: IrPluginContext,
    private val generateValidationMethods: Boolean
) : IrElementTransformerVoidWithContext() {
    
    // TODO: Implement IR transformation logic for validation code generation
}