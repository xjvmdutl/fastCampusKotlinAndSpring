package assignment.ch03

data class Report(
    val reports: MutableMap<String, MutableSet<String>>,
    val reportedsCount: MutableMap<String, Int>
) {
}

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val result = reportIt(report)
    return getReportResult(id_list, k, result)
}

private fun reportIt(
    report: Array<String>,
): Report {
    val result = Report(mutableMapOf(), mutableMapOf())
    report.distinct().forEach {
        val (reporter, reported) = it.split(" ")
        result.reports[reporter] = result.reports.getOrDefault(reporter, mutableSetOf())
        result.reports[reporter]!!.add(reported)
        result.reportedsCount[reported] = result.reportedsCount.getOrDefault(reported, 0) + 1
    }
    return result
}

private fun getReportResult(
    idList: Array<String>,
    k: Int,
    report: Report,
): IntArray {
    val answer = IntArray(idList.size)
    idList.forEachIndexed { index, id ->
        answer[index] = getReporterToResult(report.reports[id], report.reportedsCount, k)
    }
    return answer
}

private fun getReporterToResult(
    reports: MutableSet<String>?,
    reportedsCount: MutableMap<String, Int>,
    k: Int
): Int {
    return if (reports != null) {
        var count = 0
        for (report in reports) {
            if (reportedsCount.getOrDefault(report, 0) >= k)
                count++
        }
        count
    } else {
        0
    }
}


fun main() {
    solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
        2
    ).forEach { println(it) }
    println("=======")
    solution(
        arrayOf("con", "ryan"),
        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        3
    ).forEach { println(it) }
}