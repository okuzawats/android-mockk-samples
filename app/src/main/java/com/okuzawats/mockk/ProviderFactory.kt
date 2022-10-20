package com.okuzawats.mockk

interface ProviderFactory {
  fun intProvider(): IntProvider
  fun stringProvider(): StringProvider
}
