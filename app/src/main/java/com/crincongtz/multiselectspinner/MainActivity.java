package com.crincongtz.multiselectspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MultiSelectionSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] chooseOptions = getResources().getStringArray(R.array.state_list);

        // Multi spinner
        spinner = findViewById(R.id.mySpinner1);
        spinner.setItems(chooseOptions);

        Button bt = (Button) findViewById(R.id.getSelected);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = spinner.getSelectedItemsAsString();
                Log.d("getSelected", s);
            }
        });

        // Second

        List<String> items = Arrays.asList(getResources().getStringArray(R.array.state_list));

        MultiSpinner multiSpinner = (MultiSpinner) findViewById(R.id.multi_spinner);
        multiSpinner.setItems(items, "None");
        multiSpinner.setMultiSpinnerListener(new MultiSpinner.MultiSpinnerListener() {
            @Override
            public void onItemsSelected(String selected) {
                Log.d("getSelected",  "Result: " + selected);
            }
        });

    }

}
