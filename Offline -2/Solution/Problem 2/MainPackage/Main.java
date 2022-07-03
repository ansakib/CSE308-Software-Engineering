package MainPackage;

import EditorPackage.Editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter File Name: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();

        Editor editor = Editor.getInstance();
        editor.createEditor(filename);
    }
}
