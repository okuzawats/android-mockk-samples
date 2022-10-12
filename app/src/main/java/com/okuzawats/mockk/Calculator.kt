package com.okuzawats.mockk

class Calculator(
  private val booleanProvider: BooleanProvider,
) {
  fun negative(): Boolean = booleanProvider.provide().not()
}
