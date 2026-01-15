package com.example.lab2;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    // buttons



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};
        dataList = new ArrayList<>();   // without new keyword you will get nullpointer exception
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        // objects on screen
        Button addCityButton = findViewById(R.id.add_city_button);
        Button deleteCity = findViewById(R.id.delete_city_button);
        LinearLayout bottomBar = findViewById(R.id.bottom_bar);
        Button confirmButton = findViewById(R.id.city_confirm);
        EditText addCityField = findViewById(R.id.add_city_field);

        // listener
        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.setVisibility(View.VISIBLE);
            }
        });

        // click button
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCity = addCityField.getText().toString();

                if (!newCity.isEmpty()) {
                    dataList.add(newCity); // Add to your ArrayList
                    cityAdapter.notifyDataSetChanged(); // Refresh the ListView

                    addCityField.setText(""); // Clear the input field
                    bottomBar.setVisibility(View.GONE); // Hide the bar again after adding it
                }
            }
        });
        // delete city button logic
        deleteCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}