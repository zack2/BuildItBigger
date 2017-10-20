package cg.zack_olivier.gradle.zackandroiddisplayjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class DisplayJokeActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "cg.zack_olivier.build.joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        if(getIntent() != null && getIntent().hasExtra(EXTRA_JOKE)) {
            String joke = getIntent().getStringExtra(EXTRA_JOKE);

            TextView textViewJoke = (TextView) findViewById(R.id.title_joke);
            textViewJoke.setText(joke);
        }


    }
}
