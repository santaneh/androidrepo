package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class SettingsActivity extends AppCompatActivity {
    private Button settingsButton;

    TextInputEditText userInputField;

    private SharedPreferences sharedPreferences;

    // Återanvänd koden i MainActivity, så vi använder samma sharedPreference fil och "räknare"
    private static final String PREFS_NAME = "AppCounterPrefs";
    private static final String APP_COUNTER_KEY = "appCounter";
    private static final String MESSAGE_KEY = "Message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        userInputField = findViewById(R.id.settingsInput);

        // Helt vanlig knapp som vi hittar
        // På knappen sätter vi funktionen att nolla vår räknare
        // - Samma sätt som vi uppdatera den, kan vi sätta den till noll
        // --- Man kan göra om denna knapp till Spara knappen!

        settingsButton = findViewById(R.id.button);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        settingsButton.setOnClickListener(v -> runMessage(userInputField));

        }

    public void runMessage(View view) {
        String inputText = userInputField.getText().toString();
        //Log.d("UserInputDebug", "User entered: " + inputText);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MESSAGE_KEY, inputText);
        editor.apply();

        String saved = sharedPreferences.getString(MESSAGE_KEY, "Not saved");
        Log.d("SavedFromActivity", "Saved in SettingsActivity: " + saved);

    }

    }
