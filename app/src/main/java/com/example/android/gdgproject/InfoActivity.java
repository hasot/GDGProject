package com.example.android.gdgproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

/**
 * Created by root on 19.04.16.
 */
public class InfoActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private CheckBox checkBox;
    private Button backButton;
    private Button emailButton;
    String gg;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_films);
        textView =(TextView)findViewById(R.id.text_info);
        imageView =(ImageView)findViewById(R.id.image);
        checkBox =(CheckBox)findViewById(R.id.check_account);

        Intent i = getIntent();
        textView.setText(i.getStringExtra("hah"));
        gg = i.getStringExtra("h");
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        imageView.setImageResource(pic);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    emailButton.setVisibility(View.VISIBLE);
                }
                else {
                    emailButton.setVisibility(View.INVISIBLE);
                }
            }
        });
        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build the intent
                Uri webpage = Uri.parse(gg);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                String title = getResources().getString(R.string.chooser_title);
                Intent chooser = Intent.createChooser(webIntent, title);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }

            }
        });
        emailButton = (Button) findViewById(R.id.email_button);
        emailButton.setVisibility(View.INVISIBLE);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dima.yonkov@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(i, "Отправить email"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InfoActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
