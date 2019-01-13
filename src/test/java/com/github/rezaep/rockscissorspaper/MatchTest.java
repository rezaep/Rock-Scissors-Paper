package com.github.rezaep.rockscissorspaper;

import com.github.rezaep.rockscissorspaper.match.Match;
import com.github.rezaep.rockscissorspaper.match.Result;
import com.github.rezaep.rockscissorspaper.move.Move;
import com.github.rezaep.rockscissorspaper.player.Player;
import com.github.rezaep.rockscissorspaper.strategy.impl.PaperMoveStrategy;
import com.github.rezaep.rockscissorspaper.strategy.impl.RandomMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {
    private static final String PLAYER_A_WIN_COUNT_FIELD_NAME = "playerAWinCount";
    private static final String PLAYER_B_WIN_COUNT_FIELD_NAME = "playerBWinCount";

    private Match match;

    @BeforeEach
    void setUp() {
        // Setup a Match with 2 Player
        Player playerA = new Player("A", new PaperMoveStrategy());
        Player playerB = new Player("B", new RandomMoveStrategy());

        match = new Match(playerA, playerB);
    }

    @Test
    void playRoundOneAndOnlyOneOfPlayerAWinCountOrPlayerBWinCountOrTieCountFieldsShouldIncreaseToOne() {
        match.playRound();

        int total = match.getPlayerAWinCount() + match.getPlayerBWinCount() + match.getTieCount();

        assertEquals(total, 1);
    }

    @Test
    void checkRoundResultWithSameMoveLeadsToATie() {
        assertEquals(match.checkRoundResult(Move.ROCK, Move.ROCK), Result.TIE);
        assertEquals(match.checkRoundResult(Move.SCISSORS, Move.SCISSORS), Result.TIE);
        assertEquals(match.checkRoundResult(Move.PAPER, Move.PAPER), Result.TIE);
    }

    @Test
    void checkRoundResultWhenPlayerARockPlayerBScissorsLeadsToPLAYERAWON() {
        assertEquals(match.checkRoundResult(Move.ROCK, Move.SCISSORS), Result.PLAYER_A_WON);
    }

    @Test
    void checkRoundResultWhenPlayerARockPlayerBPaperLeadsToPLAYERBWON() {
        assertEquals(match.checkRoundResult(Move.ROCK, Move.PAPER), Result.PLAYER_B_WON);
    }

    @Test
    void checkRoundResultWhenPlayerAScissorsPlayerBRockLeadsToPLAYERBWON() {
        assertEquals(match.checkRoundResult(Move.SCISSORS, Move.ROCK), Result.PLAYER_B_WON);
    }

    @Test
    void checkRoundResultWhenPlayerAScissorsPlayerBPaperLeadsToPLAYERAWON() {
        assertEquals(match.checkRoundResult(Move.SCISSORS, Move.PAPER), Result.PLAYER_A_WON);
    }

    @Test
    void checkRoundResultWhenPlayerAPaperPlayerBRockLeadsToPLAYERAWON() {
        assertEquals(match.checkRoundResult(Move.PAPER, Move.ROCK), Result.PLAYER_A_WON);
    }

    @Test
    void checkRoundResultWhenPlayerAPaperPlayerBScissorsLeadsToPLAYERBWON() {
        assertEquals(match.checkRoundResult(Move.PAPER, Move.SCISSORS), Result.PLAYER_B_WON);
    }

    @Test
    void getResultWhenPlayerAHasMoreWinLeadToPLAYERAWON() throws NoSuchFieldException, IllegalAccessException {
        // Use Reflection to set private fields to specific values
        // Player A has more win than player B
        Field playerAWinCountField = match.getClass().getDeclaredField(PLAYER_A_WIN_COUNT_FIELD_NAME);
        playerAWinCountField.setAccessible(true);
        playerAWinCountField.set(match, 60);

        Field playerBWinCountField = match.getClass().getDeclaredField(PLAYER_B_WIN_COUNT_FIELD_NAME);
        playerBWinCountField.setAccessible(true);
        playerBWinCountField.set(match, 40);

        assertEquals(Result.PLAYER_A_WON, match.getResult());
    }

    @Test
    void getResultWhenPlayerBHasMoreWinLeadToPLAYERBWON() throws NoSuchFieldException, IllegalAccessException {
        // Use Reflection to set private fields to specific values
        // Player B has more win than player A
        Field playerAWinCountField = match.getClass().getDeclaredField(PLAYER_A_WIN_COUNT_FIELD_NAME);
        playerAWinCountField.setAccessible(true);
        playerAWinCountField.set(match, 40);

        Field playerBWinCountField = match.getClass().getDeclaredField(PLAYER_B_WIN_COUNT_FIELD_NAME);
        playerBWinCountField.setAccessible(true);
        playerBWinCountField.set(match, 60);

        assertEquals(Result.PLAYER_B_WON, match.getResult());
    }

    @Test
    void getResultWhenBothPlayerHaveEqualWinsLeadsToATIE() throws NoSuchFieldException, IllegalAccessException {
        // Use Reflection to set private fields to specific values
        // Both players have equal wins
        Field playerAWinCountField = match.getClass().getDeclaredField(PLAYER_A_WIN_COUNT_FIELD_NAME);
        playerAWinCountField.setAccessible(true);
        playerAWinCountField.set(match, 50);

        Field playerBWinCountField = match.getClass().getDeclaredField(PLAYER_B_WIN_COUNT_FIELD_NAME);
        playerBWinCountField.setAccessible(true);
        playerBWinCountField.set(match, 50);

        assertEquals(Result.TIE, match.getResult());
    }
}