package com.example.gamedomin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class huongdan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huongdan);

        Button buttonQuaylai = findViewById(R.id.btnback);

        buttonQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(huongdan.this, trangchu.class);

                startActivity(intent);
            }
        });
    }
}
