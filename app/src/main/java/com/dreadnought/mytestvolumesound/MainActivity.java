package com.dreadnought.mytestvolumesound;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView textView;
    private SeekBar seekBar;
    private ImageButton imageButton;
    private boolean play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = false;
        textView = findViewById(R.id.textView);
        textView.setText("Volume : 10");
        mediaPlayer = MediaPlayer.create(this, R.raw.happy);
        mediaPlayer.setVolume(1,1);
        seekBar = findViewById(R.id.seekBar);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!play){
                    mediaPlayer.start();
                    imageButton.setImageResource(R.drawable.ic_pause);
                    play = true;
                }else{
                    imageButton.setImageResource(R.drawable.ic_play);
                    mediaPlayer.pause();
                    play = false;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Volume : " + (int)(roundVolume(progress)*0.1));
                mediaPlayer.setVolume((float)(roundVolume(progress)*0.01),(float)(roundVolume(progress)*0.01));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private int roundVolume(int progress){
        if (progress<10){
            return 10;
        }else if(progress<20){
            return 20;
        }else if (progress<30){
            return 30;
        }else if (progress<40){
            return 40;
        }else if (progress<50){
            return 50;
        }else if (progress<60){
            return 60;
        }else if (progress<70){
            return 70;
        }else if (progress<80){
            return 80;
        }else if (progress<90){
            return 90;
        }else {
            return 100;
        }
    }
}
