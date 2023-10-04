import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toInt()

    val lists = Stack<String>()

    repeat(input) {
        val m = br.readLine().replace(" ", "")

        if (m.contains("push")) {
            val pushInt = m.removeRange(0..3)
            lists.push(pushInt)
        } else if (m == "pop") {
            if (lists.isNotEmpty()) {
                println(lists.peek())
                lists.pop()
            } else {
                println(-1)
            }
        } else if (m == "size") {
            println(lists.size)
        } else if (m == "empty") {
            if (lists.isEmpty()) {
                println(1)
            } else {
                println(0)
            }
        } else{
            if (lists.isNotEmpty()) {
                val topElement = lists.peek()
                println(topElement)
            } else {
                println(-1)
            }
        }
    }
}
