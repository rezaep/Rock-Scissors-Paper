package com.github.rezaep.rockscissorspaper.strategy.impl;

import com.github.rezaep.rockscissorspaper.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomMoveStrategyTest {

    @Test
    void getMove_ReturnRockOrScissorsOrPaper() {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        Move move = randomMoveStrategy.getMove();

        assertTrue(Move.ROCK == move || Move.SCISSORS == move || Move.PAPER == move);
    }
}