import java.util.Arrays;

class AsciiCharSequence implements CharSequence {

    byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray.clone();
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int i) {
        return (char) byteArray[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(byteArray, i, i1));
    }

    @Override
    public String toString() {
        return new String(this.byteArray, 0, this.length());
    }
}