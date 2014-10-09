package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import com.example.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
  public static final List<String> westWingers  = new ArrayList<String>() {{
    add("Leo");
    add("Josh");
    add("C.J.");
    add("Jed");
    add("Charlie");
    add("Toby");
    add("Sam");
    add("Donna");
  }};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }
}
