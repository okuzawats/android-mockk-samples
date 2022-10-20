package com.okuzawats.mockk

/**
 * 値を返す関数の集まり
 */
class Values(
  private val providerFactory: ProviderFactory,
) {
  /**
   * Int型の値を返す
   */
  fun intValue(): Int =
    providerFactory
      .intProvider()
      .get()

  /**
   * String型の値を返す
   */
  fun stringValue(): String =
    providerFactory
      .stringProvider()
      .get()
}
