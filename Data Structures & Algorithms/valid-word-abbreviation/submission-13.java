class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        int wordPointer = 0;
        int abbrPointer = 0;

        while (wordPointer < word.length() && abbrPointer < abbr.length()) {

            char c = abbr.charAt(abbrPointer);

            // Character match
            if (Character.isLetter(c)) {

                if (word.charAt(wordPointer) != c) {
                    return false;
                }

                wordPointer++;
                abbrPointer++;

            } 
            // Number abbreviation
            else {

                // Leading zero
                if (c == '0') return false;
            
                int skip = 0;

                while (abbrPointer < abbr.length() 
                    && Character.isDigit(abbr.charAt(abbrPointer))) {

                    skip *= 10;
                    skip += (abbr.charAt(abbrPointer) - '0');

                    abbrPointer++;
                }
                wordPointer += skip;
            }
        }
        return (wordPointer == word.length() && abbrPointer == abbr.length());
    }
}