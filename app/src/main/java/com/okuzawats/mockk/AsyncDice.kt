package com.okuzawats.mockk

/**
 * サイコロを表すinterface
 */
interface AsyncDice {
  /**
   * 1から6までの整数値をランダムに返す。
   */
  suspend fun roll(): Int
}
