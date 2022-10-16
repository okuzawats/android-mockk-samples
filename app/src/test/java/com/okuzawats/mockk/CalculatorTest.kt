package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK

import org.junit.After
import org.junit.Before
import org.junit.Test

class CalculatorTest {
  @MockK
  lateinit var integerProvider: IntegerProvider

  lateinit var calculator: Calculator

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    calculator = Calculator(integerProvider)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun doubleReturnsDoubledValueOfProvided() {
    every {
      integerProvider.provide()
    } returns 42

    val actual = calculator.double()
    val expected = 84

    assertThat(actual)
      .isEqualTo(expected)
  }
}