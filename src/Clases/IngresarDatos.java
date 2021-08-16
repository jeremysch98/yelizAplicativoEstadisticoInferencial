package Clases;

public class IngresarDatos {
    private String descripcion;
    private int tm;
    private double pc,chiuno,chidos;

    //Sobrecarga de constructores
    public IngresarDatos(String descripcion, int tm, double pc, double chiuno, double chidos) {
        this.descripcion = descripcion;
        this.tm = tm;
        this.pc = pc;
        this.chiuno = chiuno;
        this.chidos = chidos;
    }
    
    public IngresarDatos(int tm, double pc) {
        this.tm = tm;
        this.pc = pc;
    }
    
    //Métodos Getters/Setters
    public String getDescripcion() {
        return descripcion;
    }

    public int getTm() {
        return tm;
    }

    public double getPc() {
        return pc;
    }

    public double getChiuno() {
        return chiuno;
    }

    public double getChidos() {
        return chidos;
    }    

    //Funciones
    public int gl_LimiteUnoDos(){
        return tm-1;
    }
    
    public double nc_LimiteUnoDos(){
        return 1-(pc/100);
    }
    
    public double prob_LimiteUno(){
        return nc_LimiteUnoDos()/2;
    }
    
    public double prob_LimiteDos(){
        return 1-(nc_LimiteUnoDos()/2);
    }
    
    public String MostrarDChiUno(){
        return String.format("%.4f",prob_LimiteUno())+" ; "+gl_LimiteUnoDos();
    }
    
    public String MostrarDChiDos(){
        return String.format("%.4f",prob_LimiteDos())+" ; "+gl_LimiteUnoDos();
    }
    
}
