package com.example.practicalfive;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Municipality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        TextView tvCityName = findViewById(R.id.tv_city_name);
        ImageView ivCityPic = findViewById(R.id.iv_city_pic);
        TextView tvInfoText = findViewById(R.id.tv_info_text);
        Button btnVisitWeb = findViewById(R.id.btn_visit_web);

        TextProcessor processor = new TextProcessor();

        String rawName = getIntent().getStringExtra("MUNICIPALITY_NAME");
        String cityName = processor.processMunicipality(rawName);


        if(cityName == null){
            Toast.makeText(this,"Invalid city data",Toast.LENGTH_SHORT).show();
            finish();
            return;
        }


        String[] infoArray = getResources().getStringArray(R.array.municipalities_array);
        String targetUrl = "";


        switch (cityName){
            case "Beijing":
                tvCityName.setText(cityName);
                tvCityName.setBackgroundColor(getColor(R.color.municipality_beijing));
                tvCityName.setTextColor(getColor(R.color.color_text_light));
                ivCityPic.setImageResource(R.drawable.beijing);
                tvInfoText.setText(infoArray[0]);
                tvInfoText.setTextColor(getColor(R.color.municipality_beijing));
                btnVisitWeb.setBackgroundTintList(getColorStateList(R.color.municipality_beijing));
                targetUrl = "https://english.beijing.gov.cn/";
                break;
            case "Shanghai":
                tvCityName.setText(cityName);
                tvCityName.setBackgroundColor(getColor(R.color.municipality_shanghai));
                tvCityName.setTextColor(getColor(R.color.color_text_light));
                ivCityPic.setImageResource(R.drawable.shanghai);
                tvInfoText.setText(infoArray[1]);
                tvInfoText.setTextColor(getColor(R.color.municipality_shanghai));
                btnVisitWeb.setBackgroundTintList(getColorStateList(R.color.municipality_shanghai));
                targetUrl = "https://english.shanghai.gov.cn/";
                break;
            case "Chongqing":
                tvCityName.setText(cityName);
                tvCityName.setBackgroundColor(getColor(R.color.municipality_chongqing));
                tvCityName.setTextColor(getColor(R.color.color_text_light));
                ivCityPic.setImageResource(R.drawable.chongqing);
                tvInfoText.setText(infoArray[2]);
                tvInfoText.setTextColor(getColor(R.color.municipality_chongqing));
                btnVisitWeb.setBackgroundTintList(getColorStateList(R.color.municipality_chongqing));
                targetUrl = "https://english.cq.gov.cn/";
                break;
            case "Tianjin":
                tvCityName.setText(cityName);
                tvCityName.setBackgroundColor(getColor(R.color.municipality_tianjin));
                tvCityName.setTextColor(getColor(R.color.color_text_light));
                ivCityPic.setImageResource(R.drawable.tianjin);
                tvInfoText.setText(infoArray[3]);
                tvInfoText.setTextColor(getColor(R.color.municipality_tianjin));
                btnVisitWeb.setBackgroundTintList(getColorStateList(R.color.municipality_tianjin));
                targetUrl = "https://en.tj.gov.cn/";
                break;
        }

        final String webUrl = targetUrl;
        btnVisitWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse(webUrl);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);

            if(getPackageManager().resolveActivity(webIntent,0) != null){
                startActivity(webIntent);
            }else{
                Toast.makeText(Municipality.this,"No browser app available",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
