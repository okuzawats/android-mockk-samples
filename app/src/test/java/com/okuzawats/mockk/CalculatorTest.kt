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
  lateinit var booleanProvider: BooleanProvider

  lateinit var calculator: Calculator

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    calculator = Calculator(booleanProvider)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun test_negative_returnsFalse_ifTrueProvided() {
    every { booleanProvider.provide() } returns true
    assertThat(calculator.negative()).isFalse()
  }

  @Test
  fun test_negative_returnsTrue_ifFalseProvided() {
    every { booleanProvider.provide() } returns false
    assertThat(calculator.negative()).isTrue()
  }
}