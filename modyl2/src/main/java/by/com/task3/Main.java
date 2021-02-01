package by.com.task3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Описание: SuffixingApp With Maven
 * Используйте maven для создания и управления простой программой Java с зависимостями.
 * Спецификация приложения:
 * Это приложение с суффиксами - небольшое Java-приложение, которое обращается к файлу конфигурации,
 * переименовывает набор файлов и переименовывает их, добавляя суффикс, указанный в той же конфигурации.
 * Детали:
 * Приложение должно прочитать файл конфигурации при запуске
 * Затем он должен убедиться, что все файлы из конфигурации существуют.
 * Затем он должен переименовать каждый файл, добавив суффикс из конфигурации к его имени
 * Он должен напечатать результаты переименования, например:   old_name -> new_name.
 * Шаги:
 * Создайте проект maven и укажите его настройки GAV, кодировку, уровень языка и т. Д.
 * Добавьте зависимость к некоторой библиотеке для чтения и анализа файлов JSON. (например, GSON)
 * Напишите код, реализующий спецификацию приложения.
 * Настройте проект maven для создания работающего jar-файла,содержащего приложение и его зависимости.
 */
public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("D:\\Maven\\modyl2\\target\\maven-archiver\\pom.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File oldFile1 = new File("D:\\Maven\\modyl2\\src\\main\\resources\\configuration\\old_file1.json");
        File oldFile2 = new File("D:\\Maven\\modyl2\\src\\main\\resources\\configuration\\old_file2.json");

        String file1 = properties.getProperty("file1");
        if (oldFile1.canRead() && file1.equals(oldFile1.getAbsolutePath())) {
            System.out.println(file1 + " - " + true);
        } else {
            System.out.println(file1 + " - " + false);
        }
        String file2 = properties.getProperty("file2");
        if (oldFile2.canRead() && file2.equals(oldFile2.getAbsolutePath())) {
            System.out.println(file2 + " - " + true);
        } else {
            System.out.println(file2 + " - " + false);
        }
        String suffix = properties.getProperty("suffix");
        String path = properties.getProperty("path");

        oldFile1.renameTo(new File(path + suffix + "_file1.json"));
        oldFile2.renameTo(new File(path + suffix + "_file2.json"));

        File resources = new File("D:\\Maven\\modyl2\\src\\main\\resources");
        System.out.println(Arrays.toString(resources.list()));
    }
}