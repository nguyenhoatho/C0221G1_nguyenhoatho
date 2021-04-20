package repository;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface funcWriteAndReadFileCsv<T> {
    Set<String> getNameServiceFromFileCsv(String path);
    void WriteFileCsv(T t);
    List<T> readCsvFile();
    TreeSet<T> readFileCsvNotDuplicate();
}