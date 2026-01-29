package oop;

/**
 * Diese Klasse repräsentiert komplexe Zahlen und bietet Methoden zur
 * Durchführung grundlegender Operationen wie Addition, Subtraktion,
 * Multiplikation und Division.
 */
public class Complex {

    /** wichtige Konstanten */
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex J    = new Complex(0, 1);
    public static final Complex I    = new Complex(0, 1);

    /** Realteile der komplexen Zahl */
    private double re;
    /** Imaginärteil der komplexen Zahl */
    private double im;

    /** Konstruktor zur Initialisierung der komplexen Zahl */
    /**
     * Erstellt eine komplexe Zahl mit gegebenem Real- und Imaginärteil.
     *
     * @param re Realteil der komplexen Zahl
     * @param im Imaginärteil der komplexen Zahl
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /** Konstruktor zur Initialisierung einer reellen Zahl als komplexe Zahl */
    /**
     * Erstellt eine komplexe Zahl aus einem reellen Wert (Imaginärteil = 0).
     *
     * @param re der reelle Wert, der als Realteil verwendet wird
     */
    public Complex(double re) {
        this.re = re;
        this.im = 0;
    }

    /** statischer Constructor zur Erstellung einer komplexen Zahl */
    /**
     * Erzeugt eine rein imaginäre komplexe Zahl (Realteil = 0).
     *
     * @param im Imaginärteil der neuen Zahl
     * @return eine neue Complex mit re = 0 und im = im
     */
    public static Complex createImaginary(double im) {
        return new Complex(0, im);
    }

    /**
     * Liefert den Realteil der komplexen Zahl.
     *
     * @return Realteil (re)
     */
    public double getRe() {
        return re;
    }

    /**
     * Setzt den Realteil der komplexen Zahl.
     *
     * @param re neuer Realteil
     */
    public void setRe(double re) {
        this.re = re;
    }

    /**
     * Liefert den Imaginärteil der komplexen Zahl.
     *
     * @return Imaginärteil (im)
     */
    public double getIm() {
        return im;
    }

    /**
     * Setzt den Imaginärteil der komplexen Zahl.
     *
     * @param im neuer Imaginärteil
     */
    public void setIm(double im) {
        this.im = im;
    }

    /**
     * Berechnet den Betrag (Modul) der komplexen Zahl.
     *
     * @return Betrag = sqrt(re^2 + im^2)
     */
    public double getAbs() {
        return Math.sqrt(re * re + im * im);
    }

    /**
     * Setzt den Betrag (Modul) der komplexen Zahl und behält das aktuelle Argument bei.
     *
     * @param abs neuer Betrag (>=0)
     */
    public void setAbs(double abs) {
        double arg = getArg();
        re = abs * Math.cos(arg);
        im = abs * Math.sin(arg);
    }

    /**
     * Liefert das Argument (Phase) der komplexen Zahl in Bogenmaß.
     *
     * @return Argument in Radiant (atan2(im, re))
     */
    public double getArg() {
        return Math.atan2(im, re);
    }

    /**
     * Liefert das Argument (Phase) der komplexen Zahl in Grad.
     *
     * @return Argument in Grad
     */
    public double getArgDegrees() {
        return Math.toDegrees(getArg());
    }

    /**
     * Setzt das Argument (Phase) der komplexen Zahl in Bogenmaß und behält den Betrag bei.
     *
     * @param arg neues Argument in Radiant
     */
    public void setArg(double arg) {
        double abs  = getAbs();
        re = abs * Math.cos(arg);
        im = abs * Math.sin(arg);
    }

    /**
     * Setzt das Argument (Phase) der komplexen Zahl in Grad und behält den Betrag bei.
     *
     * @param argDegrees neues Argument in Grad
     */
    public void setArgDegrees(double argDegrees) {
        setArg(Math.toRadians(argDegrees));
    }

    /**
     * Liefert eine String-Repräsentation der komplexen Zahl im kartesischen Format.
     *
     * @return String in der Form "a+jb" oder "a-jb" bzw. Spezialformen für re-/imaginär
     */
    @Override
    public String toString() {
        //return String.format("%.2f+j%.2f", re, im);
        if (im==0) return re+"";
        if (im>=0) {
            if (re == 0) return "j" + im;
            return re + "+j" + im;
        }
        // hier ist kein else notwendig, da return die Methode verlässt
        if (re == 0) return "-j" + -im;
        return re + "-j" + -im;
    }

    /**
     * Liefert eine String-Repräsentation der komplexen Zahl in Polarform.
     * Aktuell wird die kartesische Darstellung zurückgegeben.
     *
     * @return String mit Polar- oder kartesischer Darstellung
     */
    public String toStringPolar() {
        return toString();
    }

    /* ----------------------------------------------------------------------------
     * Weitere Methoden zur Durchführung von Operationen wie Addition,
     * Subtraktion, Multiplikation und Division können hier hinzugefügt werden.
     * ----------------------------------------------------------------------------
     */

    /**
     * Addiert diese komplexe Zahl mit einer anderen.
     *
     * @param c die zu addierende komplexe Zahl
     * @return neue Complex, die die Summe darstellt
     */
    public Complex add(Complex c) {
        return new Complex(this.re + c.re, this.im + c.im);
    }

    /**
     * Negation dieser komplexen Zahl.
     *
     * @return neue Complex, die -this darstellt
     */
    public Complex neg() {
        return new Complex(-this.re, -this.im);
    }

    /**
     * Subtrahiert eine komplexe Zahl von dieser.
     *
     * @param c die zu subtrahierende komplexe Zahl
     * @return neue Complex, die das Ergebnis dieser - c darstellt
     */
    public Complex sub(Complex c) {
        return this.add(c.neg());
    }

    /**
     * Multipliziert diese komplexe Zahl mit einer anderen.
     *
     * @param c der Multiplikator
     * @return neue Complex als Produkt
     */
    public Complex mul(Complex c) {
        double realPart = this.re * c.re - this.im * c.im;
        double imagPart = this.re * c.im + this.im * c.re;
        return new Complex(realPart, imagPart);
    }

    /**
     * Berechnet das multiplikative Inverse (Kehrwert) dieser komplexen Zahl.
     * Bei Betrag 0 können NaN oder Infinity entstehen (keine Exception geworfen).
     *
     * @return neue Complex, die 1/this darstellt
     */
    public Complex inv() {
        double denom = re * re + im * im;
        return new Complex(re / denom, -im / denom);
    }

    /**
     * Dividiert diese komplexe Zahl durch eine andere.
     *
     * @param c Divisor
     * @return neue Complex als Ergebnis der Division (this / c)
     */
    public Complex div(Complex c) {
        return this.mul(c.inv());
    }

}
