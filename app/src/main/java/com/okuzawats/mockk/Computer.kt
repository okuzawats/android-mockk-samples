package com.okuzawats.mockk

/**
 * コンピュータの動作を表すinterface
 */
interface Computer {
  /**
   * [int]が答えと等しいときにtrueを返す
   */
  fun isAnswer(int: Int): Boolean
}
