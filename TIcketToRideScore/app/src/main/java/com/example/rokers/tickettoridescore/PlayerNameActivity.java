package com.example.rokers.tickettoridescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.message;

public class PlayerNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
    }
    public void sendPlayersNames(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        EditText nameOfPlayerA=(EditText) findViewById(R.id.et_playerAName);
        EditText nameOfPlayerB=(EditText) findViewById(R.id.et_playerBName);

        String namePlayerA=nameOfPlayerA.getText().toString();
        String namePlayerB=nameOfPlayerB.getText().toString();

        intent.putExtra("PLAYERANAME",namePlayerA);
        intent.putExtra("PLAYERBNAME",namePlayerB);
        startActivity(intent);

    }

}
