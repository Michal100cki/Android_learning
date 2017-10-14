package com.example.rokers.tickettoridescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/**
 * code below is support for intent which is responsible for players name.
 */
        Bundle extras = getIntent().getExtras();
        String nameA = extras.getString("PLAYERANAME");
        String nameB = extras.getString("PLAYERBNAME");

        TextView namePlayerA = (TextView) findViewById(R.id.tv_namePlayerA);
        namePlayerA.setText(nameA);

        TextView namePlayerB = (TextView) findViewById(R.id.tv_playerBNamePlayer);
        namePlayerB.setText(nameB);

/**
 * array variables which are connected with Views spinners for the both players.
 */
        Integer[] numberOfOneTrucksTrains = {0, 1, 2, 3};
        Integer[] numberOfTwoTrucksTrains = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        Integer[] numberOfThreeTrucksTrains = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] numberOfFourTrucksTrains = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer[] numberOfSixTrucksTrains = {0, 1, 2};
        Integer[] numberOfEightTrucksTrain = {0, 1};
/**
 * Code which is connected with PlayerA result.
 */
        ArrayAdapter adapterOne = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfOneTrucksTrains);
        final Spinner spinnerOne = (Spinner) findViewById(R.id.spinnerOne);

        spinnerOne.setAdapter(adapterOne);

        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                oneTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /**
         * Block of code dedicated to count points for two vehicals trains (3 points for each train)
         */
        ArrayAdapter adapterTwo = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfTwoTrucksTrains);
        final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinnerTwo);

        spinnerTwo.setAdapter(adapterTwo);

        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                twoTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /**
         * part of code dedicated to count points for three vehicals trains (4 points for each train)
         */
        ArrayAdapter adapterThree = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfThreeTrucksTrains);
        final Spinner spinnerThree = (Spinner) findViewById(R.id.spinnerThree);

        spinnerThree.setAdapter(adapterThree);

        spinnerThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                threeTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterFour = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfFourTrucksTrains);
        final Spinner spinnerFour = (Spinner) findViewById(R.id.spinnerFour);

        spinnerFour.setAdapter(adapterFour);

        spinnerFour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fourTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterSix = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfSixTrucksTrains);
        final Spinner spinnerSix = (Spinner) findViewById(R.id.spinnerSix);
        spinnerSix.setAdapter(adapterSix);

        spinnerSix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sixTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterEight = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfEightTrucksTrain);
        final Spinner spinnerEight = (Spinner) findViewById(R.id.spinnerEight);
        spinnerEight.setAdapter(adapterEight);

        spinnerEight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                eightTrainsResult(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResult()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /**
         * code below is connected with counting and displaying points for finished / unfinished five points routes (tickets)
         */
        Button finishedFiveRoutes = (Button) findViewById(R.id.btn_fiveFinished);
        finishedFiveRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedFiveRoutes = (TextView) findViewById(R.id.tv_routesFiveFinished);
                finishedFiveRoutes.setText(String.valueOf(increaseFinishedFiveRoutes()));

                TextView sumOfPointsForFiveRoutes = (TextView) findViewById(R.id.tv_fiveTotal);
                sumOfPointsForFiveRoutes.setText(String.valueOf(pointsForRoutes(startFiveFinished, startFiveUnfinished, pointsForFiveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedFiveRoutes = (Button) findViewById(R.id.btn_fiveUnfinished);
        unfinishedFiveRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedFiveRoutes = (TextView) findViewById(R.id.tv_routesFiveUnfinished);
                unfinishedFiveRoutes.setText(String.valueOf(increaseUnfinishedFiveRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_fiveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startFiveFinished, startFiveUnfinished, pointsForFiveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        /**
         * code below is connected with counting and displaying points for finished / unfinished SIX points routes (tickets)
         */
        Button finishedSixRoutes = (Button) findViewById(R.id.btn_sixFinished);
        finishedSixRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesSixFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedSixRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_sixTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSixFinished, startSixUnfinished, pointsForSixRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedSixRoutes = (Button) findViewById(R.id.btn_sixUnfinished);
        unfinishedSixRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesSixUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedSixRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_sixTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSixFinished, startSixUnfinished, pointsForSixRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        /**
         * code below is connected with counting and displaying points for finished / unfinished SEVEN points routes (tickets)
         */
        Button finishedSevenRoutes = (Button) findViewById(R.id.btn_sevenFinished);
        finishedSevenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesSevenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedSevenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_sevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSevenFinished, startSevenUnfinished, pointsForSevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedSevenRoutes = (Button) findViewById(R.id.btn_sevenUnfinished);
        unfinishedSevenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesSevenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedSevenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_sevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSevenFinished, startSevenUnfinished, pointsForSevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button finishedEightRoutes = (Button) findViewById(R.id.btn_eightFinished);
        finishedEightRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesEightFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedEightRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_eightTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startEightFinished, startEightUnfinished, pointsForEightRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedEightRoutes = (Button) findViewById(R.id.btn_eightUnfinished);
        unfinishedEightRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesEightUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedEightRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_eightTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startEightFinished, startEightUnfinished, pointsForEightRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button finishedNineRoutes = (Button) findViewById(R.id.btn_nineFinished);
        finishedNineRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesNineFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedNineRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_nineTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startNineFinished, startNineUnfinished, pointsForNineRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedNineRoutes = (Button) findViewById(R.id.btn_nineUnfinished);
        unfinishedNineRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesNineUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedNineRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_nineTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startNineFinished, startNineUnfinished, pointsForNineRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });
        Button finishedTenRoutes = (Button) findViewById(R.id.btn_tenFinished);
        finishedTenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesTenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedTenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_tenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTenFinished, startTenUnfinished, pointsForTenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedTenRoutes = (Button) findViewById(R.id.btn_tenUnfinished);
        unfinishedTenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesTenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedTenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_tenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTenFinished, startTenUnfinished, pointsForTenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });
        Button finishedElevenRoutes = (Button) findViewById(R.id.btn_elevenFinished);
        finishedElevenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesElevenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedElevenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_elevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startElevenFinished, startElevenUnfinished, pointsForElevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedElevenRoutes = (Button) findViewById(R.id.btn_elevenUnfinished);
        unfinishedElevenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesElevenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedElevenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_elevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startElevenFinished, startElevenUnfinished, pointsForElevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button finishedTwelveRoutes = (Button) findViewById(R.id.btn_twelveFinished);
        finishedTwelveRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesTwelveFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedTwelveRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_twelveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTwelveFinished, startTwelveUnfinished, pointsForTwelveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedTwelveRoutes = (Button) findViewById(R.id.btn_twelveUnfinished);
        unfinishedTwelveRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesTwelveUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedTwelveRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_twelveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTwelveFinished, startTwelveUnfinished, pointsForTwelveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });
        Button finishedThirteenRoutes = (Button) findViewById(R.id.btn_thirteenFinished);
        finishedThirteenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routesThirteenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedThirteenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_thirteenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startThirteenFinished, startThirteenUnfinished, pointsForThirteenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinishedThirteenRoutes = (Button) findViewById(R.id.btn_thirteenUnfinished);
        unfinishedThirteenRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routesThirteenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedThirteenRoutes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_thirteenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startThirteenFinished, startThirteenUnfinished, pointsForThirteenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });
        final Button finished20Routes = (Button) findViewById(R.id.btn_20Finished);
        finished20Routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routes20Finished);
                finishedRoutes.setText(String.valueOf(increaseFinished20Routes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_20Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start20Finished, start20Unfinished, pointsFor20Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinished20Routes = (Button) findViewById(R.id.btn_20Unfinished);
        unfinished20Routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routes20Unfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinished20Routes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_20Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start20Finished, start20Unfinished, pointsFor20Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button finished21Routes = (Button) findViewById(R.id.btn_21Finished);
        finished21Routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_routes21Finished);
                finishedRoutes.setText(String.valueOf(increaseFinished21Routes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_21Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start21Finished, start21Unfinished, pointsFor21Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });

        Button unfinished21Routes = (Button) findViewById(R.id.btn_21Unfinished);
        unfinished21Routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_routes21Unfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinished21Routes()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_21Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start21Finished, start21Unfinished, pointsFor21Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutes()));
            }
        });


        /**
         * code below is connected with displaying and counting result for part of game 'Used Train Station'
         */
        Button usedStation = (Button) findViewById(R.id.btn_usedTrainStations);
        usedStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numbersOfUseStation = (TextView) findViewById(R.id.tv_usedTrainStations);
                numbersOfUseStation.setText(String.valueOf(increaseUsingStation()));

                TextView pointsForUnusedStation = (TextView) findViewById(R.id.tv_pointsForTrainStations);
                pointsForUnusedStation.setText(String.valueOf(resultUsedStations()));
            }
        });
        Button totalResult = (Button) findViewById(R.id.btn_totalPoints);
        totalResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView totalResult = (TextView) findViewById(R.id.tv_totalPoints);
                totalResult.setText(String.valueOf(totalResult()));

                TextView playerBTotalResult = (TextView) findViewById(R.id.tv_playerBTotalPoints);
                playerBTotalResult.setText(String.valueOf(totalResultPlayerB()));

                sendSummary(totalResult);
            }
        });
