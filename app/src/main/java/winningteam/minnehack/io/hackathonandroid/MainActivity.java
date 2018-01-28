package winningteam.minnehack.io.hackathonandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private Spinner sportSpinner;
    private Spinner genderSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageEditText =  findViewById(R.id.age_EditText);
        weightEditText =  findViewById(R.id.weight_EditText);
        heightEditText =  findViewById(R.id.weight_EditText);
        sportSpinner =  findViewById(R.id.sports_Spinner);
        genderSpinner =  findViewById(R.id.gender_Spinner);

    }

    public void onSubmitClick(View v)
    {
        showSportDetailsActivity();
    }

    private void showSportDetailsActivity()
    {
        Intent showSportActivityIntent = new Intent(this, SportDetailsActivity.class);
        showSportActivityIntent.putExtra("weight", Integer.parseInt(weightEditText.getText().toString()));
        showSportActivityIntent.putExtra("height", Integer.parseInt(heightEditText.getText().toString()));
        showSportActivityIntent.putExtra("age", Integer.parseInt(ageEditText.getText().toString()));
        showSportActivityIntent.putExtra("sport", Integer.parseInt(sportSpinner.getSelectedItem().toString()));
        showSportActivityIntent.putExtra("gender", Integer.parseInt(genderSpinner.getSelectedItem().toString()));

        startActivity(showSportActivityIntent);
    }
}
