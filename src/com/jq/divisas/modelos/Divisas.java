package com.jq.divisas.modelos;

public class Divisas {

    private String base;
    private String target;
    private double currentValue;
    private double conversionResult;
    private double amount;

    public Divisas(DivisasDTO divisasDTO) {
        this.base = divisasDTO.base_code();
        this.target = divisasDTO.target_code();
        this.currentValue = divisasDTO.conversion_rate();
        this.conversionResult = divisasDTO.conversion_result();
    }

    public Divisas() {

    }

    public void divisas(){
        System.out.println("--------- Monedas ---------");
        System.out.println("MXN - Peso Mexicano");
        System.out.println("USD - Dólar estadounidense");
        System.out.println("EUR - Euro");
        System.out.println("GBP - Libra esterlina");
        System.out.println("JPY - Yen japonés");
        System.out.println("CHF - Franco suizo");
        System.out.println("CNY - Yuan chino");
        System.out.println("AUD - Dólar australiano");
        System.out.println("CAD - Dólar canadiense");
        System.out.println();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Valor actual: " + currentValue + "\n" +
                "De: " + base + " Para: " + target + "\n" +
                "[ "+ amount + " x " + currentValue+ " ] = " + conversionResult;
    }
}
