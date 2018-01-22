package saman.problem.misc;

import org.junit.Test;

public class SocialNetworkTest {

    @Test
    public void testSocialGraphs() {
        int[] counts = {3,3,3,3,3,1,3};
        SocialNetwork.socialGraphs(counts);
    }
}
