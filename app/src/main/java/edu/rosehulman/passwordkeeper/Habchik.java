package edu.rosehulman.passwordkeeper;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import java.util.Calendar;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Habchik extends AppCompatActivity {

    private ListView mListView;

    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habchik);

        fab = (FloatingActionButton) findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Habchik.this, TestActivity.class);
                startActivity(intent1);
            }
        });

        mListView = (ListView)findViewById(R.id.listView);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smartfridge-392c5.firebaseio.com/User");

        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, databaseReference) {
            @Override
            protected void populateView(View v, String model, final int position) {
                final TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                            textView.setTextColor(Color.BLUE);
//                            Intent intent0 = new Intent(Habchik.this, TestActivity.class);
//                            startActivity(intent0);
                        }
                });
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                switch (day) {
                    case Calendar.MONDAY:
                        if(position ==0) {
                            textView.setTextColor(Color.RED);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.TUESDAY:
                        if(position ==1) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.WEDNESDAY:
                        if(position ==2) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.THURSDAY:
                        if(position ==3) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.FRIDAY:
                        if(position ==4) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.SATURDAY:
                        if(position ==5) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                    case Calendar.SUNDAY:
                        if(position ==6) {
                            textView.setTextColor(Color.RED);
                            textView.setBackgroundResource(R.drawable.listviewbackground);
                        }
                        else textView.setTextColor(Color.BLACK);
                        break;
                }
            }

        };
        mListView.setAdapter(firebaseListAdapter);
    }

}
