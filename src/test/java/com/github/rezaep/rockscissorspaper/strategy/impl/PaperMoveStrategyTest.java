package com.github.rezaep.rockscissorspaper.strategy.impl;

import com.github.rezaep.rockscissorspaper.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperMoveStrategyTest {

    @Test
    void getMoveReturnPaperMove() {
        PaperMoveStrategy paperMoveStrategy = new PaperMoveStrategy();

        assertEquals(paperMoveStrategy.getMove(), Move.PAPER);
    }
}