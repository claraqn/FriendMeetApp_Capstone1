package com.example.dust;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    String[] seoul={"강남구","강동구","강북구","강서구","관악구",
       "광진구","구로구","금천구","노원구","도봉구","동대문구","동작구",
        "마포구","서대문구","서초구","성동구","성북구","송파구","양천구",
        "영등포구","용산구","은평구","종로구","중구","중랑구"};
    String[] busan={"강서구/녹산동","강서구/대저동","금정구/부곡동","금정구/청룡동",
        "기장군/기장읍","기장군/용수리","남구/대연동","동구/수정동","동래구/명장동",
        "부산진구/개금동","부산진구/전포동","북구/덕천동","북구/화명동","사상구/덕포동","사상구/학장동",
            "사하구/당리동","사하구/장림동","서구/대신동","수영구/광안동","연제구/연산동",
        "영도구/청학동","영도구/태종대","중구/광복동","해운대구/재송동","해운대구/좌동"};
    String[] daegu={"남구/대명동","달서구/본동","달서구/진천동","달서구/호림동",
            "달성군/다사읍","달성군/유가읍","동구/서호동", "동구/신암동",
            "북구/노원동","북구/태전동","서구/이현동","수성구/만촌동","수성구/시지동",
            "수성구/지산동","중구/수창동"};
    String[] incheon={"강화군/길상","강화군/송해","계양구/계산","남동구/고잔",
            "남동구/구월동","남동구/논현","동구/송림","미추홀구/숭의","부평구/부평",
            "부평구/삼산","서구/검단","서구/석남","서구/연희","서구/원당","서구/청라",
            "연수구/동춘","연수구/송도","옹진군/영흥","중구/신흥","중구/운서"};
    String[] ghaungju={"광산구/송정1동","광산구/오선동","광산구/평동","남구/노대동",
            "남구/주월동","동구/서석동","북구/건국동","북구/두암동","서구/농성동"};
    String[] daejun={"대덕구/문평동","대덕구/읍내동","동구/대성동","동구/성남동1",
            "서구/둔산동","서구/정림동","유성구/구성동","유성구/노은동","유성구/상대동",
            "중구/문창동"};
    String[] woolsan={"남구/무거동","남구/부곡동","남구/삼산동","남구/신정동",
            "남구/야음동","남구/여천동","동구/대송동","동구/전하동","북구/농소동",
            "북구/효문동","울주군/덕신리","울주군/삼남면","울주군/상남리","울주군/웅촌면",
            "울주군/화산리","중구/성남동","중구/약사동"};
    String[] gyunggi={"가평","설악면","식사동","신원동","주엽동","행신동","과천동",
            "별양동","소하동","철산동","경안동","오포읍","교문동","동구동","당동",
            "산본동","고촌읍","사우동","월곶면","한강신도시","금곡동","별내동",
            "오남읍","화도읍","보산동","내동","소사본동","오정동","중2동","단대동",
            "복정동","상대원동","수내동","운중동","정자동","고색동","광교동","신풍동",
            "영통동","인계동","천천동","호매실동","대야동","목감동","시화산단","장현동",
            "정왕동","고잔동","대부동","본오동","부곡동1","원곡동","원시동","호수동","공도읍",
            "봉산동","죽산면","부림동","안양2동","안양6동","호계동","고읍","백석읍",
            "양평읍","용문면","대신면","중앙동","연천","오산동","기흥","김량장동","모현읍",
            "백암면","수지","이동읍","고천동","부곡3","의정부1동","의정부동","부발읍",
            "장호원읍","창전동","금촌동","운정","파주읍","비전동","송북동","안중","청북읍",
            "평택항","선단동","일동면","신장동","남양읍","동탄","새솔동","우정읍","청계동",
            "향남읍"};
    String[] gangwon={"강릉시/옥천동","고성군/상리","동해시/천곡동","삼척시/남양동1",
            "속초시","양구군/양구읍","양양군","영월군/영월읍","원주시/문막읍","원주시/반곡동",
            "원주시/중앙동","인제군","정선군/정선읍","철원군/갈말읍","춘천시/석사동",
            "춘천시/신사우동","춘천시/중앙로","태백시","평창군/평창읍","홍천군/홍천읍",
            "화천군","횡성군"};
    String[] choongbuk={"괴산군/감물면","괴산군/괴산읍","단양군/단성면","단양군/매포읍",
            "보은군/보은읍","영동군/영동읍","옥천군/옥천읍","음성군/소이면","음성군/음성읍",
            "제천시/장락동","증평군/증평읍","진천군/덕산읍","진천군/진천읍","청주시/가덕면",
            "청주시/사천동","청주시/산남동","청주시/송정동","청주시/오송읍","청주시/용담동",
            "청주시/용암동","충주시/살미면","충주시/중앙탑면","충주시/칠금동","충주시/호암동"};
    String[] choongnam={"계룡시/엄사면","공주시/공주","공주시/탄천면","금산군/금산읍",
            "논산시/논산","당진시/당진시청사","당진시/송산면","보령시/대천2동","보령시/주교면",
            "부여군/부여읍","서산시/대산리","서산시/독곶리","서산시/동문동","서산시/성연면",
            "서천군/서면","서천군/서천읍","서천군/장항읍","아산시/도고면","아산시/둔포면",
            "아산시/모종동","아산시/배방읍","아산시/인주면","아산시/예산군","천안시/백석동",
            "천안시/성거읍","천안시/성황동","천안시/신방동","청양군/청양읍","태안군/이원면",
            "태안군/태안읍","홍성군/내포","홍성군/홍성읍"};
    String[] junbuk={"고창군/고창읍","고창군/심원면","군산시/개정동","군산시/비응도동",
            "군산시/소룡동","군산시/신풍동","군산시/옥산면","김제시/요촌동","남원시/죽항동",
            "무주군/무주읍","부안군/부안읍","순창군/순창읍","완주군/고산면","완주군/봉동읍",
            "익산시/남중동","익산시/모현동","익산시/삼기면","익산시/용동면","익산시/팔봉동",
            "익산시/함열읍","임실군/임실읍","장수군/장수읍","전주시/노송동","전주시/삼천동",
            "전주시/송천동","전주시/팔복동","전주시/혁신동","정읍시/신태인","정읍시/연지동",
            "진안군/진안읍"};
    String[] junnam={"강진군]강진읍","고흥군]고흥읍","곡성군]곡성읍","광양시]광양읍","광양시]중동",
            "광양시]진상면"," 광양시]태인동","구례군]구례읍","나주시]빛가람동","담양군]담양읍",
            "목포시]부흥동","목포시]용당동","무안군]무안읍","보성군]벌교읍","순천시]순천만",
            "순천시]신대","순천시]연향동","순천시]장천동","순천시]호두리","신안군]신안군",
            "여수시]덕충동","여수시]문수동","여수시]삼일동","여수시]서강동","여수시]여천동",
            "여수시]월내동","여수시]율촌면","여수시]화양면","영광군]영광읍","영암군]나불리",
            "완도군]신지면","장성군]장성읍","장흥군]장흥읍","진도군]진도읍","함평군]함평읍",
            "해남군]해남읍","화순군]화순읍"};
    String[] sejong={"부강면","신흥동","아름동","한솔동"};
    String[] gyungbuk={"경산시]중방동","경주시]보덕동","경주시]성건동","경주시]안강읍",
            "경주시]외동읍","고령군]대가야읍","구미시]4공단","구미시]공단동","구미시]원평동",
            "구미시]형곡동","군위군]군위읍","김천시]대광동","김천시]문당동","김천시]율곡동",
            "문경시]문경시","봉화군]석포면","상주시]상주시","성주군]성주군","안동시]명륜동",
            "영덕군]영덕읍","영양군]영양군","영주시]가흥동","영천시]영천시","예천군]예천군",
            "울릉군]울릉읍","울진군]울진군","의성군]의성읍","청도군]화양읍","청송군]청송읍",
            "칠곡군]칠곡군","포항시]3공단","포항시]대도동","포항시]대송면","포항시]송도동",
            "포항시]오천읍","포항시]장량동","포항시]장흥동","포항시]청림동"};
    String[] gyungnam={"거제시]아주동","거창군]거창읍","고성군]고성읍","김해시]동상동","김해시]삼방동",
            "김해시]장유동","김해시]진영읍","남해군]남해읍","밀양시]내일동","사천시]사천읍",
            "산청군]산청읍","양산시]북부동","양산시]삼호동","의령군]의령읍","진주시]대안동",
            "진주시]상대동","진주시]상봉동","창녕군]창녕읍","창원시]경화동","창원시]명서동",
            "창원시]봉암동","창원시]사파동","창원시]성주동","창원시]용지동","창원시]웅남동",
            "창원시]월영동","창원시]회원동","통영시]무전동","하동군]하동읍","함안군]가야읍",
            "함양군]함양읍","합천군]합천읍"};
    String[] jeju={"서귀포시/남원읍","서귀포시/대정읍","서귀포시/동흥동",
            "서귀포시/성산읍","제주시/연동","제주시/이도동"};
    ListView lvList2;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_main);

        // 보내온 Intent를 얻는다
        Intent intent = getIntent();
        String local=String.valueOf(intent.getStringExtra("local"));
        //가져온 정보(name:local)에는 strText(클릭한 부분의 text=지역명) 있음
        //지역명 비교하고 그에 따른 String 배열 생성
        if(local.equals("서울")) {

            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, seoul);
            lvList2.setAdapter(arrayAdapter);

        }
        if(local.equals("부산")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, busan);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("대구")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, daegu);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("인천")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, incheon);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("광주")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, ghaungju);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("대전")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, daejun);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("울산")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, woolsan);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("경기")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, gyunggi);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("강원")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, gangwon);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("충북")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, choongbuk);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("충남")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, choongnam);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("전북")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, junbuk);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("전남")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, junnam);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("세종")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, sejong);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("경북")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, gyungbuk);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("경남")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, gyungnam);
            lvList2.setAdapter(arrayAdapter);
        }
        if(local.equals("제주")){
            lvList2 = findViewById(R.id.lvList2);
            arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, jeju);
            lvList2.setAdapter(arrayAdapter);
        }




        lvList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 코드 계속 ...

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                //클릭한 부분의 인덱스값을 저장
                int index = position;


                //String index = (String) parent.get(position) ;
                Intent intent = getIntent(); // 보내온 Intent를 얻는다
                String local=String.valueOf(intent.getStringExtra("local"));

                //intent통해 FinalActivity.class에 인덱스값과 지역명(areaCode위한 것) 보냄
                Intent intent2 = new Intent(getApplicationContext(), FinalActivity.class);
                intent2.putExtra("index",index);
                intent2.putExtra("local",local);
                /*intent.putExtra("title", al.get(position).title);*/
                startActivity(intent2);
            }
        }) ;


    }



}
