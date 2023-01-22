import java.util.Scanner;

public class DepositCalculate {

    double calculateComplexPercentFunction(double amount, double yearRate, int period) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundsValue(value, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int period) {
        return roundsValue(amount + amount * yearRate * period, 2);
    }

    double roundsValue(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void workWithDeposit() {
        int amount;
        int period;
        int action;
        double finalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            finalAmount = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            finalAmount = calculateComplexPercentFunction(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculate().workWithDeposit();
    }
}
