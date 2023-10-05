import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val cmd = readLine().toInt()
    val st = Stack<Int>()
    val arr = IntArray(cmd)

    for(i in 0..cmd-1) {
        arr[i]=readLine().toInt()
    }

    var idx = 0
    val result = ArrayList<Char>()
    for(i in 1..cmd){
        st.push(i)
        result.add('+')
        while(!st.empty() && st.peek()==arr[idx]){
            st.pop()
            result.add('-')
            idx++
        }
    }

    if(!st.empty()) println("NO")
    else for(z in result) println(z)


}