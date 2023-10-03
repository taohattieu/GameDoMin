package com.example.gamedomin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class trangchu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Gắn sự kiện lắng nghe cho Button
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển đến trang layout activity_main.xml
                Intent intent = new Intent(trangchu.this, MainActivity.class);

                // Bắt đầu Activity mới
                startActivity(intent);
            }
        });
    }

    private static void setOnClickListener(View.OnClickListener onClickListener) {
    }
}