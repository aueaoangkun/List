package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.b,R.drawable.few,R.drawable.c,R.drawable.fin,R.drawable.a,R.drawable.pun};
        String[] name = {"Pun","Thanakorn","Aueaoangkun","Pew","Ohm","FIN"};
        String[] id = {"623410006-2","623410034-7","623410059-1","623410006-2","623410034-7","623410059-1"};
        String[] number = {"01","02","03","04","05","06"};
        String[] phone = {"062-619-5887","082-532-1271","0642806995","062-619-5887","082-532-1271","0642806995"};
        String[] major = {"Computer science","Computer science","Computer science","Computer science","Computer science","Computer science"};
        String[] universi = {"KKU NKC","KKU NKC","KKU NKC","KKU NKC","KKU NKC","KKU NKC"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],id[i],number[i],phone[i],major[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phone[position]);
                i.putExtra("major",major[position]);
                i.putExtra("universi",universi[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}