package com.github.rezaep.rockscissorspaper.strategy;

import com.github.rezaep.rockscissorspaper.move.Move;

/**
 * A {@link Strategy} for the <code>Player</code> which defines how the <code>Player</code> will select the next {@link Move}.
 *
 * @author Reza Ebrahimpour
 */
public interface Strategy {
    /**
     * @return The next {@link Move} of the <code>Player</code>.
     */
    Move getMove();
}
