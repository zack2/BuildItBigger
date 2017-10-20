package cg.zack_olivier.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ZackJokes;

import cg.zack_olivier.gradle.zackandroiddisplayjokes.DisplayJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static final String EXTRA_JOKE = "cg.zack_olivier.build.joke";
    // my java library
    ZackJokes zackJokes;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        zackJokes = new ZackJokes();

        Button btnJoke = root.findViewById(R.id.btn_show_joke);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getActivity(), zackJokes.getZackJoke(),Toast.LENGTH_LONG).show();
                new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {

                    @Override
                    public void onJokeLoaded(String joke) {
                        Intent intent = new Intent(getContext(), DisplayJokeActivity.class);
                        intent.putExtra(DisplayJokeActivity.EXTRA_JOKE, joke);
                        startActivity(intent);
                    }
                }).execute();

            }
        });
        return root;
    }


}
