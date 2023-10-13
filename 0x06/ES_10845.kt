import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.Deque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().toInt()
    val q :Deque<Int> = ArrayDeque()

    repeat(input){
        val todo = readLine().split(" ")

        when(todo[0]){
            "push" ->{
                q.add(todo[1].toInt())
            }
            "front" ->{
                if(q.isEmpty()){
                    println(-1)
                }
                else{
                    println(q.peekFirst())
                }
            }
            "back" ->{
                if(q.isEmpty()){
                    println(-1)
                }
                else{
                    println(q.peekLast())
                }
            }
            "size" ->{
                println(q.size)
            }
            "pop" ->{
                if(q.isEmpty()){
                    println(-1)
                }
                else{
                    println(q.first)
                    q.pollFirst()
                }
            }
            "empty" ->{
                if(q.isEmpty()){
                    println(1)
                }
                else{
                    println(0)
                }
            }
        }
    }
}