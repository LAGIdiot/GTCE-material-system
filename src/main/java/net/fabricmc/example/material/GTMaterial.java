package net.fabricmc.example.material;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.example.CountableGTMaterial;
import net.fabricmc.example.material.flags.MaterialFlag;
import net.fabricmc.example.material.flags.MaterialFlags;
import net.fabricmc.example.material.forms.MaterialForm;
import net.fabricmc.example.material.properties.MaterialToolProperties;
import net.fabricmc.example.material.properties.MaterialWireProperties;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class GTMaterial {
    private static final List<GTMaterial> register = new ArrayList<>();

    public final String chemicalFormula;
    public final String name;
    public Dictionary<MaterialFlag<?>, Object> materialFlags;
    public List<MaterialForm> materialForms;

    private GTMaterial(String chemicalFormula, String name, Dictionary<MaterialFlag<?>, Object> materialFlags, List<MaterialForm> materialForms) {
        this.chemicalFormula = chemicalFormula;
        this.name = name;
        this.materialFlags = materialFlags;
        this.materialForms = materialForms;

        if (!register.contains(this)) {
            register.add(this);
        }
    }

//    public ImmutableMap<MaterialFlag<?>, Object> getMaterialFlags() {
//        return ImmutableMap.copyOf(materialFlags);
//    }

    public ImmutableList<MaterialForm> getMaterialForms(){
        return ImmutableList.copyOf(materialForms);
    }

    public static class Builder {
        private final String name;

        private String chemicalFormula;
        private boolean isCompound;

        private Dictionary<MaterialFlag<?>, Object> flags;
        private List<MaterialForm> forms;

        public Builder(String name) {
            this.name = name;
            this.flags = new Hashtable<>();
            this.forms = new ArrayList<>();
            this.chemicalFormula = "";
            this.isCompound = true;
        }

        public GTMaterial.Builder element(String element) {
            this.chemicalFormula = element;
            this.isCompound = false;
            return this;
        }

        public GTMaterial.Builder compound(ImmutableList<CountableGTMaterial> materials) {
            for (CountableGTMaterial material : materials) {
                chemicalFormula += material.material().chemicalFormula + material.amount();
            }
            this.isCompound = true;
            return this;
        }

        public GTMaterial.Builder canCreateTools(float toolSpeed, float toolAttackDamage, int toolDurability) {
            addFlag(MaterialFlags.CAN_CREATE_TOOLS, new MaterialToolProperties(toolSpeed, toolAttackDamage, toolDurability));
            return this;
        }

        public GTMaterial.Builder canCreateTools(MaterialToolProperties materialToolProperties) {
            addFlag(MaterialFlags.CAN_CREATE_TOOLS, materialToolProperties);
            return this;
        }

        public GTMaterial.Builder canCreateWire(int voltage, int baseAmperage, int lossPerBlock) {
            addFlag(MaterialFlags.CAN_CREATE_WIRE, new MaterialWireProperties(voltage, baseAmperage, lossPerBlock));
            return this;
        }

        public GTMaterial.Builder canCreateWire(MaterialWireProperties materialWireProperties) {
            addFlag(MaterialFlags.CAN_CREATE_WIRE, materialWireProperties);
            return this;
        }

        private void addFlag(MaterialFlag<?> flag, Object value) {
            if (flags.get(flag) != null) {
                this.flags.put(flag, value);
                addMaterialForms(flag.getMaterialForms());
            }
        }

        private void addMaterialForms(List<MaterialForm> materialForms) {
            for (MaterialForm form : materialForms) {
                if (!forms.contains(form)) {
                    this.forms.add(form);
                }
            }
        }

        public GTMaterial build() {
            //verify integrity
            return new GTMaterial(chemicalFormula, name, flags, forms);
        }
    }
}
