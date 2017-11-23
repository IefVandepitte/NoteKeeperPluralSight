package com.example.ief.notekeeperpluralsight;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NoteListActivityTest {

    @Rule
    public ActivityTestRule<NoteListActivity> mActivityTestRule = new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void noteListActivityTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.text_note_title), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.text_note_title), isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.text_note_title), isDisplayed()));
        appCompatEditText3.perform(replaceText("title"), closeSoftKeyboard());

//        pressBack();   // TODO: 23/10/2017  deze pressback is overbodig wegens de closeSoftKeyboard hierboven
                        // en laat de gegenereerde test falen; let hiervoor op



        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.text_note_text), isDisplayed()));
        appCompatEditText4.perform(replaceText("text"), closeSoftKeyboard());

//        pressBack();   // TODO: 23/10/2017  deze pressback is overbodig wegens de closeSoftKeyboard hierboven
        // en laat de gegenereerde test falen; let hiervoor op

        ViewInteraction editText = onView(
                allOf(withId(R.id.text_note_title), withText("title"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        1),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("title")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.text_note_text), withText("text"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        1),
                                2),
                        isDisplayed()));
        editText2.check(matches(withText("text")));

        pressBack();

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
