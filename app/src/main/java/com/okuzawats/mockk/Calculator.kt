package com.okuzawats.mockk

class Calculator(
  private val integerProvider: IntegerProvider,
) {
  fun double(): Int = integerProvider.provide() * 2
}
