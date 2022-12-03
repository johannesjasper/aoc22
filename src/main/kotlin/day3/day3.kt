package day3

import java.io.File

const val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun findSharedItem(items: String): Char {
    val firstCompartment = items.subSequence(0, items.length / 2)
    val secondCompartment = items.subSequence(items.length / 2, items.length)
    return firstCompartment.toSet().intersect(secondCompartment.toSet()).first()
}

fun Char.toPriority(): Int {
    return alphabet.indexOf(this) + 1
}

fun findBadge(rucksacks: List<String>): Char =
    rucksacks.map { it.toSet() }.reduce { acc, chars -> chars.toSet().intersect(acc) }.first()


fun day1_1(rucksacks: List<String>): Int = rucksacks.map { findSharedItem(it).toPriority() }.sum()
fun day1_2(rucksacks: List<String>): Int = rucksacks.chunked(3).map { findBadge(it).toPriority() }.sum()

fun main() {
    val lines = File("src/main/kotlin/day3/input.txt").readLines().toList()
    println("Day 1.1: ${day1_1(lines)}")
    println("Day 1.2: ${day1_2(lines)}")
}
