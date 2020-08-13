class Veiculo implements Comparable<Veiculo>{
    private int capTanque;
    private int qtdPneu;
    private String modelo;
    private String anoFabricacao;
    private String tipoCombustivel;
    private double tempoChegadaVeiculo;
    private double tempoNoPosto;

    /**
     * Construtor da classe veículo
     * @param tempoChegadaVeiculo tempo em que o veiculo chegará ao posto
     * @param capTanque capacidade do tanque de combustível do veículo
     * @param qtdPneu quantidade de pneus do veículo
     * @param modelo modelo do veículo
     * @param anoFabricacao ano de fabricação do veículo
     * @param tipoCombustivel tipo de combustível usado pelo veículo
     */
    Veiculo(int tempoChegadaVeiculo, int capTanque, int qtdPneu , String modelo, String anoFabricacao , String tipoCombustivel){

        this.tempoChegadaVeiculo = tempoChegadaVeiculo;
        this.capTanque = capTanque;
        this.qtdPneu = qtdPneu;

        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipoCombustivel = tipoCombustivel;
        tempoNoPosto = 0;
    }

    /**
     * Retorna a capacidade do tanque do veículo
     * @return capacidade do tanque
     */
    public int getCapTanque(){
        return capTanque;
    }

    /**
     * Retorna a quantidade de pneus
     * @return quantidade de pneus
     */
    public int getQtdPneu(){
        return qtdPneu;
    }

    /**
     * Retorna o modelo do veículo
     * @return modelo do veículo
     */
    public String getModelo(){
        return modelo;
    }

    /**
     * Retorna o ano de fabricação
     * @return ano de fabricação
     */
    public String getAnoFabricaco(){
        return anoFabricacao;
    }

    /**
     * Retorna o tipo de combustível de veículo
     * @return tipo de combustível
     */
    public String getTipoCombustivel(){
        return tipoCombustivel;
    }

    /**
     * Seta o tempo de chegada do veículo
     * @param valor tempo de chegada
     */
    public  void setTempoChegadaVeiculo(double valor){ this.tempoChegadaVeiculo = valor; }

    /**
     * Retorna o tempo de chegada do veículo
     * @return tempo de chegada
     */
    public double getTempoChegadaVeiculo(){ return  tempoChegadaVeiculo; }

    /**
     * Retorna o tempo em que o veículo está no posto
     * @return tempo no posto
     */
    public double getTempoNoPosto() { return tempoNoPosto; }

    /**
     * Seta o tempo do veículo no posto (tempo total em uns instante t)
     * @param tempoNoPosto tempo a ser acrescido
     */
    public void setTempoNoPosto(double tempoNoPosto) { this.tempoNoPosto += tempoNoPosto; }


    @Override
    public int compareTo(Veiculo o) {
        if(o.getTempoChegadaVeiculo() == getTempoChegadaVeiculo()){
            return 1;
        }else if(o.getTempoChegadaVeiculo() < getTempoChegadaVeiculo()){
            return 0;
        }else return -1;
    }
}