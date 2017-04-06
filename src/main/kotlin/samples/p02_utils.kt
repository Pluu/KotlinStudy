package samples

import kotlin.system.measureTimeMillis

/**
 * kotlin.text
 * Created by pluu on 2017-04-06.
 */
fun main(args: Array<String>) {

    println("===Repeat==========")
    sample_repeat()

    println("===Standard==========")
    sample_standard()
}

private fun sample_repeat() {
    // # repeat(Int, (Int) -> Unit)
    repeat(2) {
        println("$it: Kotlin Pluu")
    }
}

private fun sample_standard()  {
    // 처리 시간을 밀리초로 반환
    // measureNanoTime 도 있음
    // # measureTimeMillis(() -> Unit) : Long
    val elapsed = measureTimeMillis {
        var counter = 0
        repeat(100000000) {
            counter++
        }
        println("Count: $counter")
    }
    println("ElapsedTime: $elapsed milliseconds")
}
