package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AsyncFortuneCookieTest {
  @MockK
  lateinit var dice: AsyncDice

  lateinit var fortuneCookie: AsyncFortuneCookie

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    fortuneCookie = AsyncFortuneCookie(dice)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun draw_returnsGoodIfDiceRollIsOne() = runTest {
    coEvery { dice.roll() } returns 1

    val actual = fortuneCookie.draw()
    val expected = Fortune.Good

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_returnsBadIfDiceRollIsTwo() = runTest {
    coEvery { dice.roll() } returns 2

    val actual = fortuneCookie.draw()
    val expected = Fortune.Bad

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_returnsBadIfDiceRollIsSix() = runTest {
    coEvery { dice.roll() } returns 6

    val actual = fortuneCookie.draw()
    val expected = Fortune.Bad

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun draw_callsRoll() = runTest {
    coEvery { dice.roll() } returns 1

    fortuneCookie.draw()

    coVerify {
      dice.roll()
    }
  }
}