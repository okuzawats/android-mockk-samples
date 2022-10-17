package com.okuzawats.mockk

/**
 * 人間を表すクラス
 *
 * @property computer 人間の持つコンピュータ
 */
class Human(
  private val computer: Computer,
) {
  /**
   * [number]に対するComputerの答えがtrueなら"correct answer"、
   * falseなら"wrong answer"を返す。
   */
  fun ask(
    number: Int,
  ): String =
    if (computer.isAnswer(number)) {
      "correct answer"
    } else {
      "wrong answer"
    }
}
