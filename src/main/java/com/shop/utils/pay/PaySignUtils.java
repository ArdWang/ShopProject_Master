package com.shop.utils.pay;

import java.util.Map;

public class PaySignUtils {
    public static final String APPID = "2016091600522915";
    public static final String RSA2_PRIVATE = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAs+CjRBdbqTCKk+i5Lc9FlcWALiCPKQp8TspIVK6VHdo28yuH6T4fbrmCBYMZ3hxStW7IDy2JN75aV4FpAqHCf26hHKZE0NFX3M7i13yKzPD5jeZXgCYApp2bOKyCuEho78WWGTjUbuc2pKJAULV1FeLFjm96GHPphIufbL+toEjZ2J+lE1qDLQ0ysKZ8Yr20ZKLKZ9c5nWUOL8H9kWqArxRkuxrz/xiJWosbDmm7yP44t/xYWrXaWmOgm+hLbrUIrcuJF3VUlef+cE9EnCK/v6wgKEXUWD5C/7pDvcyTVR7BuxflzqsoB2bGjGvmAciSOOcglpN1bosKPVcqX6EBAgMBAAECggEAM1ULJLM0ycdKaAskSC+AOxXIZx5+t/q7hub6AS1dUHZOoZoNY7DgqTLFZJmEN54CF+7rV3nORKtqDahXIiX9lJC09Cd0HYBX7r5P+ePOdaHV/wLcu0uOXLYXqGBLVfvgTZJMcVhv9TKin4W8fQBzz1ZCU19DESSNnrbR5W0/aiUuSUieKHyOhc2FYAyOxufA2sjSRLY2pNT2JpL9W1TtqAAI8ZY2lHD+lbFigsw67VU96mMoQhpxd71dFfbXbEDHcDTXtOUBUQGlJZsiqpR9kXbjsRPLrwLgyYs3okln2Aa93x2HxpGl+R4qW1V884h6n2GXwHMASU6CkKcZ7emnXQKBgQDjfKQd7gJhzzh+HyiEmJZR/Y7Fb4E67v1OGpA0uS5R1QkEkBA0mRQAr9tHcnRQmVW/dl2+zZiMI3Psyc0LsFvP4UzPLWIbY8d0xwmGOQa28iXK0pp7gzvpZRE+f5Pa4y3uoNyDhzFiwHoU0b890//FRIv0XPGfLJ9DKn8loCDFGwKBgQCQ1Y1ciW4UvTNBzDRHlOT+6OAFM2hTalnv1vwdGH0PUXDpVcSRVq6JshtWEbOiH+l0LZ0JnN6+1T46Zfv32eYmeoP/23EgLT6MX8xTIXilPoJfmqLUaAXMR02PVE77omWYVfUqRb5o8RhAEWGcpuEOJYJVjcfpL14OUvXdk+MAEwKBgHh3G62hyW8kPgVD2MAG0auPe1iASM39mvQOSwkwex/okYLyCzLfUWFfvt4h9QhteqQOOWx+EWc8qvncj5G+DZCS/YrEvKxGdWwYrql+b1jX+D1ks1vuzf41gCE5jAGgxkUUuFGKeROTW9LEk+JY7pv3RancwjMJfTkjOvugxVm7AoGAE0Q1L9AgUqXwgZo2gicuZzJ3SnnSMPZ+zEbe9sfhKv58dK2yHltXkH2e4U4thS2VkpzWvQafIuefBYm3gPr9gLTfhlOcstkR7v53Yb+cGu87zJf3fSXxT4FUsfJXJ2Ys+ZzFpj/s2mzn+u3U/E++tHEM63CW3VAtxN4IUtdvZP0CgYAXbGd54ufkIrJfG+1NdJgtWRa3FVwrSi1NeXLAsCwY66IJhBiIo7FG7yd2gxBNPJwmbul5Sn4RkloIJgzxLofx+tXGEhcUQ5YGg/1i+FKe8ktmTTi3E+XhL8OrxI7Y9CEXmqrqDUaS3UPlkxIjvX1B5L7mtahmNE/A4KnZFgbq+g==";
    public static final String RSA_PRIVATE = "";

