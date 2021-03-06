package com.math.epidemic.Controller;

public class Dif {
    int arrayLenght = 3;
    int n = 100;
    double[][] model = new double[arrayLenght][n];
    float step = (float) 0.25;
    float population;
    float pop;
    float death_total;
    float born_total;

    public void Null() {

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= arrayLenght - 1; j++) {
                model[j][i] = 0;
            }
        }
    }

    public void initialize() {

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= arrayLenght; j++) {
                model[j][i] = 0;
            }
        }
    }

    public double[][] SIR(float startS, float startI, float startR, float contact, float influenceTime) {

        Null();
        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;

            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1]);
            }

        }

        Round();
        return (model);
    }

    public double[][] SIRmod(float startS, float startI, float startR, float contact, float influenceTime, float birthCoef) {
        Null();
        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                population = startS + startI + startR;
            } else {

                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]));
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1] - birthCoef * model[2][i - 1]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIS(float startS, float startI, float contact, float influenceTime, float birthCoef) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                population = startS + startI;
            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]) + influenceTime * model[1][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIRS(float startS, float startI, float startR, float contact, float influenceTime, float birthCoef, float lossOfImmunity) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                population = startS + startI + startR;

            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]) + lossOfImmunity * model[2][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1] - birthCoef * model[2][i - 1] - lossOfImmunity * model[2][i - 1]);

            }
        }
        Round();
        return (model);
    }

    public double[][] Ver(float startS, float startI, float startR, float population, float born, float death, float deathvirus, float lambda, float p, float ratio, float contact) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;


            } else {
                // System.out.println("lambda " + n +" : " + lambda);
                //L
                model[0][i] = model[0][i - 1] + step * ((1 - p) * lambda * model[2][i - 1] - ratio * model[0][i - 1] - death * model[0][i - 1]);
                //I
                model[1][i] = model[1][i - 1] + step * (ratio * model[0][i - 1] + p * lambda * model[2][i - 1] - (death + deathvirus) * model[1][i - 1]);
                //S
                model[2][i] = model[2][i - 1] + step * (born - lambda * model[2][i - 1] - death * model[2][i - 1]);
                lambda = (float) ((model[1][i] * contact)) / 100;

                death_total = (float) (death * model[0][i - 1] + death * model[2][i - 1] + deathvirus * model[1][i - 1]);
                born_total = (float) (born * (model[0][i - 1] + model[1][i - 1] + model[2][i - 1]));
                pop = born_total - death_total;
                System.out.println("Dead " + i + " = " + death_total);
                System.out.println("Born " + i + " = " + born_total);
                System.out.println("Population " + i + " = " + pop);
            }
        }
        Round();
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1]) / 100);
        pop = population;

        System.out.println("Population: " + population);

        return (model);
    }


    public double[][] Base(float startS, float startI, float startR, float population, float born, float death, float deathvirus, float delta, float ratio, float contact) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[0][i] = startI;
                model[2][i] = startR;
                pop = (float) (model[0][i] + model[0][i] + model[2][i]);


            } else {
                //L
                model[0][i] = model[0][i - 1] + step * ((contact + delta) * model[1][i - 1] - (death + ratio) * model[0][i - 1]);
                //I
                model[1][i] = model[1][i - 1] + step * (ratio * model[0][i - 1] - (deathvirus + delta) * model[1][i - 1]);
                //S
                model[2][i] = model[2][i - 1] + step * (born - death * model[2][i - 1] - contact * model[1][i - 1]);
                death_total = (float) (death * model[0][i - 1] + death * model[2][i - 1] + deathvirus * model[1][i - 1]);
                born_total = (float) (born * (model[0][i - 1] + model[1][i - 1] + model[2][i - 1]));
                pop = born_total - death_total;
                System.out.println("Dead " + i + " = " + death_total);
                System.out.println("Born " + i + " = " + born_total);
                System.out.println("Population " + i + " = " + pop);
            }


        }
        Round();
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1]) / 100);
        pop = population;

        //System.out.println("Population: " + population);

        return (model);
    }


    public float getPopulation() {
        return pop;
    }

    public void Round() {
        System.out.println("start round");
        for (int a = 0; a <= n - 1; a++) {
            for (int b = 0; b <= arrayLenght - 1; b++) {
                model[b][a] = Math.round(model[b][a] * 100.0) / 100.0;
            }
            // System.out.print("a:" + model[0][a] + "; b:" + model[1][a] + "; c:" + model[2][a]);
            //System.out.println();
        }
    }
}