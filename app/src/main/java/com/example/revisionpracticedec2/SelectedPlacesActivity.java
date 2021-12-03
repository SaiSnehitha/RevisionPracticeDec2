package com.example.revisionpracticedec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SelectedPlacesActivity extends AppCompatActivity {

    ListView lst3;
    Button back3;
    TextView totPrice;
   static double ttp=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_places);
        lst3=findViewById(R.id.list3);
        back3=findViewById(R.id.btnBack3);
        totPrice=findViewById(R.id.txtTotalPrice3);
        for(SelectedCart st:MoreDetailsActivity.selected1)
            ttp=ttp+st.getPriceTotal();
      //  totPrice.setText(String.valueOf(CartAdapter.pp));
        totPrice.setText(String.valueOf(ttp));
        lst3.setAdapter(new CartAdapter(this,MoreDetailsActivity.selected1));
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectedPlacesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}