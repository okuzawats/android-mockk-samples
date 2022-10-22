package com.okuzawats.mockk

/**
 * 信号機
 */
class Signal {
  /**
   * 現在の信号の色
   */
  val currentColor: String =
    SignalGenerator.randomColor()
}
