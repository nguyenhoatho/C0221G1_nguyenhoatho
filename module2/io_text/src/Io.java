import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Io {
    public static boolean SavaFile(ArrayList<String>dsData, String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            for (String data:dsData){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;

        }catch (Exception ex){
            ex.printStackTrace();

        }
        return false ;
    }
    public static ArrayList<String> ReadFile(String path_copy){
        ArrayList<String> dsData=new ArrayList<>();
        try {
            FileInputStream fileInputStream=new FileInputStream(path_copy);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,StandardCharsets.UTF_8);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line=bufferedReader.readLine();
            while (line!=null){
                if (line.length()>0){
                    dsData.add(line);
                    line=bufferedReader.readLine();
                }

            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();

        }
        return dsData;

    }
}
