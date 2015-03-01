/*
 * This is the fitness class. You must edit this class for your specific
 * application. My example is solving for Pi. 
 */
package geneticlearn;

import java.nio.ByteBuffer;

/**
 *
 * @author Nikolas
 */
public class Fitness {
    
    public static double findFitness(Individual Nik) {
        double score = 0;
        byte[] data = toByte(Nik.genes);
        double niksValue = toDouble(data);
        Nik.setValue(niksValue);
        score = 1 / Math.abs(Math.PI - niksValue);//Fitness is found just by taking the difference from pi and what each individual represents.
        return score;
    }
    
    public static byte[] toByte(String genes) {
        byte[] data = new byte[genes.length() / 8];
        for (int j = 0; j < data.length; j++) {
            byte tempByte = 0;
            for (byte i = 0; i < 8; i++) {
                if (genes.charAt(j * 8 + i) == '1') {
                    tempByte = (byte) (tempByte | (1 << i));
                } else {
                    tempByte = (byte) (tempByte & ~(1 << i));
                }
            }
            data[j] = tempByte;
        }
        
        return data;
    }
    
    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
}
