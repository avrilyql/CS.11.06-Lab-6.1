import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);

        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);

        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);

        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
       int[] depths = readFile(fileName);
       int count = 0;
       for (int i = 1; i<depths.length; i++) {
           if (depths[i]>depths[i-1]) {
               count++;
           }
       }
       return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] depths = readFile(fileName);
        int count = 0;
        for (int i = 1; i<depths.length-2; i++) {
            int depthsNow = depths[i] + depths[i+1] + depths[i+2];
            int depthsBefore = depths[i-1] + depths[i] + depths[i+1];
            if (depthsNow>depthsBefore) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int hor = 0;
        int depth = 0;
        String[] directions = readFileString(fileName);
        for (int i = 0; i<directions.length; i++) {
            String[] where = directions[i].split(" ");
            if (where[0].equals("forward")) {
                hor += parseInt(where[1]);
            }
            else if (where[0].equals("up")) {
                depth += parseInt(where[1]);
            }
            else {
                depth -= parseInt(where[1]);
            }
        }
        int product = (hor)*(depth);
        return product;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int hor = 0;
        int depth = 0;
        int aim = 0;
        String[] directions = readFileString(filename);
        for (int i = 0; i<directions.length; i++) {
            String[] where = directions[i].split(" ");
            if (where[0].equals("down")) {
                aim += parseInt(where[1]);
            }
            else if (where[0].equals("up")) {
                aim -= parseInt(where[1]);
            }
            else {
                hor += parseInt(where[1]);
                depth = aim * parseInt(where[1]);
            }
        }
        return hor * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFileString(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInStrFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInStrFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}