package com.example.revisionpracticedec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MoreDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title,seekPerson,fullDesc;
    Button back,selectedCart,addToSelected;
    ImageView bigImage;
    ListView list2;
    SeekBar sb1;

    static double ttp=0;
    public static ArrayList<SelectedCart> selected1=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        title=findViewById(R.id.txvTitle);
        back=findViewById(R.id.btnBack);
        selectedCart=findViewById(R.id.btnShowSelecte2);
        addToSelected=findViewById(R.id.btnadd);
        bigImage=findViewById(R.id.imgvBig);
        list2=findViewById(R.id.list2);
        sb1=findViewById(R.id.seekBar);
        seekPerson=findViewById(R.id.txvPersons);
        fullDesc=findViewById(R.id.txvFullDesc);
        String getTitle = MainActivity.selectedPlace.getCountry()+"-"+MainActivity.selectedPlace.getName();
        title.setText(getTitle);
        bigImage.setImageResource(MainActivity.selectedPlace.getImages().get(0));
        fullDesc.setText(MainActivity.selectedPlace.getFullDesc());
        list2.setAdapter(new SideImagesAdapter(this,MainActivity.selectedPlace.getImages()));
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bigImage.setImageResource(MainActivity.selectedPlace.getImages().get(position));

            }
        });
        back.setOnClickListener(this);
        selectedCart.setOnClickListener(this);
        addToSelected.setOnClickListener(this);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekPerson.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnBack:
                Intent intent = new Intent(MoreDetailsActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnadd:
//                for(SelectedCart st:selected1)
//                    if(st.getName().equals(MainActivity.selectedPlace.getName())){
//                        Toast.makeText(getBaseContext(), "This place already added", Toast.LENGTH_LONG).show();
//                    } else {
                        int pers = Integer.parseInt(seekPerson.getText().toString());
                        double price = MainActivity.selectedPlace.getPrice();
                        double total = pers * price;
                        if(total>MainActivity.budget){
                            Toast.makeText(getBaseContext(), "Exceeds your budget", Toast.LENGTH_LONG).show();
                        }
                        else
                        selected1.add(new SelectedCart(MainActivity.selectedPlace.getName(), total, pers));
                       // ttp=totalPrice(selected1);

                break;
            case R.id.btnShowSelecte2:
                Intent intent2=new Intent(MoreDetailsActivity.this,SelectedPlacesActivity.class);
                startActivity(intent2);
                break;


        }
    }
//    public double totalPrice(ArrayList<SelectedCart> selected1){
//        double totl=0.0;
//        for(SelectedCart st:selected1){
//            totl=totl+st.getPriceTotal();
//        }
//        return totl;
//    }

}