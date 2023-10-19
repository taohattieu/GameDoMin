package com.example.gamedomin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameEngine.getInstance().createGrid(this);

        // Tìm Button trong layout bằng ID
        Button button = findViewById(R.id.btnback);

        // Gắn sự kiện lắng nghe cho Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến SecondActivity
                Intent intent = new Intent(MainActivity.this, trangchu.class);

                // Bắt đầu SecondActivity
                startActivity(intent);
            }
        });
    }
}