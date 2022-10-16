package com.okuzawats.mockk

/**
 * サイコロを表すinterface
 */
interface Dice {
  /**
   * 1から6までの整数値をランダムに返す。
   */
  fun roll(): Int
}
