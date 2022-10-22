package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify

import org.junit.After
import org.junit.Before
import org.junit.Test

class FortuneCookieTest {
  @MockK
  lateinit var dice: Dice

  lateinit var fortuneCookie: FortuneCookie

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    fortuneCookie = FortuneCookie(dice)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun draw_returnsGoodIfDiceRollIsOne() {
    every { dice.roll() } returns 1

    val actual = fortuneCookie.draw()
    val expected = Fortune.Good

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_returnsBadIfDiceRollIsTwo() {
    every { dice.roll() } returns 2

    val actual = fortuneCookie.draw()
    val expected = Fortune.Bad

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_returnsBadIfDiceRollIsSix() {
    every { dice.roll() } returns 6

    val actual = fortuneCookie.draw()
    val expected = Fortune.Bad

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_callsRoll() {
    every { dice.roll() } returns 1

    fortuneCookie.draw()

    verify {
      dice.roll()
    }
  }

  @Test
  fun draw_callsRoll_exactlyOnce() {
    every { dice.roll() } returns 1

    fortuneCookie.draw()

    verify(exactly = 1) {
      dice.roll()
    }
  }
}