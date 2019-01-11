package com.github.rezaep.rockscissorspaper.strategy.impl;

import com.github.rezaep.rockscissorspaper.move.Move;
import com.github.rezaep.rockscissorspaper.strategy.Strategy;

import java.util.Random;

/**
 * This is the {@link Strategy} of a player who always choose a random {@link Move}.
 *
 * @author Reza Ebrahimpour
 */
public class RandomMoveStrategy implements Strategy {
    private static final Random random = new Random();

    public Move getMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
