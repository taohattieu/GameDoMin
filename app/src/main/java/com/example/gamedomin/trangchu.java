package com.example.gamedomin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gamedomin.huongdan;

public class trangchu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        Button btnChoiNgay = findViewById(R.id.btn1);
        Button btnHuongDan = findViewById(R.id.btn2);

        // Gắn sự kiện lắng nghe cho Nút Chơi Ngay
        btnChoiNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển đến trang chơi
                Intent intent = new Intent(trangchu.this, MainActivity.class);
                // Bắt đầu Activity mới
                startActivity(intent);
            }
        });

        // Gắn sự kiện lắng nghe cho Nút Hướng Dẫn
        btnHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển đến trang hướng dẫn
                Intent intent = new Intent(trangchu.this, huongdan.class);
                // Bắt đầu Activity mới
                startActivity(intent);
            }
        });
    }
}
