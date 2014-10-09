package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
  public static final List<String> westWingers = new ArrayList<String>() {{
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
    ListView listView = (ListView) findViewById(R.id.list_view);
    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, westWingers);
    listView.setAdapter(stringArrayAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
        intent.putExtra("name", westWingers.get(position));
        startActivity(intent);
      }
    });
  }
}
