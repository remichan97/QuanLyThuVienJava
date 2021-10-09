/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.model;

/**
 *
 * @author Mirai
 */
public class ComboBoxData {
    private int value;
    private String label;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ComboBoxData() {
    }

    public ComboBoxData(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return label; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
