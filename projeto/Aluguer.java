
public class Aluguer
{
    // instance variables - replace the example below with your own
    private String nif;
    private double posX;
    private double posY;
    private Viatura viatura;
    private String metodo_solicitado;

    /**
     * Constructor for objects of class Aluguer
     */
    public Aluguer()
    {
        this.nif = "";
        this.posX = 0;
        this.posY = 0;
        this.viatura = new Viatura();
        this.metodo_solicitado = "";
    }
    
    public Aluguer(String nif, double posX, double posY, Viatura viatura, String met)
    {
        this.nif = nif;
        this.posX = posX;
        this.posY = posY;
        this.viatura = viatura.clone();
        this.metodo_solicitado = "";
    }
    
    public Aluguer(Aluguer a)
    {
        this.nif = a.getNif();
        this.posX = a.getPosX();
        this.posY = a.getPosY();
        this.viatura = a.getViatura();
        this.metodo_solicitado = a.getMetodo();
    }
    
    public String getNif(){
        return this.nif;
    }

    public double getPosX(){
        return this.posX;
    }    

    public double getPosY(){
        return this.posY;
    }
    
    public Viatura getViatura(){
        return this.viatura;
    }
    
    public String getMetodo(){
        return this.metodo_solicitado;
    }
    
    public void setNif(String nif){
        this.nif = nif;
    }

    public void setPosX(double x){
        this.posX = x;
    }    

    public void setPosY(double y){
        this.posY = y;
    }
    
    public void setViatura(Viatura v){
        this.viatura = v;
    }
    
    public void setMetodo(String metodo){
        this.metodo_solicitado = metodo;
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Aluguer a = (Aluguer) obj;
       return this.nif.equals(a.getNif()) && this.posX == a.getPosX() && this.posY == a.getPosY() && this.viatura.equals(a.getViatura()) && this.metodo_solicitado.equals(a.getMetodo());
    }
    
    public Aluguer clone() {
        return new Aluguer(this);
    }
}
