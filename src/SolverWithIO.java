import java.util.*;
import java.io.*;
public class SolverWithIO{
    public static void main(String [] args){
        Scanner nots = new Scanner(System.in);
        char[][] wordSearch;
        String[] words;
        System.out.println("Enter word file location");
        String wordFile = nots.next();
        words = inputWords(wordFile);
        System.out.println("Enter word search file location");
        String searchFile = nots.next();
        wordSearch = inputSearch(searchFile);
        solve(wordSearch, words);
    }
    public static char[][] inputSearch(String file){
        String inputRow = "";
        try {
            Scanner nots = new Scanner(new File (file));
            int column = nots.nextInt();
            int row = nots.nextInt();
            char[][] inputArray = new char[column][row];
            for (int index = 0; index < inputArray.length; index++) {
                inputRow = nots.next();
                inputArray[index] = inputRow.toCharArray();
            }
            return inputArray;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return new char[0][0];
    }
    public static String[] inputWords(String file){
        try {
            Scanner nots = new Scanner(new File(file));
            int wordNumber = nots.nextInt();
            String[] words = new String[wordNumber];
            while (nots.hasNextLine()) {
                for (int index = 0; index < words.length; index++) {
                    words[index] = nots.next();
                }
            }
            return words;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
    public static void solve(char wordSearch[][], String[] words){
        String[] solution = new String[words.length];
        for (int index = 0; index < solution.length; index++){
            solution[index] = find(words[index], wordSearch);
        }
        for (int index = 0; index < solution.length; index++) System.out.println(words[index] + ": " + solution[index]);

    }
    public static String find(String word, char[][] crossword){
        for (int index = 0; index < crossword.length; index++){
            for (int twoIndex = 0; twoIndex < crossword[index].length; twoIndex++){
                String right = "";
                String rightPos = "";
                String left = "";
                String leftPos = "";
                String up = "";
                String upPos = "";
                String down = "";
                String downPos = "";
                String rUp = "";
                String rUpPos = "";
                String lUp = "";
                String lUpPos = "";
                String rDown = "";
                String rDownPos = "";
                String lDown = "";
                String lDownPos = "";
                for (int i = 0; i < word.length(); i++){
                    if (twoIndex + i < crossword[index].length){
                        right = right + crossword[index][twoIndex+i];
                        rightPos = rightPos + "[" + (index) + "][" + (twoIndex+i) + "] ";
                    }
                    if (twoIndex - i > 0){
                        left = left + crossword[index][twoIndex-i];
                        leftPos = leftPos + "[" + (index) + "][" + (twoIndex-i) + "] ";
                    }
                    if (index - i > 0){
                        up = up + crossword[index-i][twoIndex];
                        upPos = upPos + "[" + (index-i) + "][" + (twoIndex) + "] ";
                    }
                    if (index + i < crossword.length){
                        down = down + crossword[index+i][twoIndex];
                        downPos = downPos + "[" + (index+i) + "][" + (twoIndex) + "] ";
                    }
                    if (index - i > 0 && twoIndex + i < crossword[index].length){
                        rUp = rUp + crossword[index-i][twoIndex+i];
                        rUpPos = rUpPos + "[" + (index-i) + "][" + (twoIndex+i) + "] ";
                    }
                    if (index - i > 0 && twoIndex - i > 0){
                        lUp = lUp + crossword[index-i][twoIndex-i];
                        lUpPos = lUpPos + "[" + (index-i) + "][" + (twoIndex-i) + "] ";
                    }
                    if (index + i < crossword.length && twoIndex + i < crossword[index].length){
                        rDown = rDown + crossword[index+i][twoIndex+i];
                        rDownPos = rDownPos + "[" + (index+i) + "][" + (twoIndex+i) + "] ";
                    }
                    if (index + i < crossword.length && twoIndex - i > 0){
                        lDown = lDown + crossword[index+i][twoIndex-i];
                        lDownPos = lDownPos + "[" + (index+i) + "][" + (twoIndex-i) + "] ";
                    }
                }
                char[] wordArray = new char[word.length()];
                wordArray = word.toCharArray();
                char[] rightArray = new char[right.length()];
                rightArray = right.toCharArray();
                char[] leftArray = new char[left.length()];
                leftArray = left.toCharArray();
                char[] upArray = new char[up.length()];
                upArray = up.toCharArray();
                char[] downArray = new char[down.length()];
                downArray = down.toCharArray();
                char[] rUpArray = new char[rUp.length()];
                rUpArray = rUp.toCharArray();
                char[] lUpArray = new char[lUp.length()];
                lUpArray = lUp.toCharArray();
                char[] rDownArray = new char[rDown.length()];
                rDownArray = rDown.toCharArray();
                char[] lDownArray = new char[lDown.length()];
                lDownArray = lDown.toCharArray();
                if (wordArray.length == rightArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < rightArray.length; foundIndex++){
                        if (wordArray[foundIndex] == rightArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return rightPos;
                    }
                }
                if (wordArray.length == leftArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < leftArray.length; foundIndex++){
                        if (wordArray[foundIndex] == leftArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return leftPos;
                    }
                }
                if (wordArray.length == upArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < upArray.length; foundIndex++){
                        if (wordArray[foundIndex] == upArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return upPos;
                    }
                }
                if (wordArray.length == downArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < downArray.length; foundIndex++){
                        if (wordArray[foundIndex] == downArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return downPos;
                    }
                }
                if (wordArray.length == rUpArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < rUpArray.length; foundIndex++){
                        if (wordArray[foundIndex] == rUpArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return rUpPos;
                    }
                }
                if (wordArray.length == lUpArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < lUpArray.length; foundIndex++){
                        if (wordArray[foundIndex] == lUpArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return lUpPos;
                    }
                }
                if (wordArray.length == rDownArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < rDownArray.length; foundIndex++){
                        if (wordArray[foundIndex] == rDownArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return rDownPos;
                    }
                }
                if (wordArray.length == lDownArray.length){
                    int wordLength = 0;
                    for (int foundIndex = 0; foundIndex < lDownArray.length; foundIndex++){
                        if (wordArray[foundIndex] == lDownArray[foundIndex]) wordLength++;
                    }
                    if (wordLength == word.length()){
                        return lDownPos;
                    }
                }
            }
        }
        return "Not Found";
    }
}
