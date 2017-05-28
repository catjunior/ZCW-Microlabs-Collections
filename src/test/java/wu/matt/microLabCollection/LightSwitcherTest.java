package wu.matt.microLabCollection;

/**
 * Created by mattwu on 5/27/17.
 */

import org.junit.Assert;
import org.junit.Test;
import java.util.BitSet;
import org.junit.Before;

public class LightSwitcherTest {

    private BitSet baseByte;
    private BitSet flippedBaseByte;
    private BitSet allOnes;
    private BitSet allZeroes;
    private BitSet leftFourOnes;
    private BitSet rightFourOnes;

    @Before
    public void initialize() {
        baseByte = LightSwitcher.toBit("10101010");
        flippedBaseByte = LightSwitcher.toBit("01010101");
        allOnes = LightSwitcher.toBit("11111111");
        allZeroes = LightSwitcher.toBit("00000000");
        leftFourOnes = LightSwitcher.toBit("11110000");
        rightFourOnes = LightSwitcher.toBit("00001111");
    }

    @Test
    public void testTurnOnSwitches1() {
        BitSet result1 = LightSwitcher.turnOnSwitches(baseByte, leftFourOnes);
        BitSet expected1 = LightSwitcher.toBit("11111010");
        BitSet result2 = LightSwitcher.turnOnSwitches(flippedBaseByte, leftFourOnes);
        BitSet expected2 = LightSwitcher.toBit("11110101");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);
    }

    @Test
    public void testTurnOnSwitches2() { //fowllow the previous test, but reset the parameter
        BitSet result3 = LightSwitcher.turnOnSwitches(baseByte, rightFourOnes);
        BitSet expected3 = LightSwitcher.toBit("10101111");
        BitSet result4 = LightSwitcher.turnOnSwitches(flippedBaseByte, rightFourOnes);
        BitSet expected4 = LightSwitcher.toBit("01011111");
        Assert.assertEquals(result3, expected3);
        Assert.assertEquals(result4, expected4);
    }

    @Test
    public void testTurnOnAllSwitches1() {
        BitSet result1 = LightSwitcher.turnOnAllSwitches(baseByte);
        BitSet result2 = LightSwitcher.turnOnAllSwitches(flippedBaseByte);
        BitSet result3 = LightSwitcher.turnOnAllSwitches(allOnes);
        BitSet result4 = LightSwitcher.turnOnAllSwitches(allZeroes);
        Assert.assertEquals(result1, allOnes);
        Assert.assertEquals(result2, allOnes);
        Assert.assertEquals(result3, allOnes);
        Assert.assertEquals(result4, allOnes);
    }

    @Test
    public void testTurnOnAllSwitches() {
        BitSet result1 = LightSwitcher.turnOnAllSwitches(baseByte);
        BitSet result2 = LightSwitcher.turnOnAllSwitches(flippedBaseByte);
        BitSet result3 = LightSwitcher.turnOnAllSwitches(allOnes);
        BitSet result4 = LightSwitcher.turnOnAllSwitches(allZeroes);
        Assert.assertEquals(result1, allOnes);
        Assert.assertEquals(result2, allOnes);
        Assert.assertEquals(result3, allOnes);
        Assert.assertEquals(result4, allOnes);
    }


    @Test
    public void testTurnOffSwitches1() {
        BitSet result1 = LightSwitcher.turnOffSwitches(baseByte, leftFourOnes);
        BitSet expected1 = LightSwitcher.toBit("00001010");
        BitSet result2 = LightSwitcher.turnOffSwitches(flippedBaseByte, leftFourOnes);
        BitSet expected2 = LightSwitcher.toBit("00000101");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);
    }

    @Test
    public void testTurnOffSwitches2() {
        BitSet result3 = LightSwitcher.turnOffSwitches(baseByte, rightFourOnes);
        BitSet expected3 = LightSwitcher.toBit("10100000");
        BitSet result4 = LightSwitcher.turnOffSwitches(flippedBaseByte, rightFourOnes);
        BitSet expected4 = LightSwitcher.toBit("01010000");
        Assert.assertEquals(result3, expected3);
        Assert.assertEquals(result4, expected4);
    }

    @Test
    public void testTurnOffAllSwitches() {
        BitSet result1 = LightSwitcher.turnOffAllSwitches(baseByte);
        BitSet result2 = LightSwitcher.turnOffAllSwitches(flippedBaseByte);
        BitSet result3 = LightSwitcher.turnOffAllSwitches(allOnes);
        BitSet result4 = LightSwitcher.turnOffAllSwitches(allZeroes);
        Assert.assertEquals(result1, allZeroes);
        Assert.assertEquals(result2, allZeroes);
        Assert.assertEquals(result3, allZeroes);
        Assert.assertEquals(result4, allZeroes);
    }

    @Test
    public void testFlipSwitches1() {
        BitSet result1 = LightSwitcher.flipSwitches(baseByte, leftFourOnes);
        BitSet expected1 = LightSwitcher.toBit("01011010");
        BitSet result2 = LightSwitcher.flipSwitches(flippedBaseByte, leftFourOnes);
        BitSet expected2 = LightSwitcher.toBit("10100101");
        Assert.assertEquals(result1, expected1);
        Assert.assertEquals(result2, expected2);

    }

    @Test
    public void testFlipSwitches2() {
        BitSet result3 = LightSwitcher.flipSwitches(baseByte, rightFourOnes);
        BitSet expected3 = LightSwitcher.toBit("10100101");
        BitSet result4 = LightSwitcher.flipSwitches(flippedBaseByte, rightFourOnes);
        BitSet expected4 = LightSwitcher.toBit("01011010");
        Assert.assertEquals(result3, expected3);
        Assert.assertEquals(result4, expected4);
    }

    @Test
    public void testFlipAllSwitches2() {
        BitSet result3 = LightSwitcher.flipAllSwitches(allOnes);
        BitSet result4 = LightSwitcher.flipAllSwitches(allZeroes);
        Assert.assertEquals(result3, allZeroes);
        Assert.assertEquals(result4, allOnes);
    }

    @Test
    public void testGetSwitchPositionAt() {
//        for(int i = 0; i < 8; i++) {
//            Assert.assertEquals(true, LightSwitcher.getSwitchPositionAt(baseByte, 8));
//        }
//        for(int i = 0; i < 8; i++) {
//            Assert.assertEquals((i + 1) % 2, LightSwitcher.getSwitchPositionAt(flippedBaseByte, 8));
//        }
        Assert.assertEquals(true, LightSwitcher.getSwitchPositionAt(LightSwitcher.toBit("11111110"), 0));
        Assert.assertEquals(false, LightSwitcher.getSwitchPositionAt(LightSwitcher.toBit("11110000"), 1));
        Assert.assertEquals(false, LightSwitcher.getSwitchPositionAt(LightSwitcher.toBit("11111110"), 7));
    }


