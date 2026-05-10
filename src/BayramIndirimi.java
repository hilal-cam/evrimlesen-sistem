package src;

public class BayramIndirimi implements IndirimStratejisi {
    @Override
    public double indirimUygula(double fiyat) {
        System.out.println("[STRATEJİ]: Bayram indirimi (%15) uygulandı.");
        return fiyat * 0.85; 
    }
}
