package disk.space.analysis.jobsity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> space = IntStream.range(0, spaceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.segment(x, spaceCount, space);

//     bufferedWriter.write(String.valueOf(result));
//     bufferedWriter.newLine();

        bufferedReader.close();
//      bufferedWriter.close();
        System.out.println(result);
    }
	

}
