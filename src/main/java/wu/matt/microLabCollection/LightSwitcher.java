package wu.matt.microLabCollection;

import java.util.BitSet;

public class LightSwitcher {

    /**
     * Take a given input of switches, and the switches to turn on, and return the new state of the switches.
     * NOTE: If the initial state of a switch is already turned on, do not turn it off.
     */
    public static BitSet turnOnSwitches(BitSet switches, BitSet switchesToTurnOn) {
        switches.or(switchesToTurnOn);
        return switches;
    }

    /**
     * Take a given input of switches and turn them all to on.
     * Remember to use bit notation (0bxxxxxxxx) and a bit operator.
     */
    public static BitSet turnOnAllSwitches(BitSet switches) {
        switches.or(allOnes);
        return switches;
    }

    /**
     * Take a given input of switches and the switches to turn off, and return the new state of the switches.
     * NOTE: If a switch is already off, do not turn it on.
     * And a '1' in a position in 'switchesToTurnOff' means to turn that switch to off.
     */
    public static BitSet turnOffSwitches(BitSet switches, BitSet switchesToTurnOff) {
        switches.andNot(switchesToTurnOff);
        return switches;
    }

    /**
     * Take a given input of switches and turn them all off.
     * Remember to use bit notation and a bit operator.
     */
    public static BitSet turnOffAllSwitches(BitSet switches) {
        switches.and(allZeros);
        return switches;
    }

    /**
     * Take a given input of switches and the switches to flip, and return the new state of the switches.
     * NOTE: Wherever there is a '1' in switchesToFlip, flip the state of that switch in switches.
     * I.E switches = 1 0 1 and switchesToFlip = 1 1 0 should return 0 1 1.
     */
    public static BitSet flipSwitches(BitSet switches, BitSet switchesToFlip) {
        switches.xor(switchesToFlip);
        return switches;
    }

    /**
     * Take a given input of switches and flip them all.
     * NOTE: An BitSeteger has more than 8 bits, so find a way to only return the rightmost 8 bits.
     */
    public static BitSet flipAllSwitches(BitSet switches) {
        for(int i = 0; i < switches.length(); i++) {
            switches.flip(i);
        }
        return switches;
    }

    /**
     * Return the state of a switch in a given position.
     * Count switches from 0, and from right to left.
     * So, a byte reads 76543210
     */
    public static boolean getSwitchPositionAt(BitSet switches, int position) {
        return switches.get(position);
    }

    /**
     * Move all the the bits to the right `count` places.
     */
//    public static BitSet moveRightBy(BitSet switches, int count) {
//        return switches >> count;
//    }
//
//    /**
//     * Move all the the bits to the left `count` places.
//     * NOTE: An BitSeteger has more than 8 bits, so find a way to only return the rightmost 8 bits.
//     */
//
//    public static BitSet moveLeftBy(BitSet switches, BitSet count){
//        return switches << count & allOnes;
//    }
//
//    /**
//     * This is written for you to help with debugging.  If you call System.out.prBitSetln(viewSwitches(switches)),
//     * you can see the rightmost 8 bits of a given BitSeteger.
//
//    public static String viewSwitches(BitSet switches) {
//
//        return String.format("%8s", BitSeteger.toBinaryString((switches & allOnes))).replace(' ', '0');
//    }
//     */

    public static BitSet toBit(String numericalString){
        BitSet bitSet = new BitSet(numericalString.length());

        for (int i = numericalString.length()-1; i>=0  ; i--){
            if(numericalString.charAt(i)=='1'){
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    private static BitSet allOnes = toBit("11111111");
    private static BitSet allZeros = toBit("00000000");
    private static BitSet baseByte = toBit("10101010");

    public static void main(String[] args) {

        System.out.println(flipAllSwitches(baseByte));


    }




}
