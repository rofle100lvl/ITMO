package utils;

import java.io.BufferedReader;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Класс, содержащий сканер для считывания с потока
 */
public class UserAsker {
    private BufferedReader userScanner;
    private boolean fileMode;

    public UserAsker(BufferedReader userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    public boolean isFileMode() {
        return fileMode;
    }

    public void setFileMode(boolean fileMode) {
        this.fileMode = fileMode;
    }

    public void setUserScanner(BufferedReader userScanner) {
        this.userScanner = userScanner;
    }

    public BufferedReader getUserScanner() {
        return userScanner;
    }

    @Override
    public String toString() {
        return "UserAsker (вспомогательный класс для запросов пользователю)";
    }
}