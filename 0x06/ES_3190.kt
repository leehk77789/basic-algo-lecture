import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var snake: Deque<Pair<Int, Int>>
private lateinit var dirQueue: Queue<Pair<Int, String>>


private var count = 0
private var dir = 0

private val nx = intArrayOf(0, 1, 0, -1)
private val ny = intArrayOf(1, 0, -1, 0)

fun main() {

    val n = readln().toInt()
    val k = readln().toInt()

    arr = Array(n) { IntArray(n) }
    snake = LinkedList() //(x,y) 위치 정보
    dirQueue = LinkedList() //방향 전환에 관한 (x초, "D" 또는 "L")

    repeat(k){
        val (a,b) = readln().split(' ').map { it.toInt() }
        arr[a - 1][b - 1] = 1
    }

    val l = readln().toInt()

    repeat(l) {
        val (x,c) = readln().split(' ').map { it }
        dirQueue.add(Pair(x.toInt(), c))
    }

    //출발지점
    snake.add(Pair(0, 0))

    while (true) {
        count++
        val headX = snake.peekFirst().first + nx[dir]
        val headY = snake.peekFirst().second + ny[dir]

        // 벽에 부딪혔을 때
        if (headX < 0 || headX >= n || headY < 0 || headY >= n) {
            break
        }

        // 몸통과 마주쳤을 때
        if (snake.contains(Pair(headX, headY))) {
            break
        }

        // 사과를 먹었을때
        if (arr[headX][headY] == 1) {
            arr[headX][headY] = 0
            snake.offerFirst(Pair(headX, headY))
        } else { // 사과 없을 때
            snake.offerFirst(Pair(headX, headY))
            snake.pollLast()
        }

        // 방향 전환
        if (dirQueue.isNotEmpty()) {
            if (dirQueue.peek().first == count) {
                when(dirQueue.poll().second){
                    "D" ->{
                        dir = (dir + 1) % 4
                    }
                    "L" ->{
                        dir = (dir - 1) % 4
                    }
                }
            }
        }
    }

    println(count)

}