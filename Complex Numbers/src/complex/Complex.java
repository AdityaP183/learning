package complex;

public class Complex {
    private double realPart;
    private double imaginaryPart;


    public Complex() {
        this.realPart = 0;
        this.imaginaryPart = 0;
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex other) {
        return new Complex(
                this.realPart + other.realPart,
                this.imaginaryPart + other.imaginaryPart
        );
    }

    public Complex subtract(Complex other) {
        return new Complex(
                this.realPart - other.realPart,
                this.imaginaryPart - other.imaginaryPart
        );
    }

    public Complex multiply(Complex other) {
        double real = (this.realPart * other.realPart) - (this.imaginaryPart * other.imaginaryPart);
        double imag = (this.realPart * other.imaginaryPart) + (this.imaginaryPart * other.realPart);

        return new Complex(real, imag);
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
}
