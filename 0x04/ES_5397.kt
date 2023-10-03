import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val answer = mutableListOf<String>()

    repeat(num) {
        val lists = LinkedList<String>()
        val str = readLine()
        val count  = lists.listIterator(lists.size)

        str.forEach {
            if (it.isLetterOrDigit()) {
                count.add(it.toString())
            }
            else {

                when (it.toString()) {
                    "<" -> {
                        if (count.hasPrevious()) {
                            count.previous()
                        }
                    }

                    ">" -> {
                        if (count.hasNext()) {
                            count.next()
                        }
                    }

                    "-" -> {
                        if (count.hasPrevious()) {
                            count.previous()
                            count.remove()
                        }
                    }

                }
            }

        }
        answer.add(lists.joinToString().replace(", ", ""))
    }

    for(i in answer){
        println(i)
    }

}