package com.collection.sc;

import java.io.InputStream;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput(InputStream in) {
        scanner = new Scanner(in);
    }

    public int getInt() {
        System.out.print(" >> ");
        return scanner.nextInt();
    }
}
