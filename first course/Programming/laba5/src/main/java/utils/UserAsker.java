package utils;

import java.io.BufferedReader;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Asks a user a marine's value.
 */
public class UserAsker {
    private BufferedReader userScanner;
    private boolean fileMode;

    public UserAsker(BufferedReader userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }
    public void setUserScanner(BufferedReader userScanner) {
        this.userScanner = userScanner;
    }

    public BufferedReader getUserScanner() {
        return userScanner;
    }

    public void setFileMode() {
        fileMode = true;
    }

    public void setUserMode() {
        fileMode = false;
    }


    @Override
    public String toString() {
        return "UserAsker (вспомогательный класс для запросов пользователю)";
    }
}