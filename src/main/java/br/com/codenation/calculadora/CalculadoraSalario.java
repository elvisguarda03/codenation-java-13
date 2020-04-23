package br.com.codenation.calculadora;

public class CalculadoraSalario {
	private static final double SALARIO_MINIMO = 1039;
	private static final double FAIXA_SALARIAL_6000 = 6000;
	private static final double FAIXA_SALARIAL_3000 = 3000;
	private static final double FAIXA_SALARIAL_4000 = 4000;
	private static final double FAIXA_SALARIAL_1500 = 1500;

	private static final double INSS_08 = 0.08;
	private static final double INSS_09 = 0.09;
	private static final double INSS_011 = 0.11;
	private static final double IRRF_075 = 0.075;
	private static final double IRRF_015 = 0.15;

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}

		return Math.round(salarioBase - calcularInss(salarioBase) - calcularIRRF(salarioBase));
	}


	private double calcularInss(double salarioBase) {
		double result;
		if (salarioBase <= FAIXA_SALARIAL_1500) {
			result = salarioBase * INSS_08;
		} else if (salarioBase <= FAIXA_SALARIAL_4000) {
			result = salarioBase * INSS_09;
		} else {
			result = salarioBase * INSS_011;
		}

		return result;
	}

	private double calcularIRRF(double salarioBase){
		double result;

		salarioBase = salarioBase - calcularInss(salarioBase);
		if (salarioBase <= FAIXA_SALARIAL_3000) {
			result = 0;
		} else if (salarioBase <= FAIXA_SALARIAL_6000) {
			result = salarioBase * IRRF_075;
		} else {
			result = salarioBase * IRRF_015;
		}

		return result;
	}

}