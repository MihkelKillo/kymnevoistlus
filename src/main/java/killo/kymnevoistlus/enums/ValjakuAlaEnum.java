package killo.kymnevoistlus.enums;

public enum ValjakuAlaEnum {
    KAUGUSHYPE("kaugushüpe", 0.14354, 220.0, 1.4),
    KUULITOUGE("kuulitõuge", 51.39, 1.5, 1.05),
    KORGUSHYPE("kõrgushüpe", 0.8465, 75.0, 1.42),
    KETTAHEIDE("kettaheide", 12.91, 4.0, 1.1),
    TEIVASHYPE("teivashüpe", 0.2797, 100.0, 1.35),
    ODAVISE("odavise", 10.14, 7.0, 1.08);

    private String ala;
    private Double A;
    private Double B;
    private Double C;
    
    private ValjakuAlaEnum(String ala, Double A, Double B, Double C) {
        this.ala = ala;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public String getAla() {
        return this.ala;
    }

    public Double getA() {
        return this.A;
    }

    public Double getB() {
        return this.B;
    }

    public Double getC() {
        return this.C;
    }

    public static ValjakuAlaEnum fromString(String alaNimetus) {
        ValjakuAlaEnum[] valjakuAlad = ValjakuAlaEnum.values(); 
        for (ValjakuAlaEnum alaEnum: valjakuAlad) {
            if (alaEnum.ala.equalsIgnoreCase(alaNimetus)) {
                return alaEnum;
            }
        }
        throw new IllegalArgumentException("Nimetusega " + alaNimetus + " väljakuala ei leitud");
    }
}
