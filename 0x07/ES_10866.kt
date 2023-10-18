import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().toInt()
    val deque =  ArrayDeque<Int>()

    repeat(input){
        val m = readLine().split(" ")

        when(m[0]){
            "push_back" -> {
                deque.addLast(m[1].toInt())
            }
            "push_front" -> {
                deque.addFirst(m[1].toInt())
            }
            "pop_front" -> {
                if(deque.isEmpty()){
                    println(-1)
                }
                else{
                    println(deque.removeFirst())
                }
            }
            "pop_back" -> {
                if(deque.isEmpty()){
                    println(-1)
                }
                else{
                    println(deque.removeLast())
                }
            }
            "size" -> {
                println(deque.size)
            }
            "empty" -> {
                if(deque.isEmpty()){
                    println(1)
                }
                else{
                    println(0)
                }
            }
            "front" -> {
                if(deque.isEmpty()){
                    println(-1)
                }
                else{
                    println(deque.first())
                }
            }
            "back" -> {
                if(deque.isEmpty()){
                    println(-1)
                }
                else{
                    println(deque.last())
                }
            }
        }
    }
}