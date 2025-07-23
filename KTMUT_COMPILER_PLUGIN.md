# KTMUT - Kotlin Compiler Plugin for Annotation-based Validation

## 概要

KTMUTは、アノテーションを使用してKotlinコードにバリデーション機能を提供するコンパイラプラグインです。コンパイル時にアノテーションを解析し、実行時バリデーションコードを自動生成します。

## プロジェクト構造

```
ktmut/
├── compiler-plugin/          # コンパイラプラグインのメインモジュール
│   ├── src/main/kotlin/
│   │   ├── com/kigawa/ktmut/
│   │   │   ├── KtmutCommandLineProcessor.kt
│   │   │   ├── KtmutCompilerPluginRegistrar.kt
│   │   │   ├── KtmutIrGenerationExtension.kt
│   │   │   └── transform/
│   │   │       ├── ValidationTransformer.kt
│   │   │       └── AnnotationProcessor.kt
│   │   └── resources/
│   │       └── META-INF/services/
│   │           └── org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
│   └── build.gradle.kts
├── gradle-plugin/            # Gradleプラグイン
│   ├── src/main/kotlin/
│   │   └── com/kigawa/ktmut/gradle/
│   │       └── KtmutGradlePlugin.kt
│   └── build.gradle.kts
├── annotations/              # バリデーションアノテーション定義
│   ├── src/main/kotlin/
│   │   └── com/kigawa/ktmut/annotations/
│   │       ├── Validate.kt
│   │       ├── NotNull.kt
│   │       ├── Range.kt
│   │       ├── Pattern.kt
│   │       └── Custom.kt
│   └── build.gradle.kts
├── runtime/                  # 実行時ライブラリ
│   ├── src/main/kotlin/
│   │   └── com/kigawa/ktmut/runtime/
│   │       ├── ValidationEngine.kt
│   │       ├── ValidationResult.kt
│   │       └── exceptions/
│   │           └── ValidationException.kt
│   └── build.gradle.kts
├── sample/                   # サンプルプロジェクト
│   ├── src/main/kotlin/
│   │   └── Sample.kt
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## 開発手順

### 1. プロジェクト初期化

```bash
# Gradleプロジェクト作成
mkdir ktmut
cd ktmut
gradle init --type kotlin-library --dsl kotlin

# サブプロジェクト構造作成
mkdir -p compiler-plugin/src/main/kotlin/com/kigawa/ktmut
mkdir -p gradle-plugin/src/main/kotlin/com/kigawa/ktmut/gradle
mkdir -p annotations/src/main/kotlin/com/kigawa/ktmut/annotations
mkdir -p runtime/src/main/kotlin/com/kigawa/ktmut/runtime
mkdir -p sample/src/main/kotlin
```



## 使用方法

### 1. build.gradle.kts設定

```kotlin
plugins {
    kotlin("jvm") version "1.9.0"
    id("com.kigawa.ktmut") version "1.0.0"
}

dependencies {
    implementation("com.kigawa:ktmut-annotations:1.0.0")
    implementation("com.kigawa:ktmut-runtime:1.0.0")
}

ktmut {
    enabled = true
    generateValidationMethods = true
}
```


## テスト戦略

1. **単体テスト**: 各アノテーションの動作確認
2. **統合テスト**: コンパイラプラグイン全体の動作確認
3. **パフォーマンステスト**: 大規模プロジェクトでのコンパイル時間測定
4. **互換性テスト**: 異なるKotlinバージョンでの動作確認

## デプロイメント

1. **Maven Central公開**: Gradleプラグインポータルとの連携
2. **バージョニング**: セマンティックバージョニング採用
3. **ドキュメント**: KDocとMarkdownドキュメントの充実
4. **CI/CD**: GitHub Actionsでの自動テスト・リリース