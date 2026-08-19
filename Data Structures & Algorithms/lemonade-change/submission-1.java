class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {

            if (bill == 5) {
                fives++;

            } else if (bill == 10) {
                if (fives == 0) return false;
                tens++;
                fives--;
            
            } else if (bill == 20 && tens > 0 && fives > 0) {
                tens--;
                fives--;

            } else if (bill == 20 && fives >= 3) {
                fives -= 3;

            } else {
                return false;

            }
        }

        return true;
    }
}