public class Reserva {
    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva (String nomeHospede , int numeroDias ,String tipoQuarto, double valorDiaria){
        validarNumeroDias(numeroDias);
        validarValorDiaria(valorDiaria);
        this.nomeHospede = nomeHospede;
        this.numeroDias = numeroDias;
        this.valorDiaria = valorDiaria;
        this.tipoQuarto = tipoQuarto;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        validarValorDiaria(valorDiaria);
        this.valorDiaria = valorDiaria;
    }

    public int getNumeroDias() {

        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        validarNumeroDias(numeroDias);
        this.numeroDias = numeroDias;
    }

    public String getNomeHospede() {

        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {

        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {

        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    public double calcularValorTotal(){
        return numeroDias * valorDiaria;
    }
    private void validarNumeroDias (int numeroDias) {
        if (numeroDias < 1) {
            throw new IllegalArgumentException("O número de dias deve ser maior que zero!");
        }
    }
    private void validarValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("O valor da diária deve ser maior que zero!");
        }
    }
    @Override
    public String toString() {
        return "Reserva: \nNome do hospede: " + nomeHospede + "\nDias hospedados: " + numeroDias +  "\nTipo de quarto: " + tipoQuarto + "\nValor da diaria: " + valorDiaria + "\nValor total: R$" + calcularValorTotal() + "\n";
    }
}

