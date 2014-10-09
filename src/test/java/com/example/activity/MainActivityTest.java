package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;
import com.example.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowListView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
  private Activity subject;

  @Before
  public void setUp() throws Exception {
    subject = Robolectric.setupActivity(MainActivity.class);
  }

  @Test
  public void itPopulatesEachViewWithTheNames() {
    ListView listView = (ListView) subject.findViewById(R.id.list_view);

    shadowOf(listView).populateItems();

    assertThat(listView.getChildCount()).isEqualTo(MainActivity.westWingers.size());


    for (int i = 0; i < listView.getChildCount(); i++) {
      TextView childAt = (TextView) listView.getChildAt(i);
      assertThat(childAt.getText().toString()).isEqualTo(MainActivity.westWingers.get(i));
    }
  }

  @Test
  public void whenIClickOnAPersonIAmTakenToTheirPage() {
    ListView listView = (ListView) subject.findViewById(R.id.list_view);
    ShadowListView shadowListView = shadowOf(listView);
    shadowListView.populateItems();

    shadowListView.clickFirstItemContainingText("Leo");

    Intent nextStartedActivity = shadowOf(subject).getNextStartedActivity();
    assertThat(nextStartedActivity.getComponent().getClassName()).isEqualTo(PeopleActivity.class.getName());
    assertThat(nextStartedActivity.getStringExtra("name")).isEqualTo("Leo");
  }
}
