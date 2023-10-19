package com.example.gamedomin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trangchu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        Button button = findViewById(R.id.btn1);
        // Gắn sự kiện lắng nghe cho Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển đến trang layout activity_main.xml
                Intent intent = new Intent(trangchu.this, MainActivity.class);

                // Bắt đầu Activity mới
                startActivity(intent);
            }
        });
    }
}