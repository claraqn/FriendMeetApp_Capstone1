package com.example.dust

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.time.LocalDate


val date: LocalDate = LocalDate.now()




fun test(a: String, b: Int): String {
    var fDust =""
    if(a=="서울"){
        val address="https://www.airkorea.or.kr/web/sidoAirInfo/sidoAirInfoDay01?itemCode=10007&ymd=2020-05-08%2023&areaCode=02"
        val document = Jsoup.connect(address).get()
        val dust= document.select("div#board").select("tr.al1")[b.plus(2)].select("td")
        fDust= "$dust"
    }

    return fDust

}


