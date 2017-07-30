package saman.problem.hanoi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by I311125 on 7/30/2017.
 */
public class TowerOfHanoiTest {

    @Test
    public void testTowerOfHanoi() throws TowerOfHanoi.InvalidMoveException {
        TowerOfHanoi puzzle = TowerOfHanoi.begin(3);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._1, TowerOfHanoi.TOWER._2);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._1, TowerOfHanoi.TOWER._3);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._2, TowerOfHanoi.TOWER._3);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._1, TowerOfHanoi.TOWER._2);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._3, TowerOfHanoi.TOWER._1);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._3, TowerOfHanoi.TOWER._2);
        System.out.println(puzzle.toString());
        puzzle.move(TowerOfHanoi.TOWER._1, TowerOfHanoi.TOWER._2);
        System.out.println(puzzle.toString());
        assertTrue(puzzle.isComplete());
    }
}
