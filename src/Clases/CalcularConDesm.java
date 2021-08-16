package Clases;

public class CalcularConDesm extends IngresarDatos implements MostrarPro, MostrarIntConf{
    private double desm;

    public CalcularConDesm(double desm, String descripcion, int tm, double pc, double chiuno, double chidos) {
        super(descripcion, tm, pc, chiuno, chidos);
        this.desm = desm;
    }
    
    public double CalcularLimUno(){
        if(getChiuno()>getChidos()){
            return ((getTm()-1)*Math.pow(this.desm, 2))/getChiuno();
        }else{
            return ((getTm()-1)*Math.pow(this.desm, 2))/getChidos();
        }
    }
    
    public double CalcularLimDos(){
        if(getChiuno()>getChidos()){
            return ((getTm()-1)*Math.pow(this.desm, 2))/getChidos();
        }else{
            return ((getTm()-1)*Math.pow(this.desm, 2))/getChiuno();
        }
    }
    
    public String MostrarIntConf(){
        return CalcularLimUno()+" < σ² < "+CalcularLimDos();
    }
    
    public String MostrarPro(){
        return "- DATOS DEL PROBLEMA:"+"\n\n"+
               "    El tamaño de la muestra (n): "+getTm()+"\n\n"+
               "    El porcentaje de confianza: "+getPc()+"%"+"\n\n"+
               "    La desviación estándar muestral (S): "+this.desm+"\n\n"+
               "\n"+
               "- OBTENEMOS:"+"\n\n"+
               "    Nivel de confianza (α) =1-(porcentaje de confianza/100): "+String.format("%.4f",nc_LimiteUnoDos())+"\n\n"+
               "    Grado de libertad (v) =n-1: "+gl_LimiteUnoDos()+"\n\n"+
               "\n"+
               "- HALLAMOS LOS VALORES DE LOS ESTADÍSTICO X² PARA AMBOS LÍMITES:"+"\n\n"+
               "    El estadístico= X²(α/2 ; v): "+"\n\n"+
               "        X²("+String.format("%.4f",prob_LimiteUno())+" ; "+gl_LimiteUnoDos()+")= "+getChiuno()+"\n\n"+
               "    El estadístico= X²(1-α/2 ; v): "+"\n\n"+
               "        X²("+String.format("%.4f",prob_LimiteDos())+" ; "+gl_LimiteUnoDos()+")= "+getChidos()+"\n\n"+
               "\n"+
               "- REEMPLAZAMOS LOS DATOS EN LA FÓRMULA:"+"\n\n"+
               "    Si el valor de X²(α/2;v) > X²(1-α/2;v):"+"\n\n"+
               "          (n-1)S²          (n+1)S²"+"\n"+
               "        --------- < σ² < -----------"+"\n"+
               "        X²(α/2;v)        X²(1-α/2;v)"+"\n\n"+
               "    Si el valor de X²(α/2;v) < X²(1-α/2;v):"+"\n\n"+
               "          (n-1)S²          (n+1)S²"+"\n"+
               "        ----------- < σ² < ---------"+"\n"+
               "        X²(1-α/2;v)         X²(α/2;v)"+"\n\n"+
               "    Por lo tanto:"+"\n\n"+
               "        "+gl_LimiteUnoDos()+"*"+this.desm+"²"+"              "+gl_LimiteUnoDos()+"*"+this.desm+"²"+"\n"+
               "        ----------------  < σ² <  ----------------"+"\n"+
               "            "+getChiuno()+"                      "+getChidos()+"\n\n"+
               "    Operando obtenemos:"+"\n\n"+
               "        "+CalcularLimUno()+" < σ² < "+CalcularLimDos()+"\n\n"+
               "----------------------------------------------------------";               
    }
    
    public String MostrarInterD(){
        return "Hay un "+getPc()+"% de confianza de que la varianza de l@s "+getDescripcion()+" cae entre "+CalcularLimUno()+" y "+CalcularLimDos()+" u.";
    }
}
