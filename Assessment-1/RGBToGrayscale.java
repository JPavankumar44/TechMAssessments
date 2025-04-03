public class RGBToGrayscale {
    public static int convertToGrayscale(int r, int g, int b) {
        return ( (r * 77 + g * 150 + b * 29) >> 8 ); // Bitwise approximation
    }

    public static void main(String[] args) {
        int r = 120, g = 200, b = 150; // Sample RGB values

        int grayscale = convertToGrayscale(r, g, b);

        System.out.println("Grayscale Value: " + grayscale);
    }
}
/*3: Convert RGB Color Values to Grayscale Using Bitwise Operations
Why Convert RGB to Grayscale?
In image processing, converting a colored image to grayscale simplifies the data, reducing complexity while preserving essential details. Grayscale images are widely used in:

Machine learning (e.g., OCR, face recognition)

Image compression

Edge detection algorithms

Understanding Grayscale Conversion
A grayscale value represents the brightness of a pixel without color. The standard formula for grayscale conversion is:

Gray=  0.3𝑅+0.59𝐺+0.11𝐵
        Gray=0.3R+0.59G+0.11B
where:

R (Red) contributes 30% of the brightness,

G (Green) contributes 59% (most dominant),

B (Blue) contributes 11%.

However, floating-point multiplication is computationally expensive. Instead, we approximate using bitwise operations, which are much faster.*/

