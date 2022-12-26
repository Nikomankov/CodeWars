import org.example.PawnMoveTracker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPawnMoveTracker {
    @Test
    public void exampleTest1() {
        String[][] expected = {
                {".",".",".",".",".",".",".","."},
                {".","B","B",".","B","B","B","B"},
                {"B",".",".","B",".",".",".","."},
                {".",".",".",".",".",".",".","."},
                {".",".",".",".","W",".",".","."},
                {".",".",".",".",".",".",".","."},
                {"W","W","W","W",".","W","W","W"},
                {".",".",".",".",".",".",".","."} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"e3", "d6", "e4", "a6"}));
    }

    @Test
    public void exampleTest2() {
        String[][] expected = {
                {".",".",".",".",".",".",".","."},
                {"B","B","B",".","B","B","B","B"},
                {".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".","."},
                {".",".",".",".","B",".",".","."},
                {".",".",".","W",".",".",".","."},
                {"W","W","W",".",".","W","W","W"},
                {".",".",".",".",".",".",".","."} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"e4", "d5", "d3", "dxe4"}));
    }
}
