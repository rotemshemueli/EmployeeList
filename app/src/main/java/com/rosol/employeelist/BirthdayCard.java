package com.rosol.employeelist;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BirthdayCard extends AppCompatActivity {

    TextView mTitle,mName;
    ImageView cake;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.birthday_card);

        mName=findViewById(R.id.name_birtday);
        mTitle=findViewById(R.id.birthday_card_title);
        cake=findViewById(R.id.image_cake);

    }
}
