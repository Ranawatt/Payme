package com.example.sugandhkumar.payme.activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.sugandhkumar.payme.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSubscribeAndLog() throws InterruptedException {
        onView(withId(R.id.textView8)).check(matches(isDisplayed()));

        // Click subscribe button and check toast
        onView(allOf(withId(R.id.btn_help), withText(R.string.help)))
                .check(matches(isDisplayed()))
                .perform(click());
//        confirmToastStartsWith(mActivityRule.getScenario().getClass().getString(R.string.help));

        // Sleep so the Toast goes away, this is lazy but it works (Toast.LENGTH_SHORT = 2000)
        Thread.sleep(2000);

        // Click log token and check toast
        onView(allOf(withId(R.id.btn_back), withText(R.string.btn_back)))
                .check(matches(isDisplayed()))
                .perform(click());
//        confirmToastStartsWith(mActivityRule.getScenario().getString(R.string.btn_back, ""));
    }

    private void confirmToastStartsWith(String string) {
//        View activityWindowDecorView = mActivityRule.getActivity().getWindow().getDecorView();
//        onView(withText(startsWith(string)))
//                .inRoot(withDecorView(not(is(activityWindowDecorView))))
//                .check(matches(isDisplayed()));
    }
}