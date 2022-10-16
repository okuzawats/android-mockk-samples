package com.okuzawats.mockk

/**
 * 占いを行うClass
 *
 * @property dice 占いに必要なサイコロ
 */
class FortuneCookie(
  private val dice: Dice,
) {
  /**
   * 占いを行い、結果を[Fortune]として返す
   *
   * @return [Fortune]
   * @throws [FortuneException]
   */
  fun draw(): Fortune {
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

/**
 * 運勢を占うことができなかった場合の例外
 *
 * @param message エラーメッセージ
 */
class FortuneException(
  override val message: String,
): Throwable(message)
