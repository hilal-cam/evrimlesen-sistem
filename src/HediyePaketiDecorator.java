public class HediyePaketiDecorator extends KiyafetDecorator {
    public HediyePaketiDecorator(Kiyafet kiyafet) {
        super(kiyafet);
    }

    @Override
    public double getFiyat() {
        return super.getFiyat() + 30.0;
    }
}
