package winningteam.minnehack.io.hackathonandroid;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;
import winningteam.minnehack.io.hackathonandroid.db.AppExecutors;
import winningteam.minnehack.io.hackathonandroid.db.repository.UserRepository;
import winningteam.minnehack.io.hackathonandroid.model.GenderType;
import winningteam.minnehack.io.hackathonandroid.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private Spinner genderSpinner;
    private EditText firstNameEt;
    private EditText lastNameEt;
    private UserRepository mUserRepository;
    private AppExecutors mAppExecutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppExecutors = new AppExecutors();
        AppDatabase database = AppDatabase.getInstance(this.getApplicationContext(), mAppExecutors);
        mUserRepository = UserRepository.getInstance(database);
        ageEditText =  findViewById(R.id.age_EditText);
        firstNameEt =  findViewById(R.id.first_name_edit_text);
        lastNameEt = findViewById(R.id.last_name_edit_text);
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
        user.setFirstName(firstNameEt.getText().toString());
        user.setLastName(lastNameEt.getText().toString());
        user.setHeight(Double.parseDouble(heightEditText.getText().toString()));
        mUserRepository.insertUser(user);

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
