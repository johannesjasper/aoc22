package day1

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.hasSize
import strikt.assertions.isEqualTo

internal class Day1Test {

    @Test
    internal fun `splitChunks finds groups of integers`() {
        val expected = listOf(listOf(1, 2), listOf(3))
        val actual: List<List<Int>> = splitChunks(listOf("1", "2", "\n", "3"))
        expectThat(actual).isEqualTo(expected)
    }

    @Test
    internal fun `findHighestSums finds the highest sum`() {
        expectThat(findHighestSums(listOf(listOf(3, 4), listOf(5)), candidates = 1)).hasSize(1).containsExactly(7)
    }

    @Test
    internal fun `findHighestSums finds the two highest sums`() {
        expectThat(day1(listOf("3", "4", "\n", "5"), 1)).isEqualTo(7)
    }

    @Test
    internal fun `day1 finds the highest sum from lines`() {
        expectThat(findHighestSums(listOf(listOf(3, 4), listOf(5)), candidates = 2)).hasSize(2).containsExactly(7, 5)
    }


}
