import java.util.*;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe Cliente aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Cliente extends Atores
{
    private double posX;
    private double posY;

    public Cliente(){
        super();
        this.posX = 0;
        this.posY = 0;
    }

    public Cliente(String email, String password, String nome, String morada, LocalDate dataNasc, double posX, double posY, Map<Double, DadosAluguer> historico, String nif){
        super(email,password,nome,morada, dataNasc, historico, nif);
        this.posX = posX;
        this.posY = posY;
    }

    public Cliente(Cliente c){
        super(c);
        this.posX = c.getPosX();
        this.posY = c.getPosY();
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public void setPosX(double x) {
        this.posX = x;
    }

    public void setPosY(double y) {
        this.posY = y;
    }

    public Cliente clone() {
        return new Cliente(this);
    }

    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Cliente a = (Cliente) obj;
       return super.equals(obj) && this.posX == a.getPosX() && this.posY == a.getPosY();
    }

    public String toString(){
        return "Posx: " + this.posX + " psy: " + this.posY + "\n" + super.toString();
    }

    public Viatura solicitaCarroDist(Sistema s, double xDest, double yDest){

        double min = 999999999;
        double dist,x,y, distDest;
        Viatura ve = new Viatura();
        ve = null;

        for(Viatura v : s.getViaturas().values()){
            x = v.getPosX();
            y = v.getPosY();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (min > dist && distDest <= v.getAutonomia()){
                if(s.getProprietarioViatura(v.getMatricula()).requestAluguer(v.getMatricula(), this)){
                    min = dist;
                    ve = v.clone();
                }
            }
        }
        return ve;
    }

    public DadosAluguer alugaCarroDist(Sistema s, double xDest, double yDest){
        double dist, preco, combustivel, autonomia;
        Viatura viatura = new Viatura();
        Proprietario prop = new Proprietario();

        viatura = solicitaCarroDist(s, xDest, yDest);
        if(viatura == null) return null;

        dist = Math.hypot(viatura.getPosX() - xDest, viatura.getPosY() - yDest);
        preco = dist * viatura.getPreco();
        combustivel = viatura.getCombustivel() - (dist * viatura.getConsumo());
        autonomia = combustivel / viatura.getConsumo();
        viatura.setCombustivel(combustivel);
        viatura.setAutonomia(autonomia);
        viatura.setPosX(xDest);
        viatura.setPosY(yDest);

        for(Proprietario p1 : s.getProprietarios().values()){
            if(p1.getViaturas().get(viatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        this.setPosX(xDest);
        this.setPosY(yDest);

        DadosAluguer aluguer = new DadosAluguer(viatura.getMatricula(), prop.getNif(), this.getNif(), preco);

        viatura.addAluguer(aluguer);
        s.updateHistoricos(aluguer);
        s.updateSingleViatura(viatura);

        return aluguer;
    }

    public Viatura solicitaCarroMaisBarato(Sistema s, double xDest, double yDest){

        double min = 999999999;
        double preco, dist;
        Viatura ve = new Viatura();
        ve = null;

        for(Viatura v : s.getViaturas().values()){
            preco = v.getPreco();
            dist= Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (min > preco && dist <= v.getAutonomia()){
                if(s.getProprietarioViatura(v.getMatricula()).requestAluguer(v.getMatricula(), this)){
                    min = preco;
                    ve = v.clone();
                }
            }
        }
        return ve;
    }

    public DadosAluguer alugaCarroMaisBarato(Sistema s, double xDest, double yDest){
        double dist, preco, combustivel, autonomia;
        Viatura viatura = new Viatura();
        Proprietario prop = new Proprietario();

        viatura = solicitaCarroMaisBarato(s, xDest, yDest);
        if(viatura == null) return null;

        dist = Math.hypot(viatura.getPosX() - xDest, viatura.getPosY() - yDest);
        preco = dist * viatura.getPreco();
        combustivel = viatura.getCombustivel() - (dist * viatura.getConsumo());
        autonomia = combustivel / viatura.getConsumo();
        viatura.setCombustivel(combustivel);
        viatura.setAutonomia(autonomia);
        viatura.setPosX(xDest);
        viatura.setPosY(yDest);

        for(Proprietario p1 : s.getProprietarios().values()){
            if(p1.getViaturas().get(viatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        this.setPosX(xDest);
        this.setPosY(yDest);

        DadosAluguer aluguer = new DadosAluguer(viatura.getMatricula(), prop.getNif(), this.getNif(), preco);

        viatura.addAluguer(aluguer);
        s.updateHistoricos(aluguer);
        s.updateSingleViatura(viatura);

        return aluguer;
    }

    public Viatura solicitaCarroDistPreco(Sistema s, double distancia, double xDest, double yDest){
        double min = 999999999;
        double preco, dist, x, y, distDest;
        Viatura ve = new Viatura();

        ve = null;

        for(Viatura v : s.getViaturas().values()){
            x = v.getPosX();
            y = v.getPosY();
            preco = v.getPreco();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (min > preco && dist <= distancia && distDest <= v.getAutonomia()){
                if(s.getProprietarioViatura(v.getMatricula()).requestAluguer(v.getMatricula(), this)){
                    min = preco;
                    ve = v.clone();
                }
            }
        }
        return ve;
    }

    public DadosAluguer alugaCarroDistPreco(Sistema s, double distancia, double xDest, double yDest){
        double dist, preco, combustivel, autonomia;
        Viatura viatura = new Viatura();
        Proprietario prop = new Proprietario();

        viatura = solicitaCarroDistPreco(s, distancia, xDest, yDest);
        if(viatura == null) return null;

        dist = Math.hypot(viatura.getPosX() - xDest, viatura.getPosY() - yDest);
        preco = dist * viatura.getPreco();
        combustivel = viatura.getCombustivel() - (dist * viatura.getConsumo());
        autonomia = combustivel / viatura.getConsumo();
        viatura.setCombustivel(combustivel);
        viatura.setAutonomia(autonomia);
        viatura.setPosX(xDest);
        viatura.setPosY(yDest);

        for(Proprietario p1 : s.getProprietarios().values()){
            if(p1.getViaturas().get(viatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        this.setPosX(xDest);
        this.setPosY(yDest);

        DadosAluguer aluguer = new DadosAluguer(viatura.getMatricula(), prop.getNif(), this.getNif(), preco);

        viatura.addAluguer(aluguer);
        s.updateHistoricos(aluguer);
        s.updateSingleViatura(viatura);

        return aluguer;
    }

    public Viatura solicitaCarroEspecifico(Sistema s, String matricula, double xDest, double yDest){
        double distDest;
        Viatura ve = new Viatura();
        ve = null;

        for(Viatura v : s.getViaturas().values()){
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (v.getMatricula().equals(matricula) && distDest <= v.getAutonomia()){
              ve = v.clone();
            }
        }
        return ve;
    }

    public DadosAluguer alugaCarroEspecifico(Sistema s, String matricula, double xDest, double yDest){
        double dist, preco, combustivel, autonomia;
        Viatura viatura = new Viatura();
        Proprietario prop = new Proprietario();

        viatura = solicitaCarroEspecifico(s, matricula, xDest, yDest);
        if(viatura == null) return null;

        dist = Math.hypot(viatura.getPosX() - xDest, viatura.getPosY() - yDest);
        preco = dist * viatura.getPreco();
        combustivel = viatura.getCombustivel() - (dist * viatura.getConsumo());
        autonomia = combustivel / viatura.getConsumo();
        viatura.setCombustivel(combustivel);
        viatura.setAutonomia(autonomia);
        viatura.setPosX(xDest);
        viatura.setPosY(yDest);

        for(Proprietario p1 : s.getProprietarios().values()){
            if(p1.getViaturas().get(viatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        this.setPosX(xDest);
        this.setPosY(yDest);

        DadosAluguer aluguer = new DadosAluguer(viatura.getMatricula(), prop.getNif(), this.getNif(), preco);

        viatura.addAluguer(aluguer);
        s.updateHistoricos(aluguer);
        s.updateSingleViatura(viatura);

        return aluguer;
    }

    public Viatura solicitaCarroAutonomia(Sistema s, double autonomia, double xDest, double yDest){
        double distDest;
        Viatura ve = new Viatura();
        ve = null;

        for(Viatura v : s.getViaturas().values()){
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (v.getAutonomia() == autonomia && distDest <= v.getAutonomia()){
                ve = v.clone();
            }

        }

        return ve;
    }

    public DadosAluguer alugaCarroAutonomia(Sistema s, double checkautonomia, double xDest, double yDest){
        double dist, preco, combustivel, autonomia;
        Viatura viatura = new Viatura();
        Proprietario prop = new Proprietario();

        viatura = solicitaCarroAutonomia(s, checkautonomia, xDest, yDest);
        if(viatura == null) return null;

        dist = Math.hypot(viatura.getPosX() - xDest, viatura.getPosY() - yDest);
        preco = dist * viatura.getPreco();
        combustivel = viatura.getCombustivel() - (dist * viatura.getConsumo());
        autonomia = combustivel / viatura.getConsumo();
        viatura.setCombustivel(combustivel);
        viatura.setAutonomia(autonomia);
        viatura.setPosX(xDest);
        viatura.setPosY(yDest);

        for(Proprietario p1 : s.getProprietarios().values()){
            if(p1.getViaturas().get(viatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        this.setPosX(xDest);
        this.setPosY(yDest);

        DadosAluguer aluguer = new DadosAluguer(viatura.getMatricula(), prop.getNif(), this.getNif(), preco);

        viatura.addAluguer(aluguer);
        s.updateHistoricos(aluguer);
        s.updateSingleViatura(viatura);

        return aluguer;
    }
}
