package com.example.revisionpracticedec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton opt1,opt2,opt3;
    Spinner sp1;
    ListView lv1;
    TextView smallDesc;
    Button showMore,showSelected;

    String countries[]={"India","Canada","USA","Australia","South Korea","Sri Lanka"};
    ArrayList<Places> placeList=new ArrayList<>();
    ArrayList<Places> placesTemp=new ArrayList<>();
    public static Places selectedPlace;
    static double budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        opt1=findViewById(R.id.rbOpt1);
        opt2=findViewById(R.id.rbOpt2);
        opt3=findViewById(R.id.rbOpt3);
        sp1=findViewById(R.id.spinner);
        lv1=findViewById(R.id.list1);
        smallDesc=findViewById(R.id.txvSmallDesc);
        showMore=findViewById(R.id.btnShowMore);
        showSelected=findViewById(R.id.btnSelected1);
        opt1.setOnClickListener(new ButtonEvents());
        opt2.setOnClickListener(new ButtonEvents());
        opt3.setOnClickListener(new ButtonEvents());
        ArrayAdapter adpt1=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countries);
        sp1.setAdapter(adpt1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillTemp(countries[position]);
                lv1.setAdapter(new PlacesAdapter(MainActivity.this,placesTemp));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPlace=placesTemp.get(position);
                smallDesc.setText(placesTemp.get(position).getSmallDesc());
            }
        });

        showSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SelectedPlacesActivity.class);
                startActivity(intent);
            }
        });
        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MoreDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
    private class ButtonEvents implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rbOpt1:
                    budget=2000;
                    break;
                case R.id.rbOpt2:
                    budget=5000;
                    break;
                case R.id.rbOpt3:
                    budget=10000;
            }
        }
    }

    //a method to fill the tempPlaces list upon the choosen countries
    public void fillTemp(String country){
        placesTemp.clear();
        for(Places pl:placeList){
            if(pl.getCountry().equals(country)){
                placesTemp.add(pl);
            }
        }
    }


    public void fillData(){
        ArrayList<Integer> taj=new ArrayList<>();
        taj.add(R.drawable.taj);
        taj.add(R.drawable.tajmahal2);
        taj.add(R.drawable.tajmahal3);
        placeList.add(new Places("Taj Mahal","One of the 7 Wonders of the World.","Taj Mahal is indeed a beautiful place. ... The Taj Mahal is a white marble built by Mughal emperor Shah Jahan in memory of his third wife, Mumtaz Mahal. In Arabic, the Taj Mahal is known as “crown of palaces”. It is said to be the jewel of Islamic art in a nation that is predominantly Hindu",1500,taj,countries[0]));
        ArrayList<Integer> kedarnath=new ArrayList<>();
        kedarnath.add(R.drawable.kedarnathindia);
        kedarnath.add(R.drawable.kedarnadh2);
        kedarnath.add(R.drawable.kedarnadh3);
        kedarnath.add(R.drawable.kedarnadh4);
        kedarnath.add(R.drawable.kedarnadh5);
        placeList.add(new Places("Kedarnath","is a Hindu temple dedicated to lord shiva","The temple, which is dedicated to Lord Shiva, is said to be more than 1,200 years old. It was built by Adi Shankaracharya and is among one of the 12 jyotirlingas in India. A visit to the Kedarnath temple is an integral part of the famous Char Dham Yatra in Uttarakhand.",5000,kedarnath,countries[0]));
        ArrayList<Integer> badrinath=new ArrayList<>();
        badrinath.add(R.drawable.badrinathindia);
        badrinath.add(R.drawable.badrinath2);
        badrinath.add(R.drawable.badrinath3);
        placeList.add(new Places("Badrinath","is a Hindu temple dedicated to Vishnu","Badrinath or Badrinarayana Temple is a Hindu temple dedicated to Vishnu which is situated in the town of Badrinath in Uttarakhand, India. The temple is also one of the 108 Divya Desams dedicated to Vishnu, who is worshipped as Badrinath—holy shrines for Vaishnavites. People following the Jain religion worship the temple and idol belonging to Rishbhdev (Rishabhanatha) or Adinath, the first Tirthankar of Jainism.[citation needed] It is open for six months every year (between the end of April and the beginning of November), because of extreme weather conditions in the Himalayan region.",5000,badrinath,countries[0]));
        ArrayList<Integer> kanyakumari=new ArrayList<>();
        kanyakumari.add(R.drawable.kanyakumari2);
        kanyakumari.add(R.drawable.kanyakumari3);
        kanyakumari.add(R.drawable.kanyakumari4);
        placeList.add(new Places("KanyaKumari","amous for its beautiful views of sunrise and sunset","Kanyakumari is the southernmost point of peninsular India and the meeting point of three oceans-the Bay of Bengal, the Arabian Sea and the Indian Ocean. Besides its importance as a Hindu pilgrim center, it is famous for its beautiful views of sunrise and sunset over the waters.",4500,kanyakumari,countries[0]));
        ArrayList<Integer> goldenTemple=new ArrayList<>();
        goldenTemple.add(R.drawable.goldentempleindia);
        goldenTemple.add(R.drawable.goldentemple2);
        goldenTemple.add(R.drawable.goldentemple3);
        goldenTemple.add(R.drawable.goldentemple4);
        placeList.add(new Places("Golden Temple","unique blend of the Hindu as well as the Islamic architecture","The exquisite Golden Temple is a unique blend of the Hindu as well as the Islamic architecture. The shrine is decorated with marble sculptures and paintings that look similar to the Taj Mahal. The dome at the top is made from pure gold and the gurudwara is also encased with intricate gold panels.",3790,goldenTemple,countries[0]));
        ArrayList<Integer> cn=new ArrayList<>();
        cn.add(R.drawable.cn);
        cn.add(R.drawable.cn2);
        cn.add(R.drawable.cn3);
        cn.add(R.drawable.cn4);
        placeList.add(new Places("CN Tower","is an internationally renowned architectural triumph","Defining the Toronto skyline at 553.33m (1,815ft5in), the CN Tower is Canada's most recognizable and celebrated icon. The CN Tower is an internationally renowned architectural triumph, an engineering Wonder of the Modern World, world-class entertainment and dining destination and a must see for anyone visiting Toronto.",1900,cn,countries[1]));
        ArrayList<Integer> niagaraFalls=new ArrayList<>();
        niagaraFalls.add(R.drawable.niagarafalls1);
        niagaraFalls.add(R.drawable.niagarafalls2);
        niagaraFalls.add(R.drawable.niagarafalls3);
        niagaraFalls.add(R.drawable.niagarafalls4);
        niagaraFalls.add(R.drawable.niagarafalls5);
        placeList.add(new Places("Niagara Falls","one of the most famous waterfalls in the world","During peak daytime tourist hours, more than 168,000 m3 (six million cubic feet) of water goes over the crest of the falls every minute. Horseshoe Falls is the most powerful waterfall in North America, as measured by flow rate. Niagara Falls is famed for its beauty and is a valuable source of hydroelectric power.",6000,niagaraFalls,countries[1]));
        ArrayList<Integer> museum=new ArrayList<>();
        museum.add(R.drawable.canadamuseum1);
        museum.add(R.drawable.canadamuseum3);
        placeList.add(new Places("Royal Museum","Royal Ontario Museum is a museum of art","It is the largest museum in Canada to explore both the natural world and humankind's cultural past. It houses world- renowned collections, is home to leading scholars, and, through innovative programs and galleries, engages over a million visitors each year.",4300,museum,countries[1]));
        ArrayList<Integer> bluffersPark=new ArrayList<>();
        bluffersPark.add((R.drawable.bufferspark1));
        bluffersPark.add((R.drawable.bufferspark2));
        bluffersPark.add((R.drawable.bufferspark3));
        bluffersPark.add((R.drawable.bufferspark4));
        placeList.add(new Places("Bluffers Park","processes of wind and water erosion from Lake Ontario","They became known as the Scarborough Highlands in 1793 named after Scarborough, North Yorkshire. The Scarborough Bluffs are a significant geological feature resulting from the accumulation of sedimentary deposits over 12,000 years ago. They were formed by the natural processes of wind and water erosion from Lake Ontario.",3000,bluffersPark,countries[1]));
        ArrayList<Integer> statue=new ArrayList<>();
        statue.add(R.drawable.statue);
        statue.add((R.drawable.statue2));
        statue.add((R.drawable.statue3));
        statue.add((R.drawable.statue4));
        placeList.add(new Places("Statue of Liberty","joint effort between France and USA","The Statue of Liberty was a joint effort between France and the United States, intended to commemorate the lasting friendship between the peoples of the two nations. ... Today, the Statue of Liberty remains an enduring symbol of freedom and democracy, as well as one of the world's most recognizable landmarks.",7000,statue,countries[2]));
        ArrayList<Integer> newyork=new ArrayList<>();
        newyork.add(R.drawable.newyork1);
        newyork.add(R.drawable.newyork2);
        newyork.add(R.drawable.newyork3);
        newyork.add(R.drawable.newyork4);
        placeList.add(new Places("NewYork City","one of the most famous cities in the world. ","New York has to be one of the most famous cities in the world. Often referred to as the 'Big Apple', this vibrant city is known for its exclusive shops, flashy Broadway performances, and high-flying business tycoons, and it's a city that has long captivated people from all over the world.",9000,newyork,countries[2]));
        ArrayList<Integer> bridge=new ArrayList<>();
        bridge.add(R.drawable.usabridge1);
        bridge.add(R.drawable.usabridge3);
        placeList.add(new Places("Peace Bridge","The Peace Bridge b/w usa and canada","The Peace Bridge is an international bridge between Canada and the United States at the east end of Lake Erie at the source of the Niagara River, about 20 kilometres (12.4 mi) upriver of Niagara Falls. It connects Buffalo, New York, in the United States to Fort Erie, Ontario, in Canada.",3000,bridge,countries[2]));
        ArrayList<Integer> sydney=new ArrayList<>();
        sydney.add(R.drawable.sydneylightup);
        sydney.add(R.drawable.sydneylighyup2);
        sydney.add(R.drawable.sydneylighyup3);
        sydney.add(R.drawable.sydneylighyup4);
        placeList.add(new Places("Opera House"," is a multi-venue performing arts centre in Sydney","The Sydney Opera House constitutes a masterpiece of 20th century architecture. Its significance is based on its unparalleled design and construction; its exceptional engineering achievements and technological innovation and its position as a world-famous icon of architecture.",7000,sydney,countries[3]));
        ArrayList<Integer> brisbane=new ArrayList<>();
        brisbane.add(R.drawable.brisbanecity1);
        brisbane.add(R.drawable.brisbanecity2);
        brisbane.add(R.drawable.brisbanecity3);
        brisbane.add(R.drawable.brisbanecity4);
        placeList.add(new Places("Brisbane City","3rd largest city in Australia","ustralia's third largest city, Brisbane (or as Aussies affectionately call it) offers sophisticated big-city attractions in a sun-splashed riverside setting. Although the city's history dates back to 1824, Brisbane rose to the world stage after hosting the Commonwealth Games in 1982 and World Expo in 1988.",3000,brisbane,countries[3]));
        ArrayList<Integer> melbourne=new ArrayList<>();
        melbourne.add(R.drawable.melbournecity1);
        melbourne.add(R.drawable.melbournecity2);
        placeList.add(new Places("Melbourne City","National Gallery of victoria","Melbourne is famous for its culture, and the National Gallery of Victoria is the jewel in the crown. It's not only the oldest public art gallery in Australia, it's also the most visited. Here, you can admire more than 70,000 works of European, Asian, Oceanic, and American art in two city locations.",1500,melbourne,countries[3]));
        ArrayList<Integer> sirigiriya=new ArrayList<>();
        sirigiriya.add(R.drawable.sirigiriya);
        sirigiriya.add(R.drawable.sirigiriya2);
        sirigiriya.add(R.drawable.sirigiriya3);
        placeList.add(new Places("Sirigiriya","famous for its massive high rock","\n" + "Sigiriya is famous for its palace ruins on top of a massive 200 meter high rock surrounded by the remains of an extensive network of gardens, reservoirs and other structures. The rock itself is a lava plug left over from an ancient long extinct volcano.",3000,sirigiriya,countries[5]));
        ArrayList<Integer> srilankaBeach=new ArrayList<>();
        srilankaBeach.add(R.drawable.srilankabeach);
        srilankaBeach.add(R.drawable.srilankabeach2);
        srilankaBeach.add(R.drawable.srilankabeach3);
        placeList.add(new Places("SriLankan Beach","famous as white sand beach","Rapidly gaining international popularity as one of the most beautiful beach destinations in the world, the island nation of Sri Lanka offers a range of landscapes, from rainforests to endless miles of powdery, white-sand beach",1890,srilankaBeach,countries[5]));
        ArrayList<Integer> sriCity=new ArrayList<>();
        sriCity.add(R.drawable.srilankacity1);
        sriCity.add(R.drawable.srilankacity2);
        sriCity.add(R.drawable.srilankacity3);
        sriCity.add(R.drawable.srilankacity4);
        placeList.add(new Places("SriLanka City","famous for its rich biodiversity,cinnamon and tea","Sri Lanka is famous for its rich biodiversity, large cinnamon and tea exportation, and stunning natural wonders! It's also known as the Pearl of the Indian Ocean and has diverse cultural and religious elements across the nation.",1400,sriCity,countries[5]));
        ArrayList<Integer> seoulCity=new ArrayList<>();
        seoulCity.add(R.drawable.seuolcity1);
        seoulCity.add(R.drawable.seuolcity4);
        seoulCity.add(R.drawable.seuolcity3);
        seoulCity.add(R.drawable.seuolcity2);
        placeList.add(new Places("Seoul City","famous for its music band BTS","There's a reason Asian tourists regularly rank Seoul, the capital of South Korea, as their favorite world city. Actually, there are 50 of them and possibly many, many more. Come with us as we take the Korean barbecue scraper to dig beneath the surface of one of Asia's true world cities",7500,seoulCity,countries[4]));
        ArrayList<Integer> amuesmentPark=new ArrayList<>();
        amuesmentPark.add(R.drawable.amuesmentparkseoul1);
        amuesmentPark.add(R.drawable.amuesmentparkseoul2);
        amuesmentPark.add(R.drawable.amuesmentparkseoul3);
        amuesmentPark.add(R.drawable.amuesmentparkseoul5);
        placeList.add(new Places("Amuesment Park","TWO famous theme parks, Lotte World and Everland","Lucky for us, Seoul is home to not one, but TWO famous theme parks, Lotte World and Everland. And while we all wish we had the luxury of visiting BOTH parks in 1 trip, many times we are either crunched for time or our wallets say no",3000,amuesmentPark,countries[4]));


    }

}