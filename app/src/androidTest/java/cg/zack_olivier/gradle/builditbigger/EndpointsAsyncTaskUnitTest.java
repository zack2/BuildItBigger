package cg.zack_olivier.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.example.ZackJokes;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskUnitTest implements EndpointsAsyncTask.Listener{
    @Test
    public void additionIsCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    private final CountDownLatch mSignal = new CountDownLatch(1);

    @Test
    public void testJokeRetriever() {
        new EndpointsAsyncTask(this).execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            fail("interruption subite");
        }
    }


    @Override
    public void onJokeLoaded(String joke) {

        assertTrue(joke.equals(ZackJokes.getZackJoke()));
        mSignal.countDown();
    }
}