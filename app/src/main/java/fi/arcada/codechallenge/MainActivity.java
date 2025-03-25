package fi.arcada.codechallenge;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalc = (Button) findViewById(R.id.btn);

        btncalc.setOnClickListener(v -> btncalculate());
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