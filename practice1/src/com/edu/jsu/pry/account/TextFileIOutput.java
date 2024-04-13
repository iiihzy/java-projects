package com.edu.jsu.pry.account;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class TextFileIOutput {
    public void textFileIOutput(ArrayList<User> list) throws IOException {
        ObjectOutputStream oos;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("b.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (User user : list) {
            oos.writeObject(user);
        }

        oos.close();

    }
}
