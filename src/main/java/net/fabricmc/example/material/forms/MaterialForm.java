package net.fabricmc.example.material.forms;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public record MaterialForm(String name, int materialAmount) {
    public static List<MaterialForm> register = new ArrayList<>();

    public MaterialForm {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name can't be null or empty");

        if (materialAmount <= 0)
            throw new IllegalArgumentException("Material amount has to be a positive number");

        if (register.contains(this)) //TODO check only name
            throw new IllegalArgumentException("Can't register same Material form more then ones");

        register.add(this);
    }

    public ImmutableList<MaterialForm> getRegister(){
        return ImmutableList.copyOf(register);
    }
}