    public static String sign(String totalPrice, String orderId) {
        boolean rsa2 = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHbr7dIuYp+g3LxpYWApyb1afmNMVd5yLlA267AkHKCpe/QqtfQe5ZMkrSbqJW5Mb7MuBoVZF1TtAbaNN0Fg2V8O2I0wNHHllb9SPA2f62u0DVtBovYwS7XyaMj+YcdqYu9/A/K0hgjce8+JP8eSQMUqPKRu0jVWY8Ns6QfWboa1RPLpcjea2XW1XuagnolJVR9ouYK4T9HoFqykmDhHwdA5cSWut+kNPLFjfuiovHufgh21N4BntTURKGgoGd/5aLtb01ysJTv8OZpbtRIj5j7AdO298F1ygAsVxZon9dAhoEO/8BqkaQmsdfZTIpNNQmJuhI1nVE6dCHIXyPHoxDAgMBAAECggEAKpFljm4kt/bvlSgzDnH9tYF/R304t94peqAMkt0Pvqh7r9MNuGApwYFsQR4jCnrYDCaeoEyc7qk6AhN9uxQfawySLJpegmEIpz2y4i/ivp62rzTvsgtGdnpezHmCU1n7u/GUYtaA5lBKApyDLy0IZpMnBjIq4Rs7ihuT65hu2whDRrkzgiFuba2S67UshYpf+o2PKRGeAHl76yaAcGBlpbxJ79aq5cL6kHzQeuSUGJwyMw6L96OPuuQrpvn6fHf1VpgEoUzlIqZsZQ6WDj5G8ai0+dzEIAsEjYIBCh/J0Qw+o6pIRzPPYq/UIy8x1TG4cBry1Rcu4frEEDo6782JGQKBgQDScXLDsSROTwVZfZ9WpYI3Z+FEo63uWLM0x1Xeh+vBavuM7YepD71MIQPRDKPp+5AhiaFNeFc6MTesvMrcSvYiL6PdqKWIAkPdzNuSJ1rBwt2LBXkL6NEWPOBipKKvvbFYujyyLMDq9Qv1Id0P+QMHMf/VYK1YJygiNXGdW9yXjQKBgQCkwElND5ITMsLe9Vhsg596WZ2mncjgBvcoJIMZqCiRdVjpS63uAXA9g62ARqoolkKvC9hz26y6HLHBaozJ/kLveZGnKZrQahJV4VVDfMSTjycI7/JKi/orKShyo+aYhQFLr57JYH/Wr7AxKeRJDrtn1+lx+p2ctdb7TAD8auQXDwKBgDG2rz/fhw4gyMi9TnjvnHVuSt8mM56MwbkEJhrtzRniJg7CxjuABl4Hppkp/Ub3MLNbigl9Fk4e9mIOL3YfF0o4KuPgRUp+Dn5FONGsDlqbqC6BWnkfxNUWCIQFFJGjpFOrm08UF3bp8Ks2Fr0BPF/kxeUoc4rRpT9/lJlx7Ai5AoGATcD6V0Yr+KeSVMuR6dTM5V96CfKZpTFkYCurO+ajDtNFHQW8loFTSZTlw46WLAWOfzKl+zgH8uYr9k6lF4fKa18CoNP/3rDQ6nsoVGuEEugS0iL8RLZ/YPNRxZkY8Y6EKAZAeGX0r4vHKczNkrVDOSUrZcGTtSwUxBEAviBseX0CgYEApTt5AMujrZvJ2kUvQa3JXt5p/crYgcVHwh5JW80ngft7ZKOO3uxXCP5JGmEp/A7Pcm9HvvHSom1XozIIT8SSpjoKRXUPZtZtHn+3ygsmW8JiduF+IC4DMID5ZhbPFPItJBrp3gU44xCma+cls0X6qO3qrr62db2ILRjBTiPpwA0=".length() > 0;
        Map params = OrderInfoUtil2_0.buildOrderParamMap("2016091600522915", rsa2, totalPrice, orderId);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHbr7dIuYp+g3LxpYWApyb1afmNMVd5yLlA267AkHKCpe/QqtfQe5ZMkrSbqJW5Mb7MuBoVZF1TtAbaNN0Fg2V8O2I0wNHHllb9SPA2f62u0DVtBovYwS7XyaMj+YcdqYu9/A/K0hgjce8+JP8eSQMUqPKRu0jVWY8Ns6QfWboa1RPLpcjea2XW1XuagnolJVR9ouYK4T9HoFqykmDhHwdA5cSWut+kNPLFjfuiovHufgh21N4BntTURKGgoGd/5aLtb01ysJTv8OZpbtRIj5j7AdO298F1ygAsVxZon9dAhoEO/8BqkaQmsdfZTIpNNQmJuhI1nVE6dCHIXyPHoxDAgMBAAECggEAKpFljm4kt/bvlSgzDnH9tYF/R304t94peqAMkt0Pvqh7r9MNuGApwYFsQR4jCnrYDCaeoEyc7qk6AhN9uxQfawySLJpegmEIpz2y4i/ivp62rzTvsgtGdnpezHmCU1n7u/GUYtaA5lBKApyDLy0IZpMnBjIq4Rs7ihuT65hu2whDRrkzgiFuba2S67UshYpf+o2PKRGeAHl76yaAcGBlpbxJ79aq5cL6kHzQeuSUGJwyMw6L96OPuuQrpvn6fHf1VpgEoUzlIqZsZQ6WDj5G8ai0+dzEIAsEjYIBCh/J0Qw+o6pIRzPPYq/UIy8x1TG4cBry1Rcu4frEEDo6782JGQKBgQDScXLDsSROTwVZfZ9WpYI3Z+FEo63uWLM0x1Xeh+vBavuM7YepD71MIQPRDKPp+5AhiaFNeFc6MTesvMrcSvYiL6PdqKWIAkPdzNuSJ1rBwt2LBXkL6NEWPOBipKKvvbFYujyyLMDq9Qv1Id0P+QMHMf/VYK1YJygiNXGdW9yXjQKBgQCkwElND5ITMsLe9Vhsg596WZ2mncjgBvcoJIMZqCiRdVjpS63uAXA9g62ARqoolkKvC9hz26y6HLHBaozJ/kLveZGnKZrQahJV4VVDfMSTjycI7/JKi/orKShyo+aYhQFLr57JYH/Wr7AxKeRJDrtn1+lx+p2ctdb7TAD8auQXDwKBgDG2rz/fhw4gyMi9TnjvnHVuSt8mM56MwbkEJhrtzRniJg7CxjuABl4Hppkp/Ub3MLNbigl9Fk4e9mIOL3YfF0o4KuPgRUp+Dn5FONGsDlqbqC6BWnkfxNUWCIQFFJGjpFOrm08UF3bp8Ks2Fr0BPF/kxeUoc4rRpT9/lJlx7Ai5AoGATcD6V0Yr+KeSVMuR6dTM5V96CfKZpTFkYCurO+ajDtNFHQW8loFTSZTlw46WLAWOfzKl+zgH8uYr9k6lF4fKa18CoNP/3rDQ6nsoVGuEEugS0iL8RLZ/YPNRxZkY8Y6EKAZAeGX0r4vHKczNkrVDOSUrZcGTtSwUxBEAviBseX0CgYEApTt5AMujrZvJ2kUvQa3JXt5p/crYgcVHwh5JW80ngft7ZKOO3uxXCP5JGmEp/A7Pcm9HvvHSom1XozIIT8SSpjoKRXUPZtZtHn+3ygsmW8JiduF+IC4DMID5ZhbPFPItJBrp3gU44xCma+cls0X6qO3qrr62db2ILRjBTiPpwA0=" : "";
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        String orderInfo = orderParam + "&" + sign;

        return orderInfo;
    }
}