package com.github.rezaep.rockscissorspaper.move;

/**
 * The {@link Move} enum contains the possible moves for players. There are 3 different moves available for players.
 * <code>ROCK</code> beats <code>SCISSORS</code>. <code>SCISSORS</code> beats <code>PAPER</code>.
 * <code>PAPER</code> beats <code>ROCK</code>. The same {@link Move}s will lead to a <em>Tie</em>.
 *
 * @author Reza Ebrahimpour
 */
public enum Move {
    /**
     * <code>ROCK</code> beats <code>SCISSORS</code> and loses to <code>PAPER</code>.
     */
    ROCK,
    /**
     * <code>SCISSORS</code> beats <code>PAPER</code> and loses to <code>ROCK</code>.
     */
    SCISSORS,
    /**
     * <code>PAPER</code> beats <code>ROCK</code> and loses to <code>SCISSORS</code>.
     */
    PAPER
}
