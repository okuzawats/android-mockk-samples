package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Ignore
import org.junit.Test

class IntProviderTest {
  @Test
  @Ignore("this test fails")
  fun test_not_relaxed() {
    val intProvider: IntProvider = mockk()

    assertThat(intProvider.get())
      .isLessThan(Int.MAX_VALUE)
  }

  @Test
  fun test_relaxed() {
    val intProvider: IntProvider = mockk(relaxed = true)

    assertThat(intProvider.get())
      .isLessThan(Int.MAX_VALUE)
  }
}