package saman.problem.hanoi;

import saman.util.adt.linear.stack.Stack;
import saman.util.adt.linear.stack.StackImpl;
import saman.util.adt.linear.stack.StackOverflowException;

/**
 * Created by I311125 on 7/31/2017.
 */
public final class TowerOfHanoi {

    public enum TOWER { _1, _2, _3 }

    private final int numberOfDisks;

    private Stack<Integer> TOWER_1;
    private Stack<Integer> TOWER_2;
    private Stack<Integer> TOWER_3;
    private int movesCount;

    private TowerOfHanoi(final int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
        reset();
    }

    public static TowerOfHanoi begin(final int numberOfDisks) {
        return new TowerOfHanoi(numberOfDisks);
    }

    public void reset() {
        TOWER_1 = new StackImpl<Integer>(numberOfDisks);
        TOWER_2 = new StackImpl<Integer>(numberOfDisks);
        TOWER_3 = new StackImpl<Integer>(numberOfDisks);
        movesCount = 0;

        try {
            for (int i=numberOfDisks; i>0; i--)
                TOWER_1.push(i);
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }
    }

    public int getDiskCount(final TOWER tower) {
        switch (tower) {
            case _1:
                return TOWER_1.size();
            case _2:
                return TOWER_2.size();
            case _3:
                return TOWER_3.size();
            default:
                return -1;
        }
    }

    public void move(final TOWER from, final TOWER to) throws InvalidMoveException {
        if (from.equals(to))
            throw new IllegalStateException("Cannot make move to the same tower");

        try {
            Integer disk = 0;
            switch (from) {
                case _1:
                    disk = TOWER_1.pop();
                    break;
                case _2:
                    disk = TOWER_2.pop();
                    break;
                case _3:
                    disk = TOWER_3.pop();
                    break;
            }

            switch (to) {
                case _1:
                    validatBeforePush(TOWER._1.toString(), TOWER_1, disk);
                    TOWER_1.push(disk);
                    break;
                case _2:
                    validatBeforePush(TOWER._2.toString(), TOWER_2, disk);
                    TOWER_2.push(disk);
                    break;
                case _3:
                    validatBeforePush(TOWER._3.toString(), TOWER_3, disk);
                    TOWER_3.push(disk);
                    break;
            }

            movesCount += 1;
        } catch (StackOverflowException e) {
            throw new InvalidMoveException(e);
        }
    }

    private void validatBeforePush(final String towerID, final Stack<Integer> tower, final int disk) throws StackOverflowException, InvalidMoveException {
        if (!tower.isEmpty() && disk > tower.top()) {
            throw new InvalidMoveException("The disk being put is larger than the size of disk on top of tower " + towerID);
        }
    }

    public boolean isComplete() {
        return (TOWER_1.size() == 0) && ((TOWER_2.size() == 0 && TOWER_3.size() == numberOfDisks)
                || (TOWER_3.size() == 0 && TOWER_2.size() == numberOfDisks)) ;
    }

    public int getNumberOfMoves() {
        return movesCount;
    }

    @Override
    public String toString() {
        return "MOVE ".concat(String.valueOf(movesCount)).concat("\n")
                .concat("TOWER_1: ").concat(TOWER_1.toString()).concat("\n")
                .concat("TOWER_2: ").concat(TOWER_2.toString()).concat("\n")
                .concat("TOWER_3: ").concat(TOWER_3.toString()).concat("\n");
    }

    public static class InvalidMoveException extends Exception {

        public InvalidMoveException(final String msg) {
            super(msg);
        }

        public InvalidMoveException(final Throwable cause) {
            super(cause);
        }

    }

}
