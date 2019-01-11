package com.github.rezaep.rockscissorspaper.match;

import com.github.rezaep.rockscissorspaper.move.Move;
import com.github.rezaep.rockscissorspaper.player.Player;
import lombok.Getter;

import static com.github.rezaep.rockscissorspaper.match.Result.*;
import static com.github.rezaep.rockscissorspaper.move.Move.*;

/**
 * {@link Match} handles the logic of the game. Every {@link Match} needs two {@link Player}s.
 */
public class Match {
    private Player playerA;
    private Player playerB;

    /**
     * This counter indicates how many times did the {@link Player} <code>A</code> win the {@link Match}.
     */
    @Getter
    private int playerAWinCount = 0;
    /**
     * This counter indicates how many times did the {@link Player} <code>A</code> win the {@link Match}.
     */
    @Getter
    private int playerBWinCount = 0;
    /**
     * This counter indicates how many times did the {@link Match} lead to a <em>Tie</em>.
     */
    @Getter
    private int tieCount = 0;

    public Match(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    /**
     * This method plays a <code>Round</code> and update <code>playerAWinCount</code>, <code>playerBWinCount</code>
     * or <code>tieCount</code>.
     */
    public void playRound() {
        Result result = checkRoundResult(playerA.getMove(), playerB.getMove());

        switch (result) {
            case PLAYER_A_WON:
                playerAWinCount += 1;
                break;
            case PLAYER_B_WON:
                playerBWinCount += 1;
                break;
            case TIE:
                tieCount += 1;
                break;
            default:
                // This never happens
                tieCount += 1;
                break;
        }
    }

    /**
     * Compares the {@link Move} of {@link Player} and defines the winner. If the moves are the same, the {@link Match}
     * leads to a <em>Tie</em>.
     *
     * @param first  The {@link Move} of {@link Player} A
     * @param second The {@link Move} of {@link Player} B
     * @return The result of the {@link Match}. 1 indicates that {@link Player} A won the {@link Match}. -1 indicates
     * that {@link Player} B won the {@link Match}. 0 is a <em>Tie</em>.
     */
    public Result checkRoundResult(Move first, Move second) {
        if (first.equals(second)) {
            return TIE;
        }

        switch (first) {
            case ROCK:
                return (second == SCISSORS ? PLAYER_A_WON : PLAYER_B_WON);
            case PAPER:
                return (second == ROCK ? PLAYER_A_WON : PLAYER_B_WON);
            case SCISSORS:
                return (second == PAPER ? PLAYER_A_WON : PLAYER_B_WON);
            default:
                // This case should never happen
                return TIE;
        }
    }

    /**
     * Get the result of the {@link Match}.
     *
     * @return The result of the {@link Match}.
     */
    public Result getResult() {
        if (playerAWinCount > playerBWinCount) {
            return PLAYER_A_WON;
        } else if (playerAWinCount == playerBWinCount) {
            return TIE;
        } else {
            return PLAYER_B_WON;
        }
    }
}
