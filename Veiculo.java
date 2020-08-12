class Veiculo implements Comparable<Veiculo>{
    private int capTanque;
    private int qtdPneu;
    private String modelo;
    private String anoFabricacao;
    private String tipoCombustivel;
    private double tempoChegadaVeiculo;
    private double tempoNoPosto;


    Veiculo(int tempoChegadaVeiculo, int capTanque, int qtdPneu , String modelo, String anoFabricacao , String tipoCombustivel){

        this.tempoChegadaVeiculo = tempoChegadaVeiculo;
        this.capTanque = capTanque;
        this.qtdPneu = qtdPneu;

        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipoCombustivel = tipoCombustivel;
        tempoNoPosto = 0;
    }

    public int getCapTanque(){
        return capTanque;
    }
    
    public int getQtdPneu(){
        return qtdPneu;
    }

        //tempo pode ser abstrato ?????

    public String getModelo(){
        return modelo;
    }

    public String getAnoFabricaco(){
        return anoFabricacao;
    }

    public String getTipoCombustivel(){
        return tipoCombustivel;
    }

    public  void setTempoChegadaVeiculo(double valor){ this.tempoChegadaVeiculo = valor; }

    public double getTempoChegadaVeiculo(){ return  tempoChegadaVeiculo; }

    public double getTempoNoPosto() { return tempoNoPosto; }

    public void setTempoNoPosto(double tempoNoPosto) { this.tempoNoPosto += tempoNoPosto; }


    @Override
    public int compareTo(Veiculo o) {
        if(o.getTempoNoPosto() == getTempoNoPosto()){
            return 0;
        }else if(o.getTempoNoPosto() < getTempoNoPosto()){
            return 1;
        }else return -1;
    }
}