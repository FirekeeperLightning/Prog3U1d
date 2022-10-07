package UbEins;

import java.math.BigInteger;

public class Bruch implements Comparable<Bruch> {
    private Integer zaeler;
    private Integer nenner;
    private double wert;


    public Bruch(int nenner, int zahler) throws ArithmeticException {
        if (nenner == 0) {
            throw new ArithmeticException();
        }
        this.nenner = nenner;
        this.zaeler = zahler;
        setWert();
    }

    public Bruch(int zaeler) {
        this(1, zaeler);
    }

    private void setWert() {
        this.wert = nenner / zaeler;
    }

    public int getZaeler() {
        return zaeler;
    }

    public int getNenner() {
        return nenner;
    }

    public double getWert() {
        return this.wert;
    }

    /**
     * vergleichge aufrufenden Bruch mit prameter Bruch
     *
     * @param o prameter Bruch
     * @return 1 wenn aufrufender Bruch größer ist,
     * -1 wenn parameter Bruch größer ist,
     * 0 wenn sie gleich sind
     */
    @Override
    public int compareTo(Bruch o) {
        if (this.wert < o.wert)
            return -1;
        if (this.wert > o.wert)
            return 1;
        return 0;
    }

    /**
     * erstelle repräsentation des Bruchs als String, im format "zähler"/"nenner"
     *
     * @return repräsentation des Bruchs als String
     */
    public String toString() {
        return this.nenner.toString() + "/" + this.zaeler.toString();
    }

    /**
     * @return wert des Bruchs als double
     */
    public double ausrechnen() {
        return wert;
    }

    /**
     * multipliziere Bruch mit parameter bruch,
     * parameter und aufrufender Brueche werden nicht verändert
     *
     * @param b parameter Bruch
     * @return neuen Bruch
     */
    public Bruch multiplizieren(Bruch b) {
        return new Bruch(this.nenner * b.nenner, this.zaeler * b.zaeler);
    }

    /**
     * kürze bruch in dem KgV gefunden wird und nenner sowie zaeler durch das KgV geteilt werden.
     */
    public void kuerzen() {
        BigInteger bigNenner = java.math.BigInteger.valueOf(this.zaeler);
        BigInteger bigZahler = java.math.BigInteger.valueOf(this.nenner);
        BigInteger bigTeiler = bigNenner.gcd(bigZahler);
        int teiler = bigTeiler.intValue();

        this.nenner = this.nenner / teiler;
        this.zaeler = this.zaeler / teiler;
    }

    /**
     * erstelle kerwert vom aufrufenden Bruch. Bruch selbst wird nicht verändert!
     *
     * @return neuer Bruch der den kehrwert des aufrufenden Bruchs räpräsentiert
     */
    public Bruch kehrwert() {
        return new Bruch(this.nenner, this.zaeler);
    }

    /**
     * aufrufender bruch wird divident
     *
     * @param divisor wird divisor
     * @return Quotient als neuen Bruch
     */
    public Bruch dividieren(Bruch divisor) {
        return this.multiplizieren(divisor.kehrwert());
    }


}
