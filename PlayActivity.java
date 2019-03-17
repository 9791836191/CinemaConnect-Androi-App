
package com.example.rishi.moviedb;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private RadioGroup language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        language.findViewById(R.id.lang);
    }

    public void StartPlay(View view) {
        mediaPlayer=MediaPlayer.create(this,R.raw.sound_first);
        if(language.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Select a Language", Toast.LENGTH_SHORT).show();
        }
        else{
            mediaPlayer.start();
        }
    }

    public void StopPlay(View view) {
        mediaPlayer.stop();
    }
}
