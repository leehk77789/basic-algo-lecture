import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it }

    val queue = LinkedList<Int>()

    for (i in 1..N.toInt()) {
        queue.add(i)
    }
    val target = readLine().split(" ")

    var rotations = 0
    for (i in 0 until M.toInt()) {
        target[i]

        while (true) {
            val index = queue.indexOf(target[i].toInt())

            if (index == 0) {
                queue.poll()
                break
            } else {
                val left = index
                val right = queue.size - index
                if (left <= right) {
                    // 왼쪽으로 회전
                    queue.addLast(queue.pollFirst())
                    rotations++
                } else {
                    // 오른쪽으로 회전
                    queue.addFirst(queue.pollLast())
                    rotations++
                }
            }
        }
    }

    println(rotations)
}
