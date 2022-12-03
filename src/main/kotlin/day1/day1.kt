package day1

import java.io.File

fun splitChunks(lines: List<String>): List<List<Int>> = sequence {
    var currentChunk = mutableListOf<Int>()
    for (line in lines) {
        if (line.isBlank()) {
            yield(currentChunk)
            currentChunk = mutableListOf<Int>()
        } else {
            currentChunk.add(line.toInt())
        }
    }
    yield(currentChunk)
}.toList()

fun findHighestSums(chunks: List<List<Int>>, candidates: Int): List<Int> =
    chunks.map { it.sum() }.sortedDescending().take(candidates)

fun day1(lines: List<String>, candidates: Int): Int = findHighestSums(splitChunks(lines), candidates).sum()


fun main() {
    val lines = File("src/main/kotlin/day1/input.txt").readLines().toList()
    println("Day 1.1: ${day1(lines, 1)}")
    println("Day 1.2: ${day1(lines, 3)}")
}
