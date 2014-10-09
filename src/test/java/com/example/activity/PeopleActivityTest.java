package com.example.activity;

import android.content.Intent;
import android.widget.TextView;
import com.example.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class PeopleActivityTest {

  private PeopleActivity subject;

  @Before
  public void setUp() throws Exception {
    Intent intent = new Intent(Robolectric.application, PeopleActivity.class);
    intent.putExtra("name", "Leo");
    ActivityController<PeopleActivity> activityController = Robolectric.buildActivity(PeopleActivity.class).withIntent(intent).create().start().visible().resume();
    subject = activityController.get();
  }

  @Test
  public void itPopulatesTheViewWithTheName() {
    assertThat(((TextView) subject.findViewById(R.id.person)).getText()).isEqualTo("Leo");
  }
}