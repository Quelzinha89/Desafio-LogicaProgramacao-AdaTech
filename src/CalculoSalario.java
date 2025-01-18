
import java.util.Arrays;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Double[] salariosBrutos = new Double[5];

    System.out.println("Digite os 5 salários brutos: ");
    int index = 0;
    for (Double salario : salariosBrutos) {
        salariosBrutos[index] = scanner.nextDouble();
        index++;
    }
    System.out.println(Arrays.toString(salariosBrutos));
    for (Double salario : salariosBrutos) {
        Double inss = calcularINSS(salario);
        Double irpf = calcularIRPF(salario - inss);
        Double salarioLiquido = (salario - inss - irpf);

        System.out.println("\nSalário Bruto : R$" + String.format("%.2f", salario));
        System.out.println("Desconto INSS: R$" + String.format("%.2f", inss));
        System.out.println("Desconto IRPF: R$" + String.format("%.2f", irpf));
        System.out.println("Salário Líquido: R$" + String.format("%.2f", salarioLiquido));
    }


}

public static Double calcularINSS(Double salarioBruto) {
    if (salarioBruto <= 1212.00) {
        return salarioBruto * 0.075;
    } else if (salarioBruto <= 2427.35) {
        return salarioBruto * 0.09;
    } else if (salarioBruto <= 3641.03) {
        return salarioBruto * 0.12;
    } else {
        return salarioBruto * 0.14;
    }
}

public static Double calcularIRPF(Double salarioComDescontoINSS) {
    if (salarioComDescontoINSS <= 1903.98) {
        return 0.00;
    } else if (salarioComDescontoINSS <= 2826.65) {
        return salarioComDescontoINSS * 0.075;
    } else if (salarioComDescontoINSS <= 3751.05) {
        return salarioComDescontoINSS * 0.15;
    } else if (salarioComDescontoINSS <= 4664.68) {
        return salarioComDescontoINSS * 0.225;
    } else {
        return salarioComDescontoINSS * 0.275;
    }
}
