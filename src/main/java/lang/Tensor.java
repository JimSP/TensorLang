package lang;

import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorSpecies;
import java.util.Arrays;

public class Tensor {
    private final double[] data;
    public static final VectorSpecies<Double> SPECIES = DoubleVector.SPECIES_PREFERRED;

    public Tensor(double[] data) {
        this.data = data;
    }

    public double[] getData() {
        return data;
    }

    public int length() {
        return data.length;
    }

    // Soma com suporte a broadcast
    public Tensor add(Tensor other) {
        int maxLength = Math.max(this.length(), other.length());
        double[] result = new double[maxLength];
        int i = 0;
        if (this.length() == other.length() && maxLength >= SPECIES.length()) {
            int loopBound = SPECIES.loopBound(maxLength);
            for (i = 0; i < loopBound; i += SPECIES.length()) {
                DoubleVector v1 = DoubleVector.fromArray(SPECIES, this.data, i);
                DoubleVector v2 = DoubleVector.fromArray(SPECIES, other.data, i);
                v1.add(v2).intoArray(result, i);
            }
        }
        for (; i < maxLength; i++) {
            double a = (i < this.length()) ? this.data[i] : this.data[0];
            double b = (i < other.length()) ? other.data[i] : other.data[0];
            result[i] = a + b;
        }
        return new Tensor(result);
    }

    // Subtração com suporte a broadcast
    public Tensor sub(Tensor other) {
        int maxLength = Math.max(this.length(), other.length());
        double[] result = new double[maxLength];
        int i = 0;
        if (this.length() == other.length() && maxLength >= SPECIES.length()) {
            int loopBound = SPECIES.loopBound(maxLength);
            for(i = 0; i < loopBound; i += SPECIES.length()){
                DoubleVector v1 = DoubleVector.fromArray(SPECIES, this.data, i);
                DoubleVector v2 = DoubleVector.fromArray(SPECIES, other.data, i);
                v1.sub(v2).intoArray(result, i);
            }
        }
        for (; i < maxLength; i++) {
            double a = (i < this.length()) ? this.data[i] : this.data[0];
            double b = (i < other.length()) ? other.data[i] : other.data[0];
            result[i] = a - b;
        }
        return new Tensor(result);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
