import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().toInt()
    val lists = Stack<Int>()

    repeat(input){
        val cmd = readLine().toInt()
        when(cmd){
            0 -> {
                lists.pop()
            }
            else -> {
                lists.push(cmd)
            }
        }
    }

    println(lists.sum())

}