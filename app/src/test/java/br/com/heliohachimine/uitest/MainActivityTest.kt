package br.com.heliohachimine.uitest

import android.app.Application
import android.content.Intent
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowApplication

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var activity: MainActivity
    lateinit var application: ShadowApplication

    @Before
    fun setUp() {
        val app: Application = ApplicationProvider.getApplicationContext()
        application = Shadows.shadowOf(app)

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity {
            activityScenario.moveToState(Lifecycle.State.RESUMED)
            activity = it
        }
    }

    @Test
    fun shouldNotBeNull() {
        val textView = activity.findViewById<TextView>(R.id.main_hello_word)
        assertEquals(textView.text, "Hello World!")
    }

    @Test
    fun onClickButtonShouldGoToSecondScreen() {
        val button = activity.findViewById<TextView>(R.id.main_button)
        val expectedIntent = Intent(activity, SecondActivity::class.java)

        button.performClick()

        val actual: Intent = application.nextStartedActivity
        assertEquals(actual, expectedIntent)
    }
}


