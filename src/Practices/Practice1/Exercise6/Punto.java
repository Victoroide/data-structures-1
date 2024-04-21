/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practices.Practice1.Exercise6;

/**
 *
 * @author cvict
 */
import java.awt.Color;

public class Punto {
    private int x;
    private int y;
    private Color color;
    private int size;
    private boolean visible;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK; // Default color
        this.size = 1; // Default size
        this.visible = true; // Visible by default
    }

    public void movePoint(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public void setSize(int newSize) {
        this.size = newSize;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        String visibilityText = visible ? "visible" : "no visible";
        return String.format("Punto en (%d, %d)\nColor: %s (%s)\nTamaño: %d\nVisible: %s",
                             x, y, getColorName(color), getColorHex(color), size, visibilityText);
    }

    private String getColorName(Color color) {
        if (Color.BLACK.equals(color)) return "Negro";
        if (Color.RED.equals(color)) return "Rojo";
        if (Color.GREEN.equals(color)) return "Verde";
        if (Color.BLUE.equals(color)) return "Azul";
        // More colors can be added
        return "Desconocido";
    }

    private String getColorHex(Color color) {
        return String.format("#%06X", color.getRGB() & 0xFFFFFF);
    }
}
