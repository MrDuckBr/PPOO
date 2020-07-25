class Veiculo{
    private int capTanque;
    private int qtdPneu;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private String tipoCombustivel;


    Veiculo(int capTanque, int qtdPneu , String marca,
    String modelo, int anoFabricacao , String tipoCombustivel){
        this.capTanque = capTanque;
        this.qtdPneu = qtdPneu;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getCapTanque(){
        return capTanque;
    }
    
    public int getQtdPneu(){
        return qtdPneu;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getAnoFabricaco(){
        return anoFabricacao;
    }
    public String getTipoCombustivel(){
        return tipoCombustivel;
    }
}