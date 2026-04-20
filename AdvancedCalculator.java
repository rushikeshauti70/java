import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // loop for multiple calculations
            try {
                // Taking user input
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                // Choosing an operation
                System.out.print("Choose an operation (+, -, *, /, %, ^ for power): ");
                char operation = scanner.next().charAt(0);

                double result;

                // Performing calculation using switch-case
                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        break;
                    case '%':
                        if (num2 != 0) {
                            result = num1 % num2;
                        } else {
                            throw new ArithmeticException("Modulo by zero is not allowed.");
                        }
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation. Use +, -, *, /, %, ^");
                }

                System.out.println("Result: " + result);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // clear buffer
            }

            // Asking user if they want another calculation
            System.out.print("Do you want to perform another calculation? (Yes/No): ");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes")) {
                System.out.println("Calculator closing... Thank you!");
                break;
            }
        }

        scanner.close();
    }
}