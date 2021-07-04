package killo.kymnevoistlus.enums;

public enum JooksuAlaEnum {
    SADAMEETRIT("100 m jooks", 25.4347, 18.0, 1.81),
    NELISADA("400 m jooks", 1.53775, 82.0, 1.81),
    TOKKEJOOKS("110 m tõkkejooks", 5.74352, 28.5, 1.92),
    TUHATVIISSADA("1500 m jooks", 0.03768, 480.0, 1.85);
    
    private String ala;
    private Double A;
    private Double B;
    private Double C;
    
    private JooksuAlaEnum(String ala, Double A, Double B, Double C) {
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

    public static JooksuAlaEnum fromString(String alaNimetus) {
        JooksuAlaEnum[] jooksuAlad = JooksuAlaEnum.values(); 
        for (JooksuAlaEnum alaEnum: jooksuAlad) {
            if (alaEnum.ala.equalsIgnoreCase(alaNimetus)) {
                return alaEnum;
            }
        }
        throw new IllegalArgumentException("Nimetusega " + alaNimetus + " jooksuala ei leitud");
    }
}
