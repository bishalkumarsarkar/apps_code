package com.example.dutestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_Activitiy extends AppCompatActivity {
    private TextView detailsTextView, nameTextView,classRollTextView, regiTextView,bloodTextView,hallNameTextView,
        homeDistrictTextView,mobileTextView, emailTextView,fullRollTextView;
    private ImageView imageView;
    private int[] flag = {R.drawable.akil,R.drawable.hanna,R.drawable.polash,R.drawable.mir,R.drawable.bks,R.drawable.safa,
            R.drawable.shovon,R.drawable.mathin,R.drawable.arman,R.drawable.rajvir,R.drawable.sagor,R.drawable.tanvir,R.drawable.sajib,R.drawable.ruman,
            R.drawable.roni,R.drawable.shanto,R.drawable.shishir,R.drawable.sumaiya,R.drawable.rafsan,R.drawable.najnin,R.drawable.nadim,R.drawable.ushrika,
            R.drawable.shikhon,R.drawable.kawsar,R.drawable.kallul,R.drawable.pia,R.drawable.shakila,R.drawable.ela,R.drawable.hasib,R.drawable.saikat,
            R.drawable.alamin,R.drawable.sabbir,R.drawable.shammijerin,R.drawable.pappu,R.drawable.nur,R.drawable.rahma,R.drawable.sharmin,R.drawable.rahi,
            R.drawable.sojibur,R.drawable.jerin,R.drawable.naimur,R.drawable.rokon,R.drawable.soumit};
    private String[] name,classRoll,fullRoll,registrationNumber,bloodGroup,hallName,homeDistrict,mobileNumber,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__activitiy);

        //adding back button on Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //finding
        imageView = findViewById(R.id.detailsImageViewId);
        detailsTextView = findViewById(R.id.details_id);
        nameTextView = findViewById(R.id.nameTextViewId);
        classRollTextView = findViewById(R.id.classRollTextViewId);
        fullRollTextView = findViewById(R.id.fullRollTextViewId);
        regiTextView = findViewById(R.id.registrationTextViewId);
        bloodTextView = findViewById(R.id.bloodGroupTextViewId);
        hallNameTextView = findViewById(R.id.hallNameTextViewId);
        homeDistrictTextView = findViewById(R.id.homeDistrictTextViewId);
        mobileTextView = findViewById(R.id.mobileNumberTextViewId);
        emailTextView = findViewById(R.id.emailTextViewId);

        //adding value
        name = getResources().getStringArray(R.array.nameList);
        classRoll = getResources().getStringArray(R.array.roll);
        fullRoll = getResources().getStringArray(R.array.fullRoll);
        registrationNumber =getResources().getStringArray(R.array.registrationNumberList);
        bloodGroup = getResources().getStringArray(R.array.bloodList);
        hallName = getResources().getStringArray(R.array.hall_name_array);
        homeDistrict = getResources().getStringArray(R.array.districtList);
        mobileNumber = getResources().getStringArray(R.array.mobileNumberList);
        email = getResources().getStringArray(R.array.emailList);

        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("key").toString();
        String listViewChoice = value;

        for(int i=0; i<name.length; i++){
            if (listViewChoice.equals(name[i])){
                imageView.setImageResource(flag[i]);
                nameTextView.setText(name[i]);
                classRollTextView.setText(classRoll[i]);
                fullRollTextView.setText(fullRoll[i]);
                regiTextView.setText(registrationNumber[i]);
                bloodTextView.setText(bloodGroup[i]);
                hallNameTextView.setText(hallName[i]);
                homeDistrictTextView.setText(homeDistrict[i]);
                mobileTextView.setText(mobileNumber[i]);
                emailTextView.setText(email[i]);
            }
        }

    } // end line of on create method

    // this is for back button on the action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}