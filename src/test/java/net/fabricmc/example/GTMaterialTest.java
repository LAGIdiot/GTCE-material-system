package net.fabricmc.example;

import net.fabricmc.example.material.GTMaterial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GTMaterialTest {
    @Test
    void createGTMaterialViaBuilderEmpty() {
        String name = "Test";

        GTMaterial material = (new GTMaterial.Builder(name)).build();

        assertEquals(name, material.name);
        assertEquals("", material.chemicalFormula);
    }

    @Test
    void createGTMaterialViaBuilderWithElement() {
        String name = "Test";
        String element = "O";

        GTMaterial material = (new GTMaterial.Builder(name)).element(element).build();

        assertEquals(name, material.name);
        assertEquals(element, material.chemicalFormula);
    }
}