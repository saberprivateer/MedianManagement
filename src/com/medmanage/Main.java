package medmanage;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static ArrayList<Integer> lowHeap = new ArrayList<>();
    public static ArrayList<Integer> highHeap = new ArrayList<>();
    public static int sumMedians = 0;
    public static int n;
    public static String[] argInput;
    public static int hold;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void insertMax(int arg) {
        lowHeap.add(arg);
        int index = lowHeap.size() - 1;
        int parent;
        boolean notHeaped = true;
        while (notHeaped) {

            //First item added or top of the heap
            if (index == 0) {
                notHeaped = false;
            }

            //Check against parent
            if (notHeaped) {
                //Grab the parent
                if (index % 2 == 0) {
                    parent = (index / 2) - 1;
                } else {
                    parent = (index - 1) / 2;
                }
                if (lowHeap.get(parent) < lowHeap.get(index)) {
                    lowHeap.set(index, lowHeap.get(parent));
                    lowHeap.set(parent, arg);
                    index = parent;
                } else {
                    notHeaped = false;
                }
            }
        }
    }

    public static void insertMin(int arg) {
        highHeap.add(arg);
        int index = highHeap.size() - 1;
        int parent;
        boolean notHeaped = true;
        while (notHeaped) {

            //First item added or top of the heap
            if (index == 0) {
                notHeaped = false;
            }

            //Check against parent
            if (notHeaped) {
                //Grab the parent
                if (index % 2 == 0) {
                    parent = (index / 2) - 1;
                } else {
                    parent = (index - 1) / 2;
                }
                if (highHeap.get(parent) > highHeap.get(index)) {
                    highHeap.set(index, highHeap.get(parent));
                    highHeap.set(parent, arg);
                    index = parent;
                } else {
                    notHeaped = false;
                }
            }
        }
    }

    public static void extractMin() {
        hold = highHeap.get(0);
        int child1index = 1;
        int child2index = 2;
        int child1 = 0;
        int child2 = 0;
        boolean child1exists;
        boolean child2exists;
        int index = 0;
        boolean notHeaped = true;
        while (notHeaped) {

            //Are we at the last #?
            if (index >= highHeap.size()) {
                notHeaped = false;
            }

            //Compare to the level below
            if (notHeaped) {
                child1exists = false;
                child2exists = false;
                if (child2index < highHeap.size()) {
                    child2 = highHeap.get(child2index);
                    child1exists = true;
                }
                if (child1index < highHeap.size()) {
                    child2exists = true;
                    child1 = highHeap.get(child1index);
                }

                //First condition: both children exist
                if (child2exists & child1exists) {
                    if (child1 < child2) {
                        highHeap.set(index, child1);
                        index = child1index;
                    } else {
                        highHeap.set(index, child2);
                        index = child2index;
                    }
                }

                //Second condition: 
                if (!child1exists & !child2exists) {
                    notHeaped = false;
                }

            }
        }
    }

    public static void parse() {
        int next;
        for (int i = 0; i < n; i++) {
            next = Integer.parseInt(argInput[i]);
            insertMax(next);
        }
        for (int i = 0; i < n; i++) {
            next = Integer.parseInt(argInput[i]);
            insertMin(next);
        }

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        long startTime = System.nanoTime();

//        log("Begin Program");
//        log("End Program");
//        grabFile("Sample");
//        parse();
//        for (int i=0;i<lowHeap.size();i++){
//            System.out.print(lowHeap.get(i)+" ");
//        }
//        log("");
//
//        for (int i=0;i<lowHeap.size();i++){
//            System.out.print(highHeap.get(i)+" ");
//        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
//        log("Program ran for " + duration / 1000000 + " milliseconds");
    }

    public static void grabFile(String arg) throws IOException, URISyntaxException {
        argInput = new String[n];
        argInput = data(arg);
//        log(Arrays.toString(argInput));
//        log("n="+n);
    }


    public static String[] data(String datafile) throws URISyntaxException, IOException {
        //System.out.println("Opening " + datafile + ".");
        //Name of the file
        String filePath = new File("").getAbsolutePath();
        String fullPath = filePath + "/src/Files/" + datafile + ".txt";
        //System.out.println (filePath);

        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(fullPath)));
        lnr.skip(Long.MAX_VALUE);
        n = lnr.getLineNumber() + 1;
        //System.out.println(lnr.getLineNumber());
        //Add 1 because line index starts at 0
        // Finally, the LineNumberReader object should be closed to prevent resource leak
        String[] arr = new String[lnr.getLineNumber() + 1];
        lnr.close();
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(filePath + "/src/Files/" + datafile + ".txt");
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            int i;
            i = 0;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                arr[i] = line;
                i++;
                // System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        /*
        int[] arr = ints.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer i) {
                return i;
            }
        }).toArray(); */
        return arr;
    }


}
