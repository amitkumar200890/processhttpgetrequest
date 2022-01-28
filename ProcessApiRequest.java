package com.apiprocess.utility;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProcessApiRequest {
    static Map<String, String> hMap = new LinkedHashMap<>();
    public static void main(String[] args){
        int threadPool = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPool);

        File file = new File(args[0]);

        // Creating an object of BufferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (true && br != null){
            try {
                String str = br.readLine();
                if (str == null) break;
                str = str.trim();

                if(hMap.containsKey(str)) continue;

                hMap.put(str+"", "");
                executorService.submit(new utilityThread(str));

            } catch (IOException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(100*5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the id and output
        hMap.forEach((Key, value)->
                System.out.println("Input id: "+Key+"  : Response String:  "+value));
    }
}
