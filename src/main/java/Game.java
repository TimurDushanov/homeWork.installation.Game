import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Game {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Date date = new Date();
        createDirectory("C://Games1/src");
        createDirectory("C://Games1/res");
        createDirectory("C://Games1/savegames");
        createDirectory("C://Games1/temp");
        createDirectory("C://Games1/src/main");
        createDirectory("C://Games1/src/test");
        createFile("C://Games1/src/main/Main.java");
        createFile("C://Games1/src/main/Utils.java");
        createDirectory("C://Games1/res/drawables");
        createDirectory("C://Games1/res/vectors");
        createDirectory("C://Games1/res/icons");
        createFile("C://Games1/temp/temp.txt");
        System.out.println(stringBuilder);

        try (FileWriter writer = new FileWriter("C://Games1/temp/temp.txt", false)){
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDirectory(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            stringBuilder.append("Создан каталог " + path + " " + new Date() + "\n");
        } else {
            stringBuilder.append("Каталог " + path + " не создан" + new Date() + "\n");
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                stringBuilder.append("Файл " + file + " был создан " + new Date() + "\n");
            }
        } catch (IOException e) {
            stringBuilder.append("Файл " + file + " не был создан " + new Date() + "\n");
        }
    }

}