/**
 * Here starts code which is connected with PlayerB result. It is analogy to code for Player A.
 */
        ArrayAdapter adapterOnePlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfOneTrucksTrains);
        final Spinner spinnerOnePlayerB = (Spinner) findViewById(R.id.playerBSpinnerOne);

        spinnerOnePlayerB.setAdapter(adapterOnePlayerB);

        spinnerOnePlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                oneTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /**
         * Block of code dedicated to count points for two vehicals trains (3 points for each train)
         */
        ArrayAdapter adapterTwoPlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfTwoTrucksTrains);
        final Spinner spinnerTwoPlayerB = (Spinner) findViewById(R.id.playerBSpinnerTwo);

        spinnerTwoPlayerB.setAdapter(adapterTwoPlayerB);

        spinnerTwoPlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                twoTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
/**
 * part of code dedicated to count points for three vehicals trains (4 points for each train)
 */
        ArrayAdapter adapterThreePlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfThreeTrucksTrains);
        final Spinner spinnerThreePlayerB = (Spinner) findViewById(R.id.playerBSpinnerThree);

        spinnerThreePlayerB.setAdapter(adapterThreePlayerB);

        spinnerThreePlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                threeTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterFourPlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfFourTrucksTrains);
        final Spinner spinnerFourPlayerB = (Spinner) findViewById(R.id.playerBSpinnerFour);

        spinnerFourPlayerB.setAdapter(adapterFourPlayerB);

        spinnerFourPlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fourTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterSixPlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfSixTrucksTrains);
        final Spinner spinnerSixPlayerB = (Spinner) findViewById(R.id.playerBSpinnerSix);
        spinnerSixPlayerB.setAdapter(adapterSixPlayerB);

        spinnerSixPlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sixTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapterEightPlayerB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, numberOfEightTrucksTrain);
        final Spinner spinnerEightPlayerB = (Spinner) findViewById(R.id.playerBSpinnerEight);
        spinnerEightPlayerB.setAdapter(adapterEightPlayerB);

        spinnerEightPlayerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                eightTrainsResultPlayerB(i);

                TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
                totalPointsForTrains.setText(String.valueOf(totalTrainResultPlayerB()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /**
         * PLAYERB -> code below is connected with counting and displaying points for finished / unfinished five points routes (tickets)
         */
        Button finishedFiveRoutesPlayerB = (Button) findViewById(R.id.btn_playerBFiveFinished);
        finishedFiveRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedFiveRoutes = (TextView) findViewById(R.id.tv_playerBRoutesFiveFinished);
                finishedFiveRoutes.setText(String.valueOf(increaseFinishedFiveRoutesPlayerB()));

                TextView sumOfPointsForFiveRoutes = (TextView) findViewById(R.id.tv_playerBFiveTotal);
                sumOfPointsForFiveRoutes.setText(String.valueOf(pointsForRoutes(startFiveFinishedPlayerB, startFiveUnfinishedPlayerB, pointsForFiveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedFiveRoutesPlayerB = (Button) findViewById(R.id.btn_playerBFiveUnfinished);
        unfinishedFiveRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedFiveRoutes = (TextView) findViewById(R.id.tv_playerBRoutesFiveUnfinished);
                unfinishedFiveRoutes.setText(String.valueOf(increaseUnfinishedFiveRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBFiveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startFiveFinishedPlayerB, startFiveUnfinishedPlayerB, pointsForFiveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        /**
         * code below is connected with counting and displaying points for finished / unfinished SIX points routes (tickets)
         */
        Button finishedSixRoutesPlayerB = (Button) findViewById(R.id.btn_playerBSixFinished);
        finishedSixRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesSixFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedSixRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBSixTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSixFinishedPlayerB, startSixUnfinishedPlayerB, pointsForSixRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedSixRoutesPlayerB = (Button) findViewById(R.id.btn_playerBSixUnfinished);
        unfinishedSixRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesSixUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedSixRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBSixTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSixFinishedPlayerB, startSixUnfinishedPlayerB, pointsForSixRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        /**
         * code below is connected with counting and displaying points for finished / unfinished SEVEN points routes (tickets)
         */
        Button finishedSevenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBSevenFinished);
        finishedSevenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesSevenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedSevenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBSevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSevenFinishedPlayerB, startSevenUnfinishedPlayerB, pointsForSevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedSevenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBSevenUnfinished);
        unfinishedSevenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesSevenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedSevenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBSevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startSevenFinishedPlayerB, startSevenUnfinishedPlayerB, pointsForSevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button finishedEightRoutesPlayerB = (Button) findViewById(R.id.btn_playerBEightFinished);
        finishedEightRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesEightFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedEightRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBEightTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startEightFinishedPlayerB, startEightUnfinishedPlayerB, pointsForEightRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedEightRoutesPlayerB = (Button) findViewById(R.id.btn_playerBEightUnfinished);
        unfinishedEightRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesEightUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedEightRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBEightTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startEightFinishedPlayerB, startEightUnfinishedPlayerB, pointsForEightRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button finishedNineRoutesPlayerB = (Button) findViewById(R.id.btn_playerBNineFinished);
        finishedNineRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesNineFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedNineRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBNineTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startNineFinishedPlayerB, startNineUnfinishedPlayerB, pointsForNineRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedNineRoutesPlayerB = (Button) findViewById(R.id.btn_playerBNineUnfinished);
        unfinishedNineRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesNineUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedNineRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBNineTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startNineFinishedPlayerB, startNineUnfinishedPlayerB, pointsForNineRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });
        Button finishedTenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBTenFinished);
        finishedTenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesTenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedTenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBTenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTenFinishedPlayerB, startTenUnfinishedPlayerB, pointsForTenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedTenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBTenUnfinished);
        unfinishedTenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesTenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedTenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBTenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTenFinishedPlayerB, startTenUnfinishedPlayerB, pointsForTenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });
        Button finishedElevenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBElevenFinished);
        finishedElevenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesElevenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedElevenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBElevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startElevenFinishedPlayerB, startElevenUnfinishedPlayerB, pointsForElevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedElevenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBElevenUnfinished);
        unfinishedElevenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesElevenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedElevenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBElevenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startElevenFinishedPlayerB, startElevenUnfinishedPlayerB, pointsForElevenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button finishedTwelveRoutesPlayerB = (Button) findViewById(R.id.btn_playerBTwelveFinished);
        finishedTwelveRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesTwelveFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedTwelveRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBTwelveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTwelveFinishedPlayerB, startTwelveUnfinishedPlayerB, pointsForTwelveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedTwelveRoutesPlayerB = (Button) findViewById(R.id.btn_playerBTwelveUnfinished);
        unfinishedTwelveRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesTwelveUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedTwelveRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBTwelveTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startTwelveFinishedPlayerB, startTwelveUnfinishedPlayerB, pointsForTwelveRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });
        Button finishedThirteenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBThirteenFinished);
        finishedThirteenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesThirteenFinished);
                finishedRoutes.setText(String.valueOf(increaseFinishedThirteenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBThirteenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startThirteenFinishedPlayerB, startThirteenUnfinishedPlayerB, pointsForThirteenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinishedThirteenRoutesPlayerB = (Button) findViewById(R.id.btn_playerBThirteenUnfinished);
        unfinishedThirteenRoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutesThirteenUnfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinishedThirteenRoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerBThirteenTotal);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(startThirteenFinishedPlayerB, startThirteenUnfinishedPlayerB, pointsForThirteenRoute)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });
        final Button finished20RoutesPlayerB = (Button) findViewById(R.id.btn_playerB20Finished);
        finished20RoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutes20Finished);
                finishedRoutes.setText(String.valueOf(increaseFinished20RoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerB20Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start20FinishedPlayerB, start20UnfinishedPlayerB, pointsFor20Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinished20RoutesPlayerB = (Button) findViewById(R.id.btn_playerB20Unfinished);
        unfinished20RoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutes20Unfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinished20RoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerB20Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start20FinishedPlayerB, start20UnfinishedPlayerB, pointsFor20Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button finished21RoutesPlayerB = (Button) findViewById(R.id.btn_playerB21Finished);
        finished21RoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView finishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutes21Finished);
                finishedRoutes.setText(String.valueOf(increaseFinished21RoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerB21Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start21FinishedPlayerB, start21UnfinishedPlayerB, pointsFor21Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });

        Button unfinished21RoutesPlayerB = (Button) findViewById(R.id.btn_playerB21Unfinished);
        unfinished21RoutesPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView unfinishedRoutes = (TextView) findViewById(R.id.tv_playerBRoutes21Unfinished);
                unfinishedRoutes.setText(String.valueOf(increaseUnfinished21RoutesPlayerB()));

                TextView sumOfPointsForRoutes = (TextView) findViewById(R.id.tv_playerB21Total);
                sumOfPointsForRoutes.setText(String.valueOf(pointsForRoutes(start21FinishedPlayerB, start21UnfinishedPlayerB, pointsFor21Route)));

                TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
                totalPointsForRoutes.setText(String.valueOf(totalPointsForRoutesPlayerB()));
            }
        });


        /**
         * Used Train Station
         */
        Button usedStationPlayerB = (Button) findViewById(R.id.btn_playerBUsedTrainStations);
        usedStationPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView numbersOfUseStation = (TextView) findViewById(R.id.tv_playerBUsedTrainStations);
                numbersOfUseStation.setText(String.valueOf(increaseUsingStation()));

                TextView pointsForUnusedStation = (TextView) findViewById(R.id.tv_playerBPointsForTrainStations);
                pointsForUnusedStation.setText(String.valueOf(resultUsedStations()));
            }
        });
    }

    /**
     * code below is service resposible for intent with info about winner
     *
     * @param view
     */
    public void sendSummary(View view) {
        Intent intentWinner = new Intent(this, SummaryActivity.class);
        TextView resultPlayerA = (TextView) findViewById(R.id.tv_totalPoints);
        TextView resultPlayerB = (TextView) findViewById(R.id.tv_playerBTotalPoints);
        TextView resultPointAPlayerA = (TextView) findViewById(R.id.tv_totalTrains);
        TextView resultPointAPlayerB = (TextView) findViewById(R.id.tv_playerBTotalPoints);
        TextView resultPointBPlayerA = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
        TextView resultPointBPlayerB = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
        TextView resultPointCPlayerA = (TextView) findViewById(R.id.tv_pointsForTrainStations);
        TextView resultPointCPlayerB = (TextView) findViewById(R.id.tv_playerBPointsForTrainStations);
        TextView resultPointDPlayerA = (TextView) findViewById(R.id.tv_pointsForTheLongTrack);
        TextView resultPointDPlayerB = (TextView) findViewById(R.id.tv_playerBPointsForTheLongTrack);

        String winner = winner();
        String playerAResult = resultPlayerA.getText().toString();
        String playerBResult = resultPlayerB.getText().toString();
        String playerAPointA = resultPointAPlayerA.getText().toString();
        String playerBPointA = resultPointAPlayerB.getText().toString();
        String playerAPointB = resultPointBPlayerA.getText().toString();
        String playerBPointB = resultPointBPlayerB.getText().toString();
        String playerAPointC = resultPointCPlayerA.getText().toString();
        String playerBPointC = resultPointCPlayerB.getText().toString();
        String playerAPointD = resultPointDPlayerA.getText().toString();
        String playerBPointD = resultPointDPlayerB.getText().toString();

        intentWinner.putExtra("WINNER", winner);
        intentWinner.putExtra("RESULTPLAYERA", playerAResult);
        intentWinner.putExtra("RESULTPLAYERB", playerBResult);

        intentWinner.putExtra("POINTAPLAYERA", playerAPointA);
        intentWinner.putExtra("POINTAPLAYERB", playerBPointA);

        intentWinner.putExtra("POINTBPLAYERA", playerAPointB);
        intentWinner.putExtra("POINTBPLAYERB", playerBPointB);

        intentWinner.putExtra("POINTCPLAYERA", playerAPointC);
        intentWinner.putExtra("POINTCPLAYERB", playerBPointC);

        intentWinner.putExtra("POINTDPLAYERA", playerAPointD);
        intentWinner.putExtra("POINTDPLAYERB", playerBPointD);

        startActivity(intentWinner);
    }


    /**
     * code below checked who win the game
     *
     * @return String variable with winner name
     */
    public String winner() {
        TextView playerA = (TextView) findViewById(R.id.tv_namePlayerA);
        TextView playerB = (TextView) findViewById(R.id.tv_playerBNamePlayer);
        String winner;
        if (totalResult() > totalResultPlayerB()) {
            winner = playerA.getText().toString();

        } else if (totalResult() < totalResultPlayerB()) {
            winner = playerB.getText().toString();
        } else {
            winner = "DRAW - You have to play again to settle who's the champion :)";
        }
        return winner;
    }

    /**
     * @param view using to checked and count points for the player who built the longest track at the end of game
     */
    public void pointsForTheLongestTrack(View view) {
        int pointForLongestTrack;
        CheckBox chbLongTrack = (CheckBox) findViewById(R.id.chb_longTrack);
        chbLongTrack.setEnabled(true);

        CheckBox chbLongTrackPlayerB = (CheckBox) findViewById(R.id.chb_playerBLongTrack);
        chbLongTrackPlayerB.setEnabled(true);

        boolean checked = ((CheckBox) view).isChecked();

        TextView longTrack = (TextView) findViewById(R.id.tv_pointsForTheLongTrack);
        TextView longTrackPlayerB = (TextView) findViewById(R.id.tv_playerBPointsForTheLongTrack);

        if (chbLongTrack.isChecked()) {
            switch (view.getId()) {
                case R.id.chb_longTrack:
                    if (checked) {
                        pointForLongestTrack = 10;
                        longTrack.setText(String.valueOf(pointForLongestTrack));
                        chbLongTrackPlayerB.setEnabled(false);
                        longTrackPlayerB.setText("0");
                        Toast.makeText(this, "Remember that the competition on the longest track at the end of game can win only one player./n" +
                                "That's why your rival has unable the checkbox now.", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        pointForLongestTrack = 0;
                        longTrack.setText(String.valueOf(pointForLongestTrack));
                    }
                    break;
            }
        } else if (chbLongTrackPlayerB.isChecked()) {
            switch (view.getId()) {
                case R.id.chb_playerBLongTrack:
                    if (checked) {
                        pointForLongestTrack = 10;
                        longTrackPlayerB.setText(String.valueOf(pointForLongestTrack));
                        chbLongTrack.setEnabled(false);
                        longTrack.setText("0");
                        Toast.makeText(this, "Remember that the competition on the longest track at the end of game can win only one player./n" +
                                "That's why your rival has unable the checkbox now.", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        pointForLongestTrack = 0;
                        longTrackPlayerB.setText(String.valueOf(pointForLongestTrack));
                    }
                    break;
            }

        }
    }

    /**
     * variabels below (numberPOints...) are information how many points player get trains
     */
    int numberPointForOneVehTrain = 1;
    int numberPointForTwoVehTrain = 2;
    int numberPointForThreeVehTrain = 4;
    int numberPointForFourVehTrain = 7;
    int numberPointForSixVehTrain = 15;
    int numberPointForEightVehTrain = 21;
    int total = 0;
    int totalPlayerB = 0;


    /**
     * @return amount points for built train by playerB (part A of summary)
     */

    public int totalTrainResult() {
        TextView oneTruckTrain = (TextView) findViewById(R.id.tv_points_one);
        String a = oneTruckTrain.getText().toString();
        TextView twoTruckTrain = (TextView) findViewById(R.id.tv_points_two);
        String b = twoTruckTrain.getText().toString();
        TextView threeTruckTrain = (TextView) findViewById(R.id.tv_points_three);
        String c = threeTruckTrain.getText().toString();
        TextView fourTruckTrain = (TextView) findViewById(R.id.tv_points_four);
        String d = fourTruckTrain.getText().toString();
        TextView sixTruckTrain = (TextView) findViewById(R.id.tv_points_six);
        String e = sixTruckTrain.getText().toString();
        TextView eightTruckTrain = (TextView) findViewById(R.id.tv_points_eight);
        String f = eightTruckTrain.getText().toString();

        int totalTrains = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d) + Integer.parseInt(e) + Integer.parseInt(f);
        return totalTrains;

    }

    /**
     * @return amount points for built train by playerB (part A of summary)
     */
    public int totalTrainResultPlayerB() {
        TextView oneTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_one);
        String a = oneTruckTrain.getText().toString();
        TextView twoTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_two);
        String b = twoTruckTrain.getText().toString();
        TextView threeTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_three);
        String c = threeTruckTrain.getText().toString();
        TextView fourTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_four);
        String d = fourTruckTrain.getText().toString();
        TextView sixTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_six);
        String e = sixTruckTrain.getText().toString();
        TextView eightTruckTrain = (TextView) findViewById(R.id.tv_playerBPoints_eight);
        String f = eightTruckTrain.getText().toString();

        int totalTrains = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d) + Integer.parseInt(e) + Integer.parseInt(f);
        return totalTrains;

    }

    /**
     * ALl methods below (...TrainsResult) are using to count and display how many points player get for finished trains.
     *
     * @param score
     * @return
     */
    public int oneTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_one);
        result.setText(String.valueOf(score * numberPointForOneVehTrain));
        total = total + score;
        return score;
    }

    public int twoTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_two);
        result.setText(String.valueOf(score * numberPointForTwoVehTrain));
        total = total + score * numberPointForTwoVehTrain;
        return score;
    }

    public int threeTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_three);
        result.setText(String.valueOf(score * numberPointForThreeVehTrain));
        total = total + score * numberPointForThreeVehTrain;
        return score;
    }

    public int fourTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_four);
        result.setText(String.valueOf(score * numberPointForFourVehTrain));
        total = total + score;
        return score;
    }

    public int sixTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_six);
        result.setText(String.valueOf(score * numberPointForSixVehTrain));
        total = total + score;
        return score;
    }

    public int eightTrainsResult(int score) {
        TextView result = (TextView) findViewById(R.id.tv_points_eight);
        result.setText(String.valueOf(score * numberPointForEightVehTrain));
        total = total + score;
        return score;
    }

    public int oneTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_one);
        result.setText(String.valueOf(score * numberPointForOneVehTrain));
        total = total + score;
        return score;
    }

    public int twoTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_two);
        result.setText(String.valueOf(score * numberPointForTwoVehTrain));
        total = total + score * numberPointForTwoVehTrain;
        return score;
    }

    public int threeTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_three);
        result.setText(String.valueOf(score * numberPointForThreeVehTrain));
        total = total + score * numberPointForThreeVehTrain;
        return score;
    }

    public int fourTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_four);
        result.setText(String.valueOf(score * numberPointForFourVehTrain));
        total = total + score;
        return score;
    }

    public int sixTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_six);
        result.setText(String.valueOf(score * numberPointForSixVehTrain));
        total = total + score;
        return score;
    }

    public int eightTrainsResultPlayerB(int score) {
        TextView result = (TextView) findViewById(R.id.tv_playerBPoints_eight);
        result.setText(String.valueOf(score * numberPointForEightVehTrain));
        total = total + score;
        return score;
    }

    /**
     * Routes
     */

    int startFiveFinished = 0;
    int startFiveUnfinished = 0;
    int startFiveFinishedPlayerB = 0;
    int startFiveUnfinishedPlayerB = 0;
    int pointsForFiveRoute = 5;

    int startSixFinished = 0;
    int startSixUnfinished = 0;
    int startSixFinishedPlayerB = 0;
    int startSixUnfinishedPlayerB = 0;
    int pointsForSixRoute = 6;

    int startSevenFinished = 0;
    int startSevenUnfinished = 0;
    int startSevenFinishedPlayerB = 0;
    int startSevenUnfinishedPlayerB = 0;
    int pointsForSevenRoute = 7;

    int startEightFinished = 0;
    int startEightUnfinished = 0;
    int startEightFinishedPlayerB = 0;
    int startEightUnfinishedPlayerB = 0;
    int pointsForEightRoute = 8;

    int startNineFinished = 0;
    int startNineUnfinished = 0;
    int startNineFinishedPlayerB = 0;
    int startNineUnfinishedPlayerB = 0;
    int pointsForNineRoute = 9;

    int startTenFinished = 0;
    int startTenUnfinished = 0;
    int startTenFinishedPlayerB = 0;
    int startTenUnfinishedPlayerB = 0;
    int pointsForTenRoute = 10;

    int startElevenFinished = 0;
    int startElevenUnfinished = 0;
    int startElevenFinishedPlayerB = 0;
    int startElevenUnfinishedPlayerB = 0;
    int pointsForElevenRoute = 11;

    int startTwelveFinished = 0;
    int startTwelveUnfinished = 0;
    int startTwelveFinishedPlayerB = 0;
    int startTwelveUnfinishedPlayerB = 0;
    int pointsForTwelveRoute = 12;

    int startThirteenFinished = 0;
    int startThirteenUnfinished = 0;
    int startThirteenFinishedPlayerB = 0;
    int startThirteenUnfinishedPlayerB = 0;
    int pointsForThirteenRoute = 13;

    int start20Finished = 0;
    int start20Unfinished = 0;
    int start20FinishedPlayerB = 0;
    int start20UnfinishedPlayerB = 0;
    int pointsFor20Route = 20;

    int start21Finished = 0;
    int start21Unfinished = 0;
    int start21FinishedPlayerB = 0;
    int start21UnfinishedPlayerB = 0;
    int pointsFor21Route = 21;

    public int increaseFinishedFiveRoutes() {
        startFiveFinished += 1;
        return startFiveFinished;
    }

    public int increaseUnfinishedFiveRoutes() {
        startFiveUnfinished += 1;
        return startFiveUnfinished;
    }

    public int increaseFinishedSixRoutes() {
        startSixFinished += 1;
        return startSixFinished;
    }

    public int increaseUnfinishedSixRoutes() {
        startSixUnfinished += 1;
        return startSixUnfinished;
    }

    public int increaseFinishedSevenRoutes() {
        startSevenFinished += 1;
        return startSevenFinished;
    }

    public int increaseUnfinishedSevenRoutes() {
        startSevenUnfinished += 1;
        return startSevenUnfinished;
    }

    public int increaseFinishedEightRoutes() {
        startEightFinished += 1;
        return startEightFinished;
    }

    public int increaseUnfinishedEightRoutes() {
        startEightUnfinished += 1;
        return startEightUnfinished;
    }

    public int increaseFinishedNineRoutes() {
        startNineFinished += 1;
        return startNineFinished;
    }

    public int increaseUnfinishedNineRoutes() {
        startNineUnfinished += 1;
        return startNineUnfinished;
    }

    public int increaseFinishedTenRoutes() {
        startTenFinished += 1;
        return startTenFinished;
    }

    public int increaseUnfinishedTenRoutes() {
        startTenUnfinished += 1;
        return startTenUnfinished;
    }

    public int increaseFinishedElevenRoutes() {
        startElevenFinished += 1;
        return startElevenFinished;
    }

    public int increaseUnfinishedElevenRoutes() {
        startElevenUnfinished += 1;
        return startElevenUnfinished;
    }

    public int increaseFinishedTwelveRoutes() {
        startTwelveFinished += 1;
        return startTwelveFinished;
    }

    public int increaseUnfinishedTwelveRoutes() {
        startTwelveUnfinished += 1;
        return startTwelveUnfinished;
    }

    public int increaseFinishedThirteenRoutes() {
        startThirteenFinished += 1;
        return startThirteenFinished;
    }

    public int increaseUnfinishedThirteenRoutes() {
        startThirteenUnfinished += 1;
        return startThirteenUnfinished;
    }

    public int increaseFinished20Routes() {
        start20Finished += 1;
        return start20Finished;
    }

    public int increaseUnfinished20Routes() {
        start20Unfinished += 1;
        return start20Unfinished;
    }

    public int increaseFinished21Routes() {
        start21Finished += 1;
        return start21Finished;
    }

    public int increaseUnfinished21Routes() {
        start21Unfinished += 1;
        return start21Unfinished;
    }

    public int increaseFinishedFiveRoutesPlayerB() {
        startFiveFinishedPlayerB += 1;
        return startFiveFinishedPlayerB;
    }

    public int increaseUnfinishedFiveRoutesPlayerB() {
        startFiveUnfinishedPlayerB += 1;
        return startFiveUnfinishedPlayerB;
    }

    public int increaseFinishedSixRoutesPlayerB() {
        startSixFinishedPlayerB += 1;
        return startSixFinishedPlayerB;
    }

    public int increaseUnfinishedSixRoutesPlayerB() {
        startSixUnfinishedPlayerB += 1;
        return startSixUnfinishedPlayerB;
    }

    public int increaseFinishedSevenRoutesPlayerB() {
        startSevenFinishedPlayerB += 1;
        return startSevenFinishedPlayerB;
    }

    public int increaseUnfinishedSevenRoutesPlayerB() {
        startSevenUnfinishedPlayerB += 1;
        return startSevenUnfinishedPlayerB;
    }

    public int increaseFinishedEightRoutesPlayerB() {
        startEightFinishedPlayerB += 1;
        return startEightFinishedPlayerB;
    }

    public int increaseUnfinishedEightRoutesPlayerB() {
        startEightUnfinishedPlayerB += 1;
        return startEightUnfinishedPlayerB;
    }

    public int increaseFinishedNineRoutesPlayerB() {
        startNineFinishedPlayerB += 1;
        return startNineFinishedPlayerB;
    }

    public int increaseUnfinishedNineRoutesPlayerB() {
        startNineUnfinishedPlayerB += 1;
        return startNineUnfinishedPlayerB;
    }

    public int increaseFinishedTenRoutesPlayerB() {
        startTenFinishedPlayerB += 1;
        return startTenFinishedPlayerB;
    }

    public int increaseUnfinishedTenRoutesPlayerB() {
        startTenUnfinishedPlayerB += 1;
        return startTenUnfinishedPlayerB;
    }

    public int increaseFinishedElevenRoutesPlayerB() {
        startElevenFinishedPlayerB += 1;
        return startElevenFinishedPlayerB;
    }

    public int increaseUnfinishedElevenRoutesPlayerB() {
        startElevenUnfinishedPlayerB += 1;
        return startElevenUnfinishedPlayerB;
    }

    public int increaseFinishedTwelveRoutesPlayerB() {
        startTwelveFinishedPlayerB += 1;
        return startTwelveFinishedPlayerB;
    }

    public int increaseUnfinishedTwelveRoutesPlayerB() {
        startTwelveUnfinishedPlayerB += 1;
        return startTwelveUnfinishedPlayerB;
    }

    public int increaseFinishedThirteenRoutesPlayerB() {
        startThirteenFinishedPlayerB += 1;
        return startThirteenFinishedPlayerB;
    }

    public int increaseUnfinishedThirteenRoutesPlayerB() {
        startThirteenUnfinishedPlayerB += 1;
        return startThirteenUnfinishedPlayerB;
    }

    public int increaseFinished20RoutesPlayerB() {
        start20FinishedPlayerB += 1;
        return start20FinishedPlayerB;
    }

    public int increaseUnfinished20RoutesPlayerB() {
        start20UnfinishedPlayerB += 1;
        return start20UnfinishedPlayerB;
    }

    public int increaseFinished21RoutesPlayerB() {
        start21FinishedPlayerB += 1;
        return start21FinishedPlayerB;
    }

    public int increaseUnfinished21RoutesPlayerB() {
        start21UnfinishedPlayerB += 1;
        return start21UnfinishedPlayerB;
    }

    public int pointsForRoutes(int numberOfFinishedRoutes, int numberOfUnfinishedRoutes, int valueOfRoute) {
        int sumOfRoutesPoints = numberOfFinishedRoutes * valueOfRoute + numberOfUnfinishedRoutes * valueOfRoute * (-1);
        return sumOfRoutesPoints;
    }

    public int totalPointsForRoutes() {
        TextView five = (TextView) findViewById(R.id.tv_fiveTotal);
        String a = five.getText().toString();

        TextView six = (TextView) findViewById(R.id.tv_sixTotal);
        String b = six.getText().toString();

        TextView seven = (TextView) findViewById(R.id.tv_sevenTotal);
        String c = seven.getText().toString();

        TextView eight = (TextView) findViewById(R.id.tv_eightTotal);
        String d = eight.getText().toString();

        TextView nine = (TextView) findViewById(R.id.tv_nineTotal);
        String e = nine.getText().toString();

        TextView ten = (TextView) findViewById(R.id.tv_tenTotal);
        String f = ten.getText().toString();

        TextView eleven = (TextView) findViewById(R.id.tv_elevenTotal);
        String g = eleven.getText().toString();

        TextView twelve = (TextView) findViewById(R.id.tv_twelveTotal);
        String h = twelve.getText().toString();

        TextView thirteen = (TextView) findViewById(R.id.tv_thirteenTotal);
        String i = thirteen.getText().toString();

        TextView twenty = (TextView) findViewById(R.id.tv_20Total);
        String j = twenty.getText().toString();

        TextView twentyone = (TextView) findViewById(R.id.tv_21Total);
        String k = twentyone.getText().toString();

        int value = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d) + Integer.parseInt(e) + Integer.parseInt(f)
                + Integer.parseInt(g) + Integer.parseInt(h) + Integer.parseInt(i) + Integer.parseInt(j) + Integer.parseInt(k);

        return value;
    }

    public int totalPointsForRoutesPlayerB() {
        TextView five = (TextView) findViewById(R.id.tv_playerBFiveTotal);
        String a = five.getText().toString();

        TextView six = (TextView) findViewById(R.id.tv_playerBSixTotal);
        String b = six.getText().toString();

        TextView seven = (TextView) findViewById(R.id.tv_playerBSevenTotal);
        String c = seven.getText().toString();

        TextView eight = (TextView) findViewById(R.id.tv_playerBEightTotal);
        String d = eight.getText().toString();

        TextView nine = (TextView) findViewById(R.id.tv_playerBNineTotal);
        String e = nine.getText().toString();

        TextView ten = (TextView) findViewById(R.id.tv_playerBTenTotal);
        String f = ten.getText().toString();

        TextView eleven = (TextView) findViewById(R.id.tv_playerBElevenTotal);
        String g = eleven.getText().toString();

        TextView twelve = (TextView) findViewById(R.id.tv_playerBTwelveTotal);
        String h = twelve.getText().toString();

        TextView thirteen = (TextView) findViewById(R.id.tv_playerBThirteenTotal);
        String i = thirteen.getText().toString();

        TextView twenty = (TextView) findViewById(R.id.tv_playerB20Total);
        String j = twenty.getText().toString();

        TextView twentyone = (TextView) findViewById(R.id.tv_playerB21Total);
        String k = twentyone.getText().toString();

        int value = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d) + Integer.parseInt(e) + Integer.parseInt(f)
                + Integer.parseInt(g) + Integer.parseInt(h) + Integer.parseInt(i) + Integer.parseInt(j) + Integer.parseInt(k);

        return value;
    }

    /**
     * methods to count using train station
     */
    int numbersOfUsingStation = 0;

    public int increaseUsingStation() {
        if (numbersOfUsingStation < 3) {
            numbersOfUsingStation += 1;
        } else {
            numbersOfUsingStation = 0;
        }
        return numbersOfUsingStation;
    }

    /**
     * @return info how many points user still have becouse not using train station
     */
    public String resultUsedStations() {
        String pointsForUnusedStation = "12";
        switch (numbersOfUsingStation) {
            case 0:
                pointsForUnusedStation = "12";
                break;
            case 1:
                pointsForUnusedStation = "8";
                break;
            case 2:
                pointsForUnusedStation = "4";
                break;
            case 3:
                pointsForUnusedStation = "0";
                break;

        }

        return pointsForUnusedStation;
    }

    /**
     * code which count total result for playerA
     *
     * @return total points collected by playerA
     */
    public int totalResult() {
        int totalResult = 0;
        TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_totalTrains);
        String a = totalPointsForTrains.getText().toString();
        TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_pointsTotalRoutes);
        String b = totalPointsForRoutes.getText().toString();
        TextView totalPointsUnusedStations = (TextView) findViewById(R.id.tv_pointsForTrainStations);
        String c = totalPointsUnusedStations.getText().toString();
        TextView totalPointsTheLongestTrack = (TextView) findViewById(R.id.tv_pointsForTheLongTrack);
        String d = totalPointsTheLongestTrack.getText().toString();


        return totalResult = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d);
    }

    /**
     * code which count total result for playerB
     *
     * @return total points collected by playerB
     */
    public int totalResultPlayerB() {
        int totalResult = 0;
        TextView totalPointsForTrains = (TextView) findViewById(R.id.tv_playerBTotalTrains);
        String a = totalPointsForTrains.getText().toString();
        TextView totalPointsForRoutes = (TextView) findViewById(R.id.tv_playerBPointsTotalRoutes);
        String b = totalPointsForRoutes.getText().toString();
        TextView totalPointsUnusedStations = (TextView) findViewById(R.id.tv_playerBPointsForTrainStations);
        String c = totalPointsUnusedStations.getText().toString();
        TextView totalPointsTheLongestTrack = (TextView) findViewById(R.id.tv_playerBPointsForTheLongTrack);
        String d = totalPointsTheLongestTrack.getText().toString();


        return totalResult = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) + Integer.parseInt(d);
    }

}
