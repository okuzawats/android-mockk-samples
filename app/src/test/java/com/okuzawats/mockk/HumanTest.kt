package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Test

class HumanTest {
  @MockK
  lateinit var computer: Computer

  lateinit var human: Human

  @Before
  fun setUp() {
    MockKAnnotations.init(this)

    // Computer#isAnswerの引数が42の時はtrue、それ以外の時はfalseを返す
    every { computer.isAnswer(any()) } returns false
    every { computer.isAnswer(42) } returns true

    human = Human(computer)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun ask_returnsWrongAnswerAskedWith0() {
    assertThat(human.ask(0))
      .isEqualTo("wrong answer")
  }

  @Test
  fun ask_returnsWrongAnswerAskedWith100() {
    assertThat(human.ask(100))
      .isEqualTo("wrong answer")
  }

  @Test
  fun ask_returnsCorrectAnswerAskedWith42() {
    assertThat(human.ask(42))
      .isEqualTo("correct answer")
  }
}
