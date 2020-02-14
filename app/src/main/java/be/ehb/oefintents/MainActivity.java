package be.ehb.oefintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //UI
    private TextView tvName;
    private Button callButton;
    private Button homeButton;


    //Listeners

    private View.OnClickListener callListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri callUri = Uri.parse("tel:0474855264");
            Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    askPermission();
                    return;
                }
            }
            startActivity(callIntent);

        }
    };
        private void askPermission() {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);

        }



    //methode om in layout naar te verwijzen
        public void openWebsite(View v) {
        Uri webUri = Uri.parse("https://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(webIntent);



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //verwijzing naar view in UI
        callButton = findViewById(R.id.btn_call);
        homeButton = findViewById(R.id.btn_homepage);
        tvName = findViewById(R.id.tv_name);



        //koppelen listeners aan views
        callButton.setOnClickListener(callListener);



    }
}
