package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test

class SignalTest {

  @Before
  fun setUp() {
    mockkObject(SignalGenerator)
  }

  @After
  fun tearDown() {
    unmockkAll()
  }

  @Test
  fun test_green() {
    every {
      SignalGenerator.randomColor()
    } returns "Green"

    val signal = Signal()

    assertThat(signal.currentColor)
      .isEqualTo("Green")
  }

  @Test
  fun test_yellow() {
    every {
      SignalGenerator.randomColor()
    } returns "Yellow"

    val signal = Signal()

    assertThat(signal.currentColor)
      .isEqualTo("Yellow")
  }

  @Test
  fun test_red() {
    every {
      SignalGenerator.randomColor()
    } returns "Red"

    val signal = Signal()

    assertThat(signal.currentColor)
      .isEqualTo("Red")
  }
}