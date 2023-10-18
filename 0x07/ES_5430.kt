import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val case = readLine().toInt()
    val sb = StringBuffer()

    repeat(case) {
        val p = readLine().toString()
        val n = readLine().toInt()
        val input = readLine().trim()
        val arr = ArrayDeque(input.substring(1..<input.length - 1).split(","))

        var error = false
        var reverse = false

        p.forEach {
            when (it) {
                'R' -> {
                    reverse = !reverse
                }

                'D' -> {
                    if (arr.isEmpty() || n == 0 ) {
                        error = true
                    }
                    else{
                        if(reverse) arr.removeLast() else arr.removeFirst()
                    }
                }
            }

        }

        if (error) {
            sb.append("error\n")
        }
        else {
            if (reverse) arr.reverse()
            sb.append(arr.toString().replace(" ","") + "\n")
        }
    }

    println(sb)
}