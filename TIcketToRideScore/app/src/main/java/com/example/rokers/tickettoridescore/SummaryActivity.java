package com.example.rokers.tickettoridescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        String winner = extras.getString("WINNER");
        String resultPlayerA = extras.getString("RESULTPLAYERA");
        String resultPlayerB = extras.getString("RESULTPLAYERB");
        String pointAPlayerA = extras.getString("POINTAPLAYERA");
        String pointAPlayerB = extras.getString("POINTAPLAYERB");
        String pointBPlayerA = extras.getString("POINTBPLAYERA");
        String pointBPlayerB = extras.getString("POINTBPLAYERB");
        String pointCPlayerA = extras.getString("POINTCPLAYERA");
        String pointCPlayerB = extras.getString("POINTCPLAYERB");
        String pointDPlayerA = extras.getString("POINTDPLAYERA");
        String pointDPlayerB = extras.getString("POINTDPLAYERB");

        TextView winnerPlayer = (TextView) findViewById(R.id.tv_summaryWinnerName);
        winnerPlayer.setText(winner);
        TextView compareResults = (TextView) findViewById(R.id.tv_summaryCompareResults);
        compareResults.setText(resultPlayerA + " to " + resultPlayerB);
        TextView compareResultsPointA = (TextView) findViewById(R.id.tv_summaryPointsPartA);
        compareResultsPointA.setText(pointAPlayerA + " to " + pointAPlayerB);
        TextView compareResultsPointB = (TextView) findViewById(R.id.tv_summaryPointsPartB);
        compareResultsPointB.setText(pointBPlayerA + " to " + pointBPlayerB);
        TextView compareResultsPointC = (TextView) findViewById(R.id.tv_summaryPointsPartC);
        compareResultsPointC.setText(pointCPlayerA + " to " + pointCPlayerB);
        TextView compareResultsPointD = (TextView) findViewById(R.id.tv_summaryPointsPartD);
        compareResultsPointD.setText(pointDPlayerA + " to " + pointDPlayerB);
        TextView compareResultsAgain = (TextView) findViewById(R.id.tv_summaryPointsTotal);
        compareResultsAgain.setText(resultPlayerA + " to " + resultPlayerB);

    }

    public void backToEnterName(View view) {
        Intent intent = new Intent(this, PlayerNameActivity.class);
        intent.putExtra("def", "dd");
        startActivity(intent);
    }
}
