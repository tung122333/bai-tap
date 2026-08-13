package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("may tinh");
        f.setSize(350, 480);
        f.setLayout(new BorderLayout(5, 5));

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(350, 60));
        tf.setFont(new Font("arial", Font.BOLD, 20));
        f.add(tf, BorderLayout.NORTH);

        JPanel pBtn = new JPanel(new GridLayout(5, 4, 3, 3));
        JTextArea ta = new JTextArea();

        String[] btns = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "Clear"
        };

        for (String b : btns) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("arial", Font.BOLD, 14));
            pBtn.add(btn);

            btn.addActionListener(e -> {
                if ("0123456789.".contains(b)) {
                    tf.setText(tf.getText() + b);
                } else if ("+-*/".contains(b)) {
                    String cur = tf.getText();
                    if (!cur.isEmpty() && "+-*/".indexOf(cur.charAt(cur.length() - 1)) >= 0) {
                        tf.setText(cur.substring(0, cur.length() - 1) + b);
                    } else if (!cur.isEmpty()) {
                        tf.setText(cur + b);
                    }
                } else if ("=".equals(b)) {
                    try {
                        String expr = tf.getText();
                        double res = eval(expr);
                        String resStr = (res == (long) res) ? String.valueOf((long) res) : String.valueOf(res);
                        tf.setText(resStr);
                        ta.append(expr + " = " + resStr + "\n");
                    } catch (ArithmeticException ex) {
                        tf.setText("loi chia cho 0");
                    } catch (Exception ex) {
                        tf.setText("loi nhap!");
                    }
                } else if ("clear".equals(b)) {
                    tf.setText("");
                }
            });
        }

        f.add(pBtn, BorderLayout.CENTER);

        JPanel pHist = new JPanel(new BorderLayout());
        pHist.setBorder(new TitledBorder("lich su"));
        pHist.add(new JScrollPane(ta));
        pHist.setPreferredSize(new Dimension(350, 120));
        f.add(pHist, BorderLayout.SOUTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static double eval(String expr) throws Exception {
        if (expr.startsWith("-")) expr = "0" + expr;
        List<Double> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if ("+-*/".indexOf(c) >= 0) {
                nums.add(Double.parseDouble(sb.toString()));
                sb.setLength(0);
                ops.add(c);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) nums.add(Double.parseDouble(sb.toString()));

        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                double a = nums.get(i), b = nums.get(i + 1);
                if (op == '/' && b == 0) throw new ArithmeticException("loi chia cho 0");
                nums.set(i, op == '*' ? a * b : a / b);
                nums.remove(i + 1);
                ops.remove(i);
                i--;
            }
        }

        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            double a = nums.get(i), b = nums.get(i + 1);
            nums.set(i, op == '+' ? a + b : a - b);
            nums.remove(i + 1);
            ops.remove(i);
            i--;
        }

        return nums.get(0);
    }
}
