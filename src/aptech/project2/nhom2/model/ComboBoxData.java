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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComboBoxData other = (ComboBoxData) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
    
}
