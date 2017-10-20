package cg.zack_olivier.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ZackJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }


}
