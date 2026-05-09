public abstract class KiyafetDecorator implements Kiyafet {
    protected Kiyafet dekoreEdilenKiyafet;

    public KiyafetDecorator(Kiyafet kiyafet) {
        this.dekoreEdilenKiyafet = kiyafet;
    }

    @Override
    public double getFiyat() {
        return dekoreEdilenKiyafet.getFiyat();
    }
}
