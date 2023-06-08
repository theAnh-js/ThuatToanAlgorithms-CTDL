public class SampleString {

    public static void main(String[] args) {
        String s = "sampleString12345";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                System.out.println(c);
            }
        }
    }
}
