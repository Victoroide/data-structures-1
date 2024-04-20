/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise2;

/**
 *
 * @author cvict
 */
public class Text {
    private char[] characters;
    private final int capacity = 128;
    private int length;

    public Text() {
        characters = new char[capacity];
        length = 0;
    }

    public void destroy() {
        length = 0;
    }

    public int size() {
        return length;
    }

    public char charAt(int position) {
        if (position >= 0 && position < length) {
            return characters[position];
        } else {
            throw new IndexOutOfBoundsException("Position out of range");
        }
    }

    public void addChar(char c) {
        if (length < capacity) {
            characters[length++] = c;
        } else {
            throw new IllegalStateException("Maximum capacity reached");
        }
    }

    public void removeChar() {
        if (length > 0) {
            length--;
        } else {
            throw new IllegalStateException("Text is already empty");
        }
    }

    public String toString() {
        return new String(characters, 0, length);
    }
}
