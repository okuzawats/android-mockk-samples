package com.okuzawats.mockk

/**
 * 占いを行うClass
 *
 * @property dice 占いに必要なサイコロ
 */
class AsyncFortuneCookie(
  private val dice: AsyncDice,
) {
  /**
   * 占いを行い、結果を[Fortune]として返す
   *
   * @return [Fortune]
   * @throws [FortuneException]
   */
  suspend fun draw(): Fortune {
    // サイコロの出目
    val dots = dice.roll()

    // サイコロの出目が1ならGood、2から6ならBadを返す。
    // それ以外の出目が出た場合はFortuneExceptionをthrowする。
    return if (dots == 1) {
      Fortune.Good
    } else if(dots in 2..6) {
      Fortune.Bad
    } else {
      throw FortuneException("can not calculate fortune.")
    }
  }
}
