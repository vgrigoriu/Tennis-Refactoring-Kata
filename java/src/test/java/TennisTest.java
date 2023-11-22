import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.MethodSource;

public class TennisTest {

    private static final String player1Name = "frodo";
    private static final String player2Name = "sauron";

    public static Stream<Object[]> getAllScores() {
        return Stream.of(new Object[][]{
                {0, 0, "Love-All"},
                {1, 1, "Fifteen-All"},
                {2, 2, "Thirty-All"},
                {3, 3, "Deuce"},
                {4, 4, "Deuce"},

                {1, 0, "Fifteen-Love"},
                {0, 1, "Love-Fifteen"},
                {2, 0, "Thirty-Love"},
                {0, 2, "Love-Thirty"},
                {3, 0, "Forty-Love"},
                {0, 3, "Love-Forty"},
                {4, 0, "Win for " + player1Name},
                {0, 4, "Win for " + player2Name},

                {2, 1, "Thirty-Fifteen"},
                {1, 2, "Fifteen-Thirty"},
                {3, 1, "Forty-Fifteen"},
                {1, 3, "Fifteen-Forty"},
                {4, 1, "Win for " + player1Name},
                {1, 4, "Win for " + player2Name},

                {3, 2, "Forty-Thirty"},
                {2, 3, "Thirty-Forty"},
                {4, 2, "Win for " + player1Name},
                {2, 4, "Win for " + player2Name},

                {4, 3, "Advantage " + player1Name},
                {3, 4, "Advantage " + player2Name},
                {5, 4, "Advantage " + player1Name},
                {4, 5, "Advantage " + player2Name},
                {15, 14, "Advantage " + player1Name},
                {14, 15, "Advantage " + player2Name},

                {6, 4, "Win for " + player1Name},
                {4, 6, "Win for " + player2Name},
                {16, 14, "Win for " + player1Name},
                {14, 16, "Win for " + player2Name},
        });
    }

    private static void checkAllScores(int player1Points, int player2Points, String expectedScore, TennisGame game) {
        int highestScore = Math.max(player1Points, player2Points);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Points)
                game.wonPoint(player1Name);
            if (i < player2Points)
                game.wonPoint(player2Name);
        }
        assertEquals(expectedScore, game.getScore());
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame1(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame1(player1Name, player2Name);
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    // @ParameterizedTest
    // @MethodSource("getAllScores")
    // public void checkAllScoresTennisGame2(int player1Points, int player2Points, String expectedScore) {
    //     TennisGame game = new TennisGame2(player1Name, player2Name);
    //     checkAllScores(player1Points, player2Points, expectedScore, game);
    // }

    // @ParameterizedTest
    // @MethodSource("getAllScores")
    // public void checkAllScoresTennisGame3(int player1Points, int player2Points, String expectedScore) {
    //     TennisGame game = new TennisGame3(player1Name, player2Name);
    //     checkAllScores(player1Points, player2Points, expectedScore, game);
    // }

    // @ParameterizedTest
    // @MethodSource("getAllScores")
    // public void checkAllScoresTennisGame4(int player1Points, int player2Points, String expectedScore) {
    //     TennisGame game = new TennisGame4(player1Name, player2Name);
    //     checkAllScores(player1Points, player2Points, expectedScore, game);
    // }

    // @ParameterizedTest
    // @MethodSource("getAllScores")
    // public void checkAllScoresTennisGame5(int player1Points, int player2Points, String expectedScore) {
    //     TennisGame game = new TennisGame5(player1Name, player2Name);
    //     checkAllScores(player1Points, player2Points, expectedScore, game);
    // }

    // @ParameterizedTest
    // @MethodSource("getAllScores")
    // public void checkAllScoresTennisGame6(int player1Points, int player2Points, String expectedScore) {
    //     TennisGame game = new TennisGame6(player1Name, player2Name);
    //     checkAllScores(player1Points, player2Points, expectedScore, game);
    // }
}
