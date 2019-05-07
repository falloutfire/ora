package com.math.epidemic.Entities;

import javafx.beans.property.*;

public class VirusDto {

    private LongProperty id;
    private StringProperty name;
    private StringProperty strain;
    private FloatProperty lethal;

    private FloatProperty influence;
    private FloatProperty chance;
    private FloatProperty evol_rate;
    private FloatProperty cure_rate;
    private FloatProperty endurance;

    public VirusDto() {
        this.id = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.strain = new SimpleStringProperty();
        this.lethal = new SimpleFloatProperty();
        this.influence = new SimpleFloatProperty();
        this.evol_rate = new SimpleFloatProperty();
        this.cure_rate = new SimpleFloatProperty();
        this.chance = new SimpleFloatProperty();
        this.endurance = new SimpleFloatProperty();
    }


    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStrain() {
        return strain.get();
    }

    public StringProperty strainProperty() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain.set(strain);
    }

    public float getLethal() {
        return lethal.get();
    }

    public FloatProperty lethalProperty() {
        return lethal;
    }

    public void setLethal(float lethal) {
        this.lethal.set(lethal);
    }


    public float getInfluence() {
        return influence.get();
    }

    public FloatProperty influenceProperty() {
        return influence;
    }

    public void setInfluence(float influence) {
        this.influence.set(influence);
    }

    public float getChance() {
        return chance.get();
    }

    public FloatProperty chanceProperty() {
        return chance;
    }

    public void setChance(float chance) {
        this.chance.set(chance);
    }

    public float getEvol_rate() {
        return evol_rate.get();
    }

    public FloatProperty evol_rateProperty() {
        return evol_rate;
    }

    public void setEvol_rate(float evol_rate) {
        this.evol_rate.set(evol_rate);
    }

    public float getCure_rate() {
        return cure_rate.get();
    }

    public FloatProperty cure_rateProperty() {
        return cure_rate;
    }

    public void setCure_rate(float cure_rate) {
        this.cure_rate.set(cure_rate);
    }

    public float getEndurance() {
        return endurance.get();
    }

    public FloatProperty enduranceProperty() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance.set(endurance);
    }
}
