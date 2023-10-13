import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().toInt()

    val q : Deque<Int> = java.util.ArrayDeque()

    for( i in 1..input){
        q.add(i)
    }

    while(q.size > 1){
        q.pollFirst()
        q.offerLast(q.pollFirst())
    }

    println(q.poll())

}