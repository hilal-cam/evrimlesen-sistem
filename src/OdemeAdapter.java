public class OdemeAdapter { 
    private DisOdemeServisi disServis;

    public OdemeAdapter() {
        this.disServis = new DisOdemeServisi();
    }

    public void odemeYap(double miktar) {
        disServis.servisAraciligiylaOdemeAl(miktar);
    }
}
