package com.github.rezaep.rockscissorspaper;

import com.github.rezaep.rockscissorspaper.match.Match;
import com.github.rezaep.rockscissorspaper.match.Result;
import com.github.rezaep.rockscissorspaper.player.Player;
import com.github.rezaep.rockscissorspaper.strategy.impl.PaperMoveStrategy;
import com.github.rezaep.rockscissorspaper.strategy.impl.RandomMoveStrategy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());

    private static final int DEFAULT_RUN_TIMES = 100;

    public static void main(String[] args) {
        Player playerA = new Player("A", new PaperMoveStrategy());
        Player playerB = new Player("B", new RandomMoveStrategy());

        Match match = new Match(playerA, playerB);

        for (int i = 0; i < DEFAULT_RUN_TIMES; i++) {
            match.playRound();
        }

        logger.log(Level.INFO, "Player A wins {0} of {1} games", new Object[]{match.getPlayerAWinCount(), DEFAULT_RUN_TIMES});
        logger.log(Level.INFO, "Player B wins {0} of {1} games", new Object[]{match.getPlayerBWinCount(), DEFAULT_RUN_TIMES});
        logger.log(Level.INFO, "Tie: {0} of {1} games", new Object[]{match.getTieCount(), DEFAULT_RUN_TIMES});

        Result result = match.getResult();

        switch (result) {
            case PLAYER_A_WON:
                logger.log(Level.INFO, "Winner is: Player A ({0} to {1} wins)"
                        , new Object[]{match.getPlayerAWinCount(), match.getPlayerBWinCount()});
                break;
            case PLAYER_B_WON:
                logger.log(Level.INFO, "Winner is: Player B ({0} to {1} wins)"
                        , new Object[]{match.getPlayerBWinCount(), match.getPlayerAWinCount()});
                break;
            case TIE:
                logger.log(Level.INFO, "Tie !");
                break;
        }
    }
}
