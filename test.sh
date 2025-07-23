#!/bin/bash

# ログファイルを初期化
LOG_FILE="latest.log"
> "$LOG_FILE"

# 関数: ログ出力とコンソール出力を同時に行う
log_and_echo() {
    echo "$1" | tee -a "$LOG_FILE"
}

# 関数: エラーハンドリング
handle_error() {
    local message="$1"
    echo "$message" | tee -a "$LOG_FILE" >&2
    exit 2
}

log_and_echo "=== KTMUT プロジェクトテスト ==="

# プロジェクトをクリーンビルド
log_and_echo "1. プロジェクトをクリーンビルド中..."
./gradlew clean build >> "$LOG_FILE" 2>&1

if [ $? -eq 0 ]; then
    log_and_echo "✓ ビルド成功"
else
    handle_error "✗ ビルド失敗"
fi

# サンプルプロジェクトを実行
log_and_echo ""
log_and_echo "2. サンプルプロジェクトを実行中..."
./gradlew :sample:run >> "$LOG_FILE" 2>&1

if [ $? -eq 0 ]; then
    log_and_echo "✓ サンプル実行成功"
else
    handle_error "✗ サンプル実行失敗"
fi

# テストを実行
log_and_echo ""
log_and_echo "3. テストを実行中..."
./gradlew test >> "$LOG_FILE" 2>&1

if [ $? -eq 0 ]; then
    log_and_echo "✓ テスト成功"
else
    handle_error "✗ テスト失敗"
fi

log_and_echo ""
log_and_echo "=== 全てのテストが完了しました！ ==="