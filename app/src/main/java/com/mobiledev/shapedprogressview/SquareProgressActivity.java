package com.mobiledev.shapedprogressview;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mobiledev.shapedprogress.SquareProgressView;

/**
 * Created by Manu on 5/13/2017.
 */

public class SquareProgressActivity extends AppCompatActivity {
    SquareProgressView sq1, sq2, sq3, sq4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        sq1 = (SquareProgressView) findViewById(R.id.SquareProgressView1);
        sq2 = (SquareProgressView) findViewById(R.id.SquareProgressView2);
        sq3 = (SquareProgressView) findViewById(R.id.SquareProgressView3);
        sq4 = (SquareProgressView) findViewById(R.id.SquareProgressView4);
        sq1.setType(SquareProgressView.TYPE_FILL_LEFT);
        sq2.setType(SquareProgressView.TYPE_FILL_RIGHT);
        sq3.setType(SquareProgressView.TYPE_FILL_TOP);
        sq4.setType(SquareProgressView.TYPE_STROKE);
        new SquareProgressActivity.ShowProgress().execute();
    }

    class ShowProgress extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            int i = 0;
            while (true) {
                publishProgress(i);
                if (i >= 100) {
                    break;
                }
                i++;
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            sq1.updateProgress(0);
            sq2.updateProgress(0);
            sq3.updateProgress(0);
            sq4.updateProgress(0);
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            sq1.updateProgress(values[0]);
            sq2.updateProgress(values[0]);
            sq3.updateProgress(values[0]);
            sq4.updateProgress(values[0]);
            sq4.setTextColor(Color.BLACK);
        }

        @Override
        protected void onCancelled(Void result) {
            super.onCancelled(result);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

    }
}
