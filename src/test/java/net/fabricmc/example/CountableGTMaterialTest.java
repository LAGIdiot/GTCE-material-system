package net.fabricmc.example;

import net.fabricmc.example.material.GTMaterial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountableGTMaterialTest {

    GTMaterial Oxygen = (new GTMaterial.Builder("Oxygen").element("O").build());

    @Test
    void material() {
        CountableGTMaterial countableGTMaterial = new CountableGTMaterial(Oxygen, 1);

        assertEquals(Oxygen, countableGTMaterial.material());
    }

    @Test
    void amount() {
        CountableGTMaterial countableGTMaterial = new CountableGTMaterial(Oxygen, 1);

        assertEquals(1, countableGTMaterial.amount());
    }
}