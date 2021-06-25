package net.fabricmc.example.material.flags;

import com.google.common.collect.ImmutableList;
import net.fabricmc.example.material.forms.MaterialForms;
import net.fabricmc.example.material.properties.MaterialToolProperties;
import net.fabricmc.example.material.properties.MaterialWireProperties;

public class MaterialFlags {
    public static final MaterialFlag<?> CAN_CREATE_TOOLS =
            new MaterialFlag<>("CAN CREATE TOOLS", MaterialToolProperties.class, ImmutableList.of(MaterialForms.PLATE, MaterialForms.INGOT));
    public static final MaterialFlag<?> CAN_CREATE_WIRE =
            new MaterialFlag<>("CAN CREATE WIRE", MaterialWireProperties.class, ImmutableList.of(MaterialForms.WIRE));

    private MaterialFlags() {
    }
}
