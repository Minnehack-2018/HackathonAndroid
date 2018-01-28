package winningteam.minnehack.io.hackathonandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
//        height = starter.getDoubleExtra("height",0);
//        weight = starter.getDoubleExtra("weight",0);
//        age = starter.getIntExtra("age",0);
//        gender = starter.getStringExtra("gender");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option");
        String[] options = { "Football", "Basketball", "Soccer", "Running", "Golf" };
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

    public void getData()
    {
        setContentView(R.layout.activity_sport_details);

        CardView cv = new CardView(this);
        Resources r = getResources();
        int cardHeightPX = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 380, r.getDisplayMetrics()));
        int cardMarginsPX = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, r.getDisplayMetrics()));


        LinearLayout.LayoutParams cvl = new LinearLayout.LayoutParams(CardView.LayoutParams.MATCH_PARENT,cardHeightPX);
        cvl.setMargins(cardMarginsPX,cardMarginsPX,cardMarginsPX,cardMarginsPX);
        LinearLayout ll = this.findViewById(R.id.cardContainer);
        ll.addView(cv,cvl);

        LinearLayout cardContents = new LinearLayout(this);
        cardContents.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        ImageView iv = new ImageView(this);
        int layoutHeightPX = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics()));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, layoutHeightPX);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageResource(R.drawable.pushup);
        cardContents.addView(iv,params);

        TextView tvTitle = new TextView(this);
        LinearLayout.LayoutParams params_tvTitle = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvTitle.setMaxLines(3);
        tvTitle.setPadding(cardMarginsPX,cardMarginsPX,cardMarginsPX,cardMarginsPX);
        tvTitle.setText("Warm up Title");
        tvTitle.setTextColor(Color.BLACK);
        tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        cardContents.addView(tvTitle, params_tvTitle);

        TextView tvDescription= new TextView(this);
        LinearLayout.LayoutParams params_tvDescription = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvDescription.setMaxLines(4);
        tvDescription.setPadding(cardMarginsPX,cardMarginsPX,cardMarginsPX,cardMarginsPX);
        tvDescription.setText("Warm up Description");
        tvDescription.setTextColor(Color.BLACK);
        tvDescription.setTypeface(Typeface.DEFAULT_BOLD);
        tvDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        cardContents.addView(tvDescription, params_tvDescription);

        cv.addView(cardContents,lllp);




    }

    public void onClickButton(View v)
    {
//        setContentView(R.layout.activity_sport_details);
////        ScrollView sv = (ScrollView) this.findViewById(android.R.id.content);
//        CardView cv = new CardView(this);
////        cv.setlayout
//        LinearLayout ll = this.findViewById(R.id.ll);
//        TextView tv = new TextView(this);
//        tv.setText("Zobryyyy");
//        ll.addView(tv);
        getData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sport_detail_menu, menu);
        return true;
    }

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
