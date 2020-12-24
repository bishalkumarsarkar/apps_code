package com.example.dutestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

public class Student_Activity extends AppCompatActivity {
    private SearchView searchView;
    private Spinner spinner;
    private ListView listView;
    private String[] name, spinnerText, classRoll, registrationNumber, bloodGroup, hallName,
            homeDistrict, mobileNumber, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_);

        //adding back button on Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        searchView = findViewById(R.id.searchViewId);
        spinner = findViewById(R.id.spinnerId);
        listView = findViewById(R.id.listViewId);

        // adding resource
        name = getResources().getStringArray(R.array.nameList);
        spinnerText = getResources().getStringArray(R.array.spinnerText);
        classRoll = getResources().getStringArray(R.array.roll);
        registrationNumber = getResources().getStringArray(R.array.registrationNumberList);
        bloodGroup = getResources().getStringArray(R.array.bloodList);
        hallName = getResources().getStringArray(R.array.hall_name_array);
        homeDistrict = getResources().getStringArray(R.array.districtList);
        mobileNumber = getResources().getStringArray(R.array.mobileNumberList);
        email = getResources().getStringArray(R.array.emailList);

        //setting adapter on spinner
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(Student_Activity.this, R.array.spinnerText, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // setting listener on spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                String value = text;
                // checking spinner choice and terminated the listView
                final ArrayAdapter adapter = new ArrayAdapter(Student_Activity.this, R.layout.list_view_sample, R.id.textViewListViewId, name);
                listView.setAdapter(adapter);
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String listViewText = name[position];
                        Intent intent = new Intent(Student_Activity.this, Details_Activitiy.class);
                        intent.putExtra("key", listViewText);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    } // end line of onCreate method

    // this is for back button on the action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}