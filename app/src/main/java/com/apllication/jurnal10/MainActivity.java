package com.apllication.jurnal10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rV_data;
    MainActivityAdapter mainAdapter;
    ArrayList<ListData> listdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rV_data = findViewById(R.id.rV_data);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            dateTimeFormatter.format(time);

            listdata.add(new ListData(1,"Xpander Cross","Premium At\n290juta","Rockford",LocalDateTime.now(),false));
            listdata.add(new ListData(2,"Xpander Cross","Premium At\n290juta","Rockford\nfosgate\n300 juta",LocalDateTime.now(),false));

        }




        rV_data.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rV_data.setLayoutManager(lm);
        mainAdapter = new MainActivityAdapter(this, listdata);
        rV_data.setAdapter(mainAdapter);

    }


}