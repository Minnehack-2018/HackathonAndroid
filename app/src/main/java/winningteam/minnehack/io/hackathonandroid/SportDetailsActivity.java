package winningteam.minnehack.io.hackathonandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SportDetailsActivity extends AppCompatActivity {
    private double height;
    private double weight;
    private int age;
    private String gender;
    AlertDialog actions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_details);

        Intent starter = getIntent();
        height = starter.getDoubleExtra("height",0);
        weight = starter.getDoubleExtra("weight",0);
        age = starter.getIntExtra("age",0);
        gender = starter.getStringExtra("gender");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option");
        String[] options = { "A", "B", "C" };
        builder.setItems(options, actionListener);
        builder.setNegativeButton("Cancel", null);
        actions = builder.create();

    }

    DialogInterface.OnClickListener actionListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case 0: // Delete
                    break;
                case 1: // Copy
                    break;
                case 2: // Edit
                    break;
                default:
                    break;
            }
        }
    };

    public void getData(String [][] source)
    {
        for(int i=0; i<source.length; i++)
        {
          //  CardView cv = new CardView();

        }
    }

    public void onClickButton(View v)
    {
        setContentView(R.layout.activity_sport_details);
//        ScrollView sv = (ScrollView) this.findViewById(android.R.id.content);
        CardView cv = new CardView(this);
//        cv.setlayout
        LinearLayout ll = this.findViewById(R.id.ll);
        TextView tv = new TextView(this);
        tv.setText("Zobryyyy");
        ll.addView(tv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // COMPLETED (9) Within onCreateOptionsMenu, use getMenuInflater().inflate to inflate the menu
        getMenuInflater().inflate(R.menu.sport_detail_menu, menu);
        // COMPLETED (10) Return true to display your menu
        return true;
    }

    // COMPLETED (11) Override onOptionsItemSelected
    // COMPLETED (12) Within onOptionsItemSelected, get the ID of the item that was selected
    // COMPLETED (13) If the item's ID is R.id.action_search, show a Toast and return true to tell Android that you've handled this menu click
    // COMPLETED (14) Don't forgot to call .show() on your Toast
    // COMPLETED (15) If you do NOT handle the menu click, return super.onOptionsItemSelected to let Android handle the menu click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_addSport) {
            actions.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
