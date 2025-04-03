package fi.arcada.codechallenge;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DataModel> dataList = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalc = (Button) findViewById(R.id.btn);

        btncalc.setOnClickListener(v -> btncalculate());

        EditText inputField1 = findViewById(R.id.input1);
        EditText inputField2 = findViewById(R.id.input2);
        Button addButton = findViewById(R.id.btn);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(dataList);
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = inputField1.getText().toString();
                String value2 = inputField2.getText().toString();
                // Error handlers!
                if (!value1.isEmpty() && !value2.isEmpty()) {
                    // Ta värdena och sätt dem i vår dataList
                    dataList.add(new DataModel(value1, value2));
                    // berättar till vår adapter att det har kommit en update
                    // Det finns även mer specifika metoder (item update, item add... )
                    adapter.notifyDataSetChanged();
                    inputField1.setText("");
                    inputField2.setText("");

                    //CalcMean
                    //double meanValue = statistic.calcMean();
                    //LogCat!
                    //Log.d("MeanValue", "Mean value of integers: " + meanValue);
                }
            }
        });
    }


    private void btncalculate(){
        ArrayList<Double> arraylistDouble = new ArrayList<>();
        arraylistDouble.add(1.0);
        arraylistDouble.add(2.0);
        arraylistDouble.add(3.0);

       double median = statistic.calcMean(arraylistDouble);
        String result = Double.toString(median);
        TextView textfield = (TextView) findViewById(R.id.hello);
        textfield.setText(result);

    }

}