import java.util.Scanner;

public class DepositCalculator {
        double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay;

        pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundValues(pay, 2);
    }

    double calculateSimplePercent (double amount,double yearRate, int depositPeriod) {
        return roundValues(amount + amount * yearRate * depositPeriod, 2);
    }
    double roundValues(double value, int places) {
        double Scale;

        Scale= Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void calculateDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount;

        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outValue = 0;

        if (action == 1) {
            outValue = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outValue = calculateComplexPercent(amount, 0.06, period);
    }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outValue);
    }

    public static void main(String[] args){
        new DepositCalculator().calculateDeposit();
    }

}