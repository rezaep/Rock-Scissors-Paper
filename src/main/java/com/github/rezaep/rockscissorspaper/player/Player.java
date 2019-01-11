package com.github.rezaep.rockscissorspaper.player;

import com.github.rezaep.rockscissorspaper.move.Move;
import com.github.rezaep.rockscissorspaper.strategy.Strategy;
import lombok.Getter;

/**
 * The <code>Player</code> class represents a player. <b>Rock-Scissors-Paper</b> is a hand game usually played between
 * two <code>Player</code>. Each <code>Player</code> has his own {@link Strategy} and he has to choose one {@link Move}.
 *
 * @author Reza Ebrahimpour
 */
@Getter
public class Player {
    /**
     * The name of the {@link Player}.
     */
    private String name;
    /**
     * The {@link Strategy} of this player for the <code>Match</code>. The {@link Strategy} defines how
     * the <code>Player</code> selects the next {@link Move}. The {@link Strategy} impacts on the win rate of the
     * <code>Player</code>.
     */
    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    /**
     * Performs a new {@link Move} based on the {@link Strategy} of this <code>Player</code>.
     *
     * @return the next {@link Move} of this
     */
    public Move getMove() {
        return this.strategy.getMove();
    }
}
