# KTMUT - Kotlin Compiler Plugin for Annotation-based Validation

KTMUTは、アノテーションを使用してKotlinコードにバリデーション機能を提供するコンパイラプラグインです。コンパイル時にアノテーションを解析し、実行時バリデーションコードを自動生成します。

## 特徴

- **コンパイル時バリデーション**: アノテーションベースのバリデーションコードを自動生成
- **型安全性**: Kotlinの型システムを活用したバリデーション
- **パフォーマンス**: 実行時のリフレクション処理を排除
- **カスタマイズ可能**: 独自のバリデーションアノテーションを作成可能

## インストール

### build.gradle.kts

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

## 使用方法

## プロジェクト構造

```
ktmut/
├── compiler-plugin/          # コンパイラプラグインのメインモジュール
├── gradle-plugin/            # Gradleプラグイン
├── annotations/              # バリデーションアノテーション定義
├── runtime/                  # 実行時ライブラリ
├── sample/                   # サンプルプロジェクト
├── build.gradle.kts
└── settings.gradle.kts
```

## ライセンス

このプロジェクトはMITライセンスの下で公開されています。詳細は [LICENSE](LICENSE) ファイルをご覧ください。