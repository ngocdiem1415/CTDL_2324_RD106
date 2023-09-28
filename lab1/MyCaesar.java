package lab1;

public class MyCaesar {
    public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'
            , 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int n;

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    public char encryptChar(char c) throws Exception {
        int index = -1;
        if (Character.isLetter(c)) {
            char upperC = Character.toUpperCase(c);
            index = ((upperC + n) % 26);
            if (index > 26 || index < 0) {
                throw new Exception("out of bound!");
            }
        }
        return ALPHABET[index];
    }

    public String encrypt(String input) throws Exception {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                result += " ";
            } else {
                result += encryptChar(ch);
            }
        }
        return result;
    }

    public char decryptChar(char c) throws Exception {
        int index = -1;
        char decrypt = ' ';
        if (Character.isLetter(c)) {
            char upperC = Character.toUpperCase(c);
            for (int i = 0; i < ALPHABET.length; i++) {
                if (upperC == ALPHABET[i]) {
                    index = i;
                    if (index < 0 || index > 26) {
                        throw new Exception("out of bound!");
                    } else {
                        int temp = (index - n + 26) % 26;
                        while ( temp < 65 ){
                            temp += 26;
                        }
                        decrypt += (char) Character.toUpperCase(temp);
                    }
                }
            }
        }
        return decrypt;
    }

    public String decrypt(String input) throws Exception {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                result += " ";
            } else {
                result += decryptChar(ch);
            }
        }
        return result;
    }

    //advanced task3
//    public String encryCharA (String c, int n){
//        String result = "";
//        for ( int i =0; i < c.length(); i ++){
//            char ch = c. charAt(i);
//            if ( ch == ' '){
//                result += " ";
//            }else{
//                if ( (int)( (ch + n)% 26) >=90){
//                    result +=
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        MyCaesar test = new MyCaesar(3);
//        System.out.println(test.encryptChar(ALPHABET[0]));
//        System.out.println(test.encrypt("HELLO HAHAA"));
//        System.out.println(test.decrypt("XUBBE XQXQQ"));
    }
}
