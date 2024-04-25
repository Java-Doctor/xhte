package top.xhte.dsa.stack;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算器中缀表达式 计算 3+4*42+3-2 = 14
 *
 * @author XHTE
 * @create 2024/4/23
 */
public class Calculator {

    /**
     * 数字数组
     */
    private final List<Character> numList;
    /**
     * 运算符数组
     */
    private final List<Character> operatorList;
    /**
     * 数字栈
     */
    private final ArrayStack<Integer> numStack = new ArrayStack<>(10);
    /**
     * 运算符栈
     */
    private final ArrayStack<String> operatorStack = new ArrayStack<>(10);

    Calculator() {
        // 初始化
        // 创建数字集合
        Character[] numArray = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int length = numArray.length;
        String s = "[" + 1 + "," + 2 + "]";
        numList = new ArrayList<>(CollUtil.newArrayList(numArray));
        // 创建运算符集合
        Character[] operatorArray = {'+', '-', '*', '/'};
        operatorList = new ArrayList<>(CollUtil.newArrayList(operatorArray));
    }

    private Integer compute(String formula) {
        if (ObjectUtil.isEmpty(formula)) {
            throw new RuntimeException("算式不能为空！");
        }

        String temp = "";
        for (int i = 0; i < formula.toCharArray().length; i++) {
            char c = formula.toCharArray()[i];
            if (numList.contains(c)) {
                // 数字
                temp += c;
                if (i == (formula.toCharArray().length -1)) {
                    numStack.push(Integer.valueOf(temp));
                }
            } else if (operatorList.contains(c)) {
                // 字符
                if (ObjectUtil.isNotEmpty(temp)) {
                    numStack.push(Integer.valueOf(temp));
                }
                temp = String.valueOf(c);
                operatorStack.push(temp);
                temp = "";
            } else {
                // 其他字符
                throw new RuntimeException("计算式不正确！");
            }
        }
        numStack.list();
        operatorStack.list();
        // 开始计算
        while (!numStack.count().equals(1)) {
            Integer pre = Math.abs(numStack.pop());
            Integer next = numStack.pop();
            String operator = operatorStack.pop();
            if (operator.equals("+")) {
                numStack.push(pre + next);
            } else if (operator.equals("-")) {
                numStack.push(next - pre);
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Integer compute = calculator.compute("3+4-42+3-2");
        System.out.println(compute);
    }

}
