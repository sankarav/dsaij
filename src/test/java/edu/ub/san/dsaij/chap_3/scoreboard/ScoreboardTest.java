package edu.ub.san.dsaij.chap_3.scoreboard;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by san on 10/22/15 for dsaij.
 */
public class ScoreboardTest {

    @Test
    public void testFirstGameEntryAdd() throws Exception {
        Scoreboard sb = new Scoreboard(10);

        GameEntry ge1 = new GameEntry(99, "User1");
        sb.add(ge1);

        assertEquals("Number of entries is not 1", 1, sb.getNumEntries());
        assertEquals("GameEntry was not added at first index", ge1, sb.getScoreBoard()[0]);
    }

    @Test
    public void testSimpleTwoGameEntryAdd() throws Exception {
        Scoreboard sb = new Scoreboard(10);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        sb.add(ge1); sb.add(ge2);

        assertEquals("Number of entries is not 2", 2, sb.getNumEntries());
        assertEquals("GameEntry 1 was not added at first index", ge1, sb.getScoreBoard()[0]);
        assertEquals("GameEntry 2 was not added at first index", ge2, sb.getScoreBoard()[1]);
    }

    @Test
    public void testFullBoardAddToLast() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3"); GameEntry ge4 = new GameEntry(80, "User3");
        GameEntry ge5 = new GameEntry(83, "User4"); GameEntry ge6 = new GameEntry(93, "User5");
        sb.add(ge1); sb.add(ge2); sb.add(ge3);
        sb.add(ge4); sb.add(ge5); sb.add(ge6);

        assertEquals("Number of entries is not 5", 5, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard", new GameEntry[]{ge1, ge2, ge6, ge3, ge5}, sb.getScoreBoard());
    }

    @Test
    public void testRemoveAtIndex_0() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3");
        sb.add(ge1); sb.add(ge2); sb.add(ge3);

        assertEquals("Number of entries is not 3", 3, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard before remove()", new GameEntry[]{ge1, ge2, ge3, null, null}, sb.getScoreBoard());

        sb.remove(0);

        assertEquals("Number of entries is not 2", 2, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard after remove()", new GameEntry[]{ge2, ge3, null, null, null}, sb.getScoreBoard());
    }

    @Test
    public void testRemoveAtIndex_Middle() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3"); GameEntry ge4 = new GameEntry(80, "User4");
        sb.add(ge1); sb.add(ge2); sb.add(ge3); sb.add(ge4);

        assertEquals("Number of entries is not 4", 4, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard before remove()", new GameEntry[]{ge1, ge2, ge3, ge4, null}, sb.getScoreBoard());

        sb.remove(2);

        assertEquals("Number of entries is not 3", 3, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard after remove()", new GameEntry[]{ge1, ge2, ge4, null, null}, sb.getScoreBoard());
    }

    @Test
    public void testRemoveAtIndex_Last_WhenFull() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3"); GameEntry ge4 = new GameEntry(80, "User4");
        GameEntry ge5 = new GameEntry(70, "User5");
        sb.add(ge1); sb.add(ge2); sb.add(ge3); sb.add(ge4); sb.add(ge5);

        assertEquals("Number of entries is not 5", 5, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard before remove()", new GameEntry[]{ge1, ge2, ge3, ge4, ge5}, sb.getScoreBoard());

        sb.remove(4);

        assertEquals("Number of entries is not 4", 4, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard after remove()", new GameEntry[]{ge1, ge2, ge3, ge4, null}, sb.getScoreBoard());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveAtNegativeIndex() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3"); GameEntry ge4 = new GameEntry(80, "User4");
        sb.add(ge1); sb.add(ge2); sb.add(ge3); sb.add(ge4);

        assertEquals("Number of entries is not 4", 4, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard before remove()", new GameEntry[]{ge1, ge2, ge3, ge4, null}, sb.getScoreBoard());

        sb.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveAtHigherIndex() throws Exception {
        Scoreboard sb = new Scoreboard(5);

        GameEntry ge1 = new GameEntry(99, "User1"); GameEntry ge2 = new GameEntry(98, "User2");
        GameEntry ge3 = new GameEntry(90, "User3"); GameEntry ge4 = new GameEntry(80, "User4");
        sb.add(ge1); sb.add(ge2); sb.add(ge3); sb.add(ge4);

        assertEquals("Number of entries is not 4", 4, sb.getNumEntries());
        assertArrayEquals("Incorrect ScoreBoard before remove()", new GameEntry[]{ge1, ge2, ge3, ge4, null}, sb.getScoreBoard());

        sb.remove(4);
    }
}