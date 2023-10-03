import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val str = readLine()
    val list = LinkedList<String>()
    str.forEach {
        list.add(it.toString())
    }
    val count = list.listIterator(list.size)

    val n = readLine().toInt()
    repeat(n){
        val m = readLine()

        when(m){
            "L" -> {
                if (count.hasPrevious()){ // 커서 왼쪽에 데이터가 있으면
                    count.previous()      // 그걸 리턴하고 커서를 반환할 데이터의 왼쪽으로 움직인다.
                }
            }
            "D" -> {
                if (count.hasNext()){ // 커서 오른쪽에 데이터가 있으면
                    count.next()      // 그걸 리턴하고 커서를 반환할 데이터의 오른쪽으로 움직인다.
                }
            }
            "B" -> {
                if (count.hasPrevious()){
                    count.previous()
                    count.remove()   // 가장 최근에 리턴한 데이터를 삭제한다
                }
            }
            else -> {
                count.add(m[2].toString()) // 커서 위치에 데이터 추가
            }
        }
    }

    print(list.joinToString().replace(", ", ""))
}