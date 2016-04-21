package com.example.android.gdgproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageButton LimButton;
    private ImageButton LockButton;
    private ImageButton yesButton;
    private ImageButton depButton;
    private ImageButton revButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        LimButton = (ImageButton)findViewById(R.id.limit);
        LimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("hah", getString(R.string.limitlessInfo));
                i.putExtra("h", getString(R.string.lim));
                Bundle bundle = new Bundle();
                bundle.putInt("image", R.drawable.lim_photo);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
        LockButton = (ImageButton)findViewById(R.id.lock);
        LockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("hah", getString(R.string.lock));
                i.putExtra("h", getString(R.string.lock_link));
                Bundle bundle = new Bundle();
                bundle.putInt("image", R.drawable.lock);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
        yesButton = (ImageButton)findViewById(R.id.yesfilm);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("hah", getString(R.string.yes_man));
                i.putExtra("h", getString(R.string.yes));
                Bundle bundle=new Bundle();
                bundle.putInt("image", R.drawable.yes_man);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
        depButton = (ImageButton)findViewById(R.id.departed);
        depButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("hah" , getString(R.string.thedep));
                i.putExtra("h", getString(R.string.depe));
                Bundle bundle=new Bundle();
                bundle.putInt("image", R.drawable.thedeparted);
                i.putExtras(bundle);
                startActivity(i);

            }
        });
        revButton = (ImageButton)findViewById(R.id.revolver);
        revButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("hah" , getString(R.string.recolver));
                i.putExtra("h", getString(R.string.revolve));
                Bundle bundle=new Bundle();
                bundle.putInt("image", R.drawable.revolver);
                i.putExtras(bundle);
                startActivity(i);

            }
        });


    }
}
