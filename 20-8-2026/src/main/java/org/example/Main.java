package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        JTextField txtN = new JTextField(10);
        JButton btnCalc = new JButton("tinh");
        JLabel lblResult = new JLabel("ket qua: ");

        setLayout(new FlowLayout());
        add(new JLabel("nhap N:"));
        add(txtN);
        add(btnCalc);
        add(lblResult);

        btnCalc.addActionListener(e -> new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() {
                int n = Integer.parseInt(txtN.getText().trim()), sum = 0;
                String primes = "";
                for (int i = 2; i < n; i++) {
                    if (isPrime(i)) {
                        primes += (primes.isEmpty() ? "" : ", ") + i;
                        sum += i;
                    }
                }
                return "N = " + n + ", cac so nguyen to nho hon n " + n + " la " + primes + " nen tong bang " + sum;
            }
            @Override
            protected void done() {
                try {
                    lblResult.setText(get());
                } catch (Exception ignored) {}
            }
        }.execute());

        setSize(480, 130);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        new Main();
    }
}
