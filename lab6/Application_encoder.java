package com.tasks6.rle;

public class Application {
    public static void main(String[] args) {
        if (args != null && args.length == 1 && args[0] != null){
            StringBuilder result = new StringBuilder("");
            if (args[0].length() != 0) {
                int count = 1;
                char c = args[0].charAt(0);

                for (int i = 1; i < args[0].length(); i++) {
                    if (c == args[0].charAt(i)) {
                        if (count == 9) {
                            result.append(c).append(count);
                            count = 0;
                        }
                        count++;
                    } else {
                        if (count == 1) {
                            result.append(c);
                        } else {
                            result.append(c).append(count);
                        }
                        c = args[0].charAt(i);
                        count = 1;
                    }
                }
                if (count == 1){
                    result.append(c);
                } else result.append(c).append(count);
            }
            System.out.println(result);
        }
    }
}