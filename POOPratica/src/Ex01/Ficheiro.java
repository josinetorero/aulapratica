package Ex01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ficheiro {
    private static final String FILE_NAME = "animais.dat";

    public static void salvar(List<Animal> animais) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(animais);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Animal> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Animal>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
