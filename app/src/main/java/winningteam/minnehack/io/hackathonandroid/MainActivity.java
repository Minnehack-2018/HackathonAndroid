package winningteam.minnehack.io.hackathonandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import winningteam.minnehack.io.hackathonandroid.model.GenderType;
import winningteam.minnehack.io.hackathonandroid.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private Spinner genderSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageEditText =  findViewById(R.id.age_EditText);
        weightEditText =  findViewById(R.id.weight_EditText);
        heightEditText =  findViewById(R.id.height_EditText);
        genderSpinner =  findViewById(R.id.gender_Spinner);

    }

    public void onSubmitClick(View v)
    {
        createUser();
        showSportDetailsActivity();
    }

    private void createUser() {
        User user = new User();
        user.setWeight(Double.parseDouble(weightEditText.getText().toString()));
        user.setGender(GenderType.valueOf(genderSpinner.getSelectedItem().toString()));
        user.setAge(Integer.parseInt(ageEditText.getText().toString()));
        user.setHeight(Double.parseDouble(heightEditText.getText().toString()));
    }

    private void showSportDetailsActivity()
    {
        Intent showSportActivityIntent = new Intent(this, SportDetailsActivity.class);
        int weight = Integer.parseInt(weightEditText.getText().toString());
        showSportActivityIntent.putExtra("weight", weight);
        int height = Integer.parseInt(heightEditText.getText().toString());
        showSportActivityIntent.putExtra("height", height);
        int age = Integer.parseInt(ageEditText.getText().toString());
        showSportActivityIntent.putExtra("age", age);
        String gender = genderSpinner.getSelectedItem().toString();
        showSportActivityIntent.putExtra("gender", gender);

        startActivity(showSportActivityIntent);
    }
}
