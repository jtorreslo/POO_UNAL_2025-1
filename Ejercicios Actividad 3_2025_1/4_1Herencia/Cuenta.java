public class Cuenta {
    protected float saldo;
    
    protected int numeroConsignaciones =0;
    
    protected int numeroRetiros = 0;
    
    protected float tasaAnual;
    
    protected float comisionAnual;
    
    protected float comisionMensual = 0;
   

    public Cuenta(float saldo, float tasaAnual){
        this.saldo=saldo;
        this.tasaAnual=tasaAnual;}

    public void consignar(float cantidad){
        saldo = saldo + cantidad;
        numeroConsignaciones = numeroConsignaciones + 1;}
    public void retirar(float cantidad){
        float nuevoSaldo= saldo - cantidad;
        if (nuevoSaldo>=0){
            saldo-= cantidad;
            numeroRetiros= numeroRetiros+1;}
        else{
            System.out.println("La cantidad a retirar excede el saldo actual");}}
    
    public void CalcularInteres(){
        float tasaMesual = tasaAnual / 12;
        float interesMesual =saldo * tasaMesual;
        saldo+=interesMesual;}
    public void extractoMesual(){
        saldo-= comisionMensual;
        CalcularInteres();}
}

