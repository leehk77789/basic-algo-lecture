import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.Deque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().toInt()
    val q :Deque<Int> = ArrayDeque()
    val sb = StringBuffer()

    repeat(input){
        val todo = readLine().split(" ")

        when(todo[0]){
            "push" ->{
                q.add(todo[1].toInt())
            }
            "front" ->{
                if(q.isEmpty()){
                    sb.append("-1\n")
                }
                else{
                    sb.append("${q.peekFirst()}\n")
                }
            }
            "back" ->{
                if(q.isEmpty()){
                    sb.append("-1\n")

                }
                else{
                    sb.append("${q.peekLast()}\n")
                }
            }
            "size" ->{
                sb.append("${q.size}\n")
            }
            "pop" ->{
                if(q.isEmpty()){
                    sb.append("-1\n")

                }
                else{
                    sb.append("${q.first}\n")
                    q.pollFirst()
                }
            }
            "empty" ->{
                if(q.isEmpty()){
                    sb.append("1\n")

                }
                else{
                    sb.append("0\n")

                }
            }
        }
    }

    println(sb)
}