//    @Test
//    public void testMoveRightBy() {
//        BitSet result1 = LightSwitcher.moveRightBy(baseByte, 1);
//        BitSet result2 = LightSwitcher.moveRightBy(baseByte, 2);
//        BitSet result3 = LightSwitcher.moveRightBy(baseByte, 3);
//        BitSet result4 = LightSwitcher.moveRightBy(baseByte, 4);
//        BitSet result5 = LightSwitcher.moveRightBy(baseByte, 5);
//        BitSet result6 = LightSwitcher.moveRightBy(baseByte, 6);
//        BitSet result7 = LightSwitcher.moveRightBy(baseByte, 7);
//        BitSet result8 = LightSwitcher.moveRightBy(baseByte, 8);
//        BitSet expected1 = 0b01010101;
//        BitSet expected2 = 0b00101010;
//        BitSet expected3 = 0b00010101;
//        BitSet expected4 = 0b00001010;
//        BitSet expected5 = 0b00000101;
//        BitSet expected6 = 0b00000010;
//        BitSet expected7 = 0b00000001;
//        BitSet expected8 = allZeroes;
//        Assert.assertEquals(result1, expected1);
//        Assert.assertEquals(result2, expected2);
//        Assert.assertEquals(result3, expected3);
//        Assert.assertEquals(result4, expected4);
//        Assert.assertEquals(result5, expected5);
//        Assert.assertEquals(result6, expected6);
//        Assert.assertEquals(result7, expected7);
//        Assert.assertEquals(result8, expected8);
//    }
//
//    @Test
//    public void testMoveLeftBy() {
//        BitSet result1 = LightSwitcher.moveLeftBy(baseByte, 1);
//        BitSet result2 = LightSwitcher.moveLeftBy(baseByte, 2);
//        BitSet result3 = LightSwitcher.moveLeftBy(baseByte, 3);
//        BitSet result4 = LightSwitcher.moveLeftBy(baseByte, 4);
//        BitSet result5 = LightSwitcher.moveLeftBy(baseByte, 5);
//        BitSet result6 = LightSwitcher.moveLeftBy(baseByte, 6);
//        BitSet result7 = LightSwitcher.moveLeftBy(baseByte, 7);
//        BitSet result8 = LightSwitcher.moveLeftBy(baseByte, 8);
//        BitSet expected1 = 0b01010100;
//        BitSet expected2 = 0b10101000;
//        BitSet expected3 = 0b01010000;
//        BitSet expected4 = 0b10100000;
//        BitSet expected5 = 0b01000000;
//        BitSet expected6 = 0b10000000;
//        BitSet expected7 = allZeroes;
//        BitSet expected8 = allZeroes;
//        Assert.assertEquals(result1, expected1);
//        Assert.assertEquals(result2, expected2);
//        Assert.assertEquals(result3, expected3);
//        Assert.assertEquals(result4, expected4);
//        Assert.assertEquals(result5, expected5);
//        Assert.assertEquals(result6, expected6);
//        Assert.assertEquals(result7, expected7);
//        Assert.assertEquals(result8, expected8);
//    }
//
//    @Test
//    public void testViewSwitches() {
//        Assert.assertEquals("11111111", LightSwitcher.viewSwitches(allOnes1111));
//        Assert.assertEquals("00000000", LightSwitcher.viewSwitches(0));
//        Assert.assertEquals("01010101", LightSwitcher.viewSwitches(0b111101010101));
//    }


}
