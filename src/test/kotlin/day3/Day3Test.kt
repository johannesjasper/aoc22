package day3

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Day3Test {

    @ParameterizedTest
    @CsvSource(
        "vJrwpWtwJgWrhcsFMMfFFhFp, p",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL, L",
        "PmmdzqPrVvPwwTWBwg, P",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn, v",
        "ttgJtRGJQctTZtZT, t",
        "CrZsJsPPZsGzwwsLwLmpwMDw, s",
    )
    internal fun `it finds the item in both compartments`(input: String, expected: Char) {
        expectThat(findSharedItem(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "p, 16",
        "L, 38",
        "P, 42",
        "v, 22",
        "t, 20",
        "s, 19",
    )
    internal fun `it maps the item to its priority`(item: Char, priority: Int) {
        expectThat(item.toPriority()).isEqualTo(priority)
    }

    @Test
    internal fun `it computes the sum of prioities of shared items`() {
        expectThat(
            day1_1(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg",
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw",
                )
            )
        ).isEqualTo(157)
    }

    @Test
    internal fun `it finds the badge in a group of elves`() {
        expectThat(
            findBadge(
                listOf(
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw",
                )
            )
        ).isEqualTo('Z')
    }

    @Test
    internal fun `it finds the badge in a group of elves #2`() {
        expectThat(
            findBadge(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"
                )
            )
        ).isEqualTo('r')
    }

    @Test
    internal fun `it computes the sum of prioities of badges`() {
        expectThat(
            day1_2(
                listOf(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg",
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw",
                )
            )
        ).isEqualTo(70)
    }
}
