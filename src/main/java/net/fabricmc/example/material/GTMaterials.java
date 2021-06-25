package net.fabricmc.example.material;

import com.google.common.collect.ImmutableList;
import net.fabricmc.example.CountableGTMaterial;

public class GTMaterials {
    GTMaterial hydrogen = (new GTMaterial.Builder("Hydrogen").element("H")).build();
    GTMaterial oxygen = (new GTMaterial.Builder("Oxygen").element("O")).build();
    GTMaterial water = (new GTMaterial.Builder("Water").compound(ImmutableList.of(new CountableGTMaterial(hydrogen, 2), new CountableGTMaterial(oxygen, 2)))).build();

    GTMaterial copper =
            (new GTMaterial.Builder("Copper")
                    .element("Cu")
                    .canCreateTools(12.0f, 3.0f, 512)
                    .canCreateWire(128, 1, 2)
                    .build());
}
