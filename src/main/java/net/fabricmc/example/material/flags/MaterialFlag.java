package net.fabricmc.example.material.flags;

import com.google.common.collect.ImmutableList;
import net.fabricmc.example.material.forms.MaterialForm;
import org.jetbrains.annotations.NotNull;

public class MaterialFlag<T> {
    //registry

    String name;
    T dataType;
    ImmutableList<MaterialForm> materialForms;

    public MaterialFlag(String name, T dataType, @NotNull ImmutableList<MaterialForm> requiredMaterialForms) {
        this.name = name;
        this.dataType = dataType;
        this.materialForms = requiredMaterialForms;
    }

    public MaterialFlag(String name, T dataType) {
        this(name, dataType, ImmutableList.of());
    }

    public T getData(Object data) {
        return (T) data;
    }

    public ImmutableList<MaterialForm> getMaterialForms() {
        return materialForms;
    }

}
