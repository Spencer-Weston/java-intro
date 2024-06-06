import org.jetbrains.annotations.NotNull;

public class Fraction extends Number implements Comparable<Fraction>{

    private Integer numerator;
    private Integer denominator;

    private Float floatValue = 22.0F;

    private Integer anInt=11;

    private Float something = floatValue * anInt;


    public Fraction(Integer num, Integer den) {
        this.numerator = num;
        this.denominator = den;
    }

    public Fraction(Integer num) {
        this.numerator = num;
        this.denominator = 1;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public Fraction add(@NotNull Fraction other) {
        Integer newNum = other.getDenominator()*this.numerator + this.denominator*other.getNumerator();
        Integer newDen = this.denominator * other.getDenominator();
        Integer common = gcd(newNum,newDen);
        return new Fraction(newNum/common, newDen/common );
    }

    public Fraction add(Integer other) {
        return add(new Fraction(other));
    }

    private static Integer gcd(Integer m, Integer n) {
        while (m % n != 0) {
            Integer oldm = m;
            Integer oldn = n;
            m = oldn;
            n = oldm%oldn;
        }
        return n;
    }

    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    public void printSomething() {
        System.out.println(something);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);

        System.out.println(f1.add(1));
        System.out.println(f1);

        f1.printSomething();
    }

    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }


    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }


    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }


    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    @Override
    public int compareTo(@NotNull Fraction other) {
        Integer num1 = this.numerator * other.getDenominator();
        Integer num2 = this.denominator * other.getNumerator();
        return num1 - num2;
    }
}
