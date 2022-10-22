package com.okuzawats.mockk

import kotlin.random.Random

/**
 * 信号機の色をランダムに生成する
 */
object SignalGenerator {
  /**
   * 信号機の色をランダムに生成して返す
   */
  fun randomColor(): String {
    // 0 - 2 の乱数を返す。
    val int = Random.nextInt(from = 0, until = 3)

    return when (int) {
      0 -> "Green"
      1 -> "Yellow"
      2 -> "Red"
      else -> throw Throwable()
    }
  }
}
