package com.example.dust;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalActivity extends AppCompatActivity {
    //텍스트뷰, 버튼, 이미지뷰 변수 생성
    TextView tvFinal;
    Button btn;
    private ImageView imageView01;
    //Intent로 받아온 내용 index,local에 저장
    Intent intent2;
    int index;
    String local;
    //dust=미세먼지 농도 긁어온 것 저장
    String dust;
    //밑에 jsoup 크롤링하는 부분에 필요한 변수 선언
    String contents;
    Document doc=null;
    String url;
    //url에 필요한 (시간 가져오는 부분),(areaCode)
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    long now = System.currentTimeMillis();
    Date time = new Date(now);
    String fTime = format1.format(time);



    String areaCode;
    //fMent=final_main.xml에 출력될 text 저장
    String ment;
    String fMent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_main);

        tvFinal=findViewById(R.id.tvFinal);
        btn=findViewById(R.id.btn);
        imageView01 = (ImageView)findViewById(R.id.imageView01);

        intent2 = getIntent(); // 보내온 Intent를 얻는다
        index = intent2.getExtras().getInt("index");
        local = intent2.getExtras().getString("local");

        //intent로 받아온 local에 지역명 저장되어 있음->지역에 따라 areaCode지정해서 url에 넣어줌
        switch (local){
            case "서울":
                areaCode="02";
                break;
            case "부산":
                areaCode="051";
                break;
            case "대구":
                areaCode="053";
                break;
            case "인천":
                areaCode="032";
                break;
            case "광주":
                areaCode="062";
                break;
            case "대전":
                areaCode="042";
                break;
            case "울산":
                areaCode="052";
                break;
            case "경기":
                areaCode="031";
                break;
            case "강원":
                areaCode="033";
                break;
            case "충북":
                areaCode="043";
                break;
            case "충남":
                areaCode="041";
                break;
            case "전북":
                areaCode="063";
                break;
            case "전남":
                areaCode="061";
                break;
            case "세종":
                areaCode="044";
                break;
            case "경북":
                areaCode="054";
                break;
            case "경남":
                areaCode="055";
                break;
            case "제주":
                areaCode="064";
                break;
            default:
                break;
        }

        //url=앞에 중복되는 url+날짜+areaCode
        url = "https://www.airkorea.or.kr/web/sidoAirInfo/sidoAirInfoDay01?itemCode=10007&ymd=" + fTime + "%2023&areaCode="+areaCode;

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")

            //비동기 jsoup으로 사이트 크롤링
            @Override
            public void onClick(View v) {
                new AsyncTask(){
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        try {
                            //document로 url 가져오기
                            doc = Jsoup.connect(url).get();
                            //가져온 url의 class=al1 인 tr 을 선택
                            //intent로 받은 index에 2를 더해 맞는 인덱스의 tr내용 선택
                            //tr의 인덱스 0번째.1번째는 평균,시간별 미세먼지 농도이므로 필요한 정보 아님
                            //이후 0번째 td의 내용을 text로 가져옴
                            contents = doc.select("tr.al1").eq(index+2).select("td").eq(0).text();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //dust에 미세먼지농도를 담은 contents를 String 형태로 담기
                        dust= String.valueOf(contents);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);

                        //String 형태의 미세먼지농도를 int형태로 바꿔줌
                        int fdust=Integer.parseInt(dust);
                        //미세먼지 농도의 기준 분류(if절 안에는 boolean 형태로 적어줘야함)
                        if(0<=fdust&&fdust<=30){
                            ment="오늘의 미세먼지는 '좋음'이에요. 실외 약속을 잡아도 되겠네요.";
                            imageView01.setImageResource(R.drawable.ic_veryhappy);

                        }
                        else if(31<=fdust&&fdust<=80){
                            ment="오늘의 미세먼지는 '보통'이에요. 실외 약속을 잡아도 되지만 너무 오래 있지는 마세요.";
                            imageView01.setImageResource(R.drawable.ic_happy);

                        }
                        else if(81<=fdust&&fdust<=150){
                            ment="오늘의 미세먼지는 '나쁨'이에요. 실내 약속을 잡는게 좋겠어요.";
                            imageView01.setImageResource(R.drawable.ic_sad);

                        }
                        else if(fdust>=151){
                            ment="오늘의 미세먼지는 '매우 나쁨'이에요. 바깥으로 나가는 것을 비추천해요.";
                            imageView01.setImageResource(R.drawable.ic_verysad);
                        }

                        //final ment 작성
                        fMent="오늘의 미세먼지 농도:"+dust+"\n"+ment;
                        //fMent textView에 넣어주기
                        tvFinal.setText(dust);//이건 출력 안됨!
                        tvFinal.setText(fMent);
                    }
                }.execute();

                }

        });



    }





}


