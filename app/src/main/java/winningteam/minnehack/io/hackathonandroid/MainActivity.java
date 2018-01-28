package winningteam.minnehack.io.hackathonandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Spinner genderSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageEditText =  findViewById(R.id.age_EditText);
        weightEditText =  findViewById(R.id.weight_EditText);
        heightEditText =  findViewById(R.id.height_EditText);
        genderSpinner =  findViewById(R.id.gender_Spinner);
        firstNameEditText = findViewById(R.id.first_name_edit_text);
        lastNameEditText = findViewById(R.id.last_name_edit_text);

    }

    public void onSubmitClick(View v)
    {
        if(ageEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please Enter Age!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(heightEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please Enter Height!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(weightEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please Enter Weight!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(firstNameEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please Enter First Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(lastNameEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please Enter Last Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        showSportDetailsActivity();
    }

    private void showSportDetailsActivity()
    {
        Intent showSportActivityIntent = new Intent(this, SportDetailsActivity.class);
        double weight = Integer.parseInt(weightEditText.getText().toString());
        showSportActivityIntent.putExtra("weight", weight);
        double height = Integer.parseInt(heightEditText.getText().toString());
        showSportActivityIntent.putExtra("height", height);
        double age = Integer.parseInt(ageEditText.getText().toString());
        showSportActivityIntent.putExtra("age", age);
        String gender = genderSpinner.getSelectedItem().toString();
        showSportActivityIntent.putExtra("gender", gender);

        startActivity(showSportActivityIntent);
    }
}
