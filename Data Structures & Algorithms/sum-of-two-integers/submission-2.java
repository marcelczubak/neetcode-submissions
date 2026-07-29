class Solution {
    public int getSum(int a, int b) {

        int result = 0;
        int carry = 0;
        
        for (int i = 0; i < 32; i++) {

            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            int xor = bitA ^ bitB ^ carry;

            result |= (xor << i);

            if (xor == 0) {
                if (bitA == 1 || bitB == 1) carry = 1;
                else carry = 0;
            } else {
                if (bitA == 1 && bitB == 1) carry = 1;
                else carry = 0;
            }

        }

        return result;
    }
}
