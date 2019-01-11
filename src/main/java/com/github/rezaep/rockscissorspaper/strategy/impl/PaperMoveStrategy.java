package com.github.rezaep.rockscissorspaper.strategy.impl;

import com.github.rezaep.rockscissorspaper.move.Move;
import com.github.rezaep.rockscissorspaper.strategy.Strategy;

/**
 * This is the {@link Strategy} of a player who always choose <code>{@link Move}.PAPER</code>.
 *
 * @author Reza Ebrahimpour
 */
public class PaperMoveStrategy implements Strategy {
    public Move getMove() {
        return Move.PAPER;
    }
}
