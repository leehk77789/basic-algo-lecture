import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine()
    val (n, k) = input?.split(" ")?.map { it.toInt() } ?: listOf(0, 0)
    val lists = LinkedList<Int>() //연결리스트 생성
    for (i in 1..n){
        lists.add(i) //1~n까지 추가
    }

    var result = "<"
    var count = 1
    while(lists.isNotEmpty()){
        val q = lists.poll() //하나씩 큐
        if(count < k){ //k보다 작을 경우
            count++
            lists.add(q) //다시 요소를 넣음
        }
        else{ //k번째 일 때
            result+= q //result에 요소 넣음
            if(lists.isEmpty()){ //연결리스트가 빈 경우
                break //그대로 출력
            }
            result += ", " //비지 않았으면 계속 해야하므로 , 붙여주기
            count = 1 //count 다시 초기화
        }

    }
    result += ">"
    println(result)
}