package rvt.Jmooc82;

import java.util.HashMap;

public class IOU {
    private String toWhom;
    private Double amount;
    HashMap<String, Double> OWE =  new HashMap<>();

    public IOU() {

    }

    public void setSum(String toWhom, double amount) {
        this.toWhom = toWhom;
        this.amount = amount;
        OWE.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        double debt = OWE.get(toWhom);
        return debt;
    }
}
