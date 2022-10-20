package com.okuzawats.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test

class ValuesTest {
  lateinit var values: Values

  @Before
  fun setUp() {
    values = Values(
      providerFactory = mockk<ProviderFactory> {
        every {
          intProvider()
        } returns mockk<IntProvider> {
          every {
            get()
          } returns 42
        }

        every {
          stringProvider()
        } returns mockk<StringProvider> {
          every {
            get()
          } returns "Hello World"
        }
      }
    )
  }

  @After
  fun tearDown() {
  }

  @Test
  fun test_intValue() {
    val actual = values.intValue()
    val expected = 42

    assertThat(actual)
      .isEqualTo(expected)
  }

  @Test
  fun test_stringValue() {
    val actual = values.stringValue()
    val expected = "Hello World"

    assertThat(actual)
      .isEqualTo(expected)

  }
}
