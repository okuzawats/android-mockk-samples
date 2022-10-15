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
  fun test_double_returns_doubled_value_of_provided() {
    every { integerProvider.provide() } returns 42
    assertThat(calculator.double()).isEqualTo(84)
  }
}