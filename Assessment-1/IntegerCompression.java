import java.util.ArrayList;
import java.util.List;

public class IntegerCompression {

    // Encode integer using bitwise operations (Variable-length encoding)
    public static List<Byte> encodeInteger(int num) {
        List<Byte> encodedBytes = new ArrayList<>();

        while ((num & ~0x7F) != 0) { // Check if more bytes are needed
            encodedBytes.add((byte) ((num & 0x7F) | 0x80)); // Store 7 bits + continuation bit
            num >>= 7; // Shift 7 bits to the right
        }
        encodedBytes.add((byte) num); // Store last 7 bits

        return encodedBytes;
    }

    // Decode the compressed integer back to normal
    public static int decodeInteger(List<Byte> encodedBytes) {
        int num = 0, shift = 0;

        for (byte b : encodedBytes) {
            num |= (b & 0x7F) << shift; // Extract 7 bits and shift into position
            if ((b & 0x80) == 0) break; // If no continuation bit, stop
            shift += 7;
        }

        return num;
    }

    public static void main(String[] args) {
        int number = 1500; // Example number

        // Encoding
        List<Byte> encoded = encodeInteger(number);
        System.out.println("Encoded Bytes: " + encoded);

        // Decoding
        int decodedNumber = decodeInteger(encoded);
        System.out.println("Decoded Number: " + decodedNumber);
    }
}

/*4: Integer Compression Using Bitwise Operations
Approach:
Why Compress an Integer?

Large numbers take up more memory.

Compression reduces storage requirements.

Bitwise operations offer efficient encoding and decoding.

Concept of Encoding:

Store the integer in a variable-length format.

Use bit shifting (>>) and bit masking (&) to manipulate bits.

Encode only the necessary bits, reducing space.

Concept of Decoding:

Read stored bits and reconstruct the original number.*/


