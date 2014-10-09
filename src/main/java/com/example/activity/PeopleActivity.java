package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.R;

public class PeopleActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.people);
    TextView personView = (TextView) findViewById(R.id.person);
    personView.setText(getIntent().getStringExtra("name"));
  }
}
