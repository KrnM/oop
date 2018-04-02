package com.tasks6.rle_decoder;

public class Application {
    public static void main(String[] args) {
        if (args != null && args.length == 1 && args[0] != null) {
            StringBuilder result = new StringBuilder("");
            if (args[0].length() != 0 && !Character.isDigit(args[0].charAt(0))) {
                char c = args[0].charAt(0);
                int count = 0;
                for (int i = 0; i < args[0].length() - 1; i++){
                    if ((Character.isDigit(args[0].charAt(i)) && Character.isDigit(args[0].charAt(i + 1)))
                            || (!Character.isDigit(args[0].charAt(i)) && !Character.isDigit(args[0].charAt(i + 1))
                            && c == args[0].charAt(i + 1))
                            || (i < args[0].length() - 2 && (!Character.isDigit(args[0].charAt(i)) && Character.isDigit(args[0].charAt(i + 1))
                            && !Character.isDigit(args[0].charAt(i + 2)) && args[0].charAt(i) == args[0].charAt(i + 2)
                            && Character.getNumericValue(args[0].charAt(i + 1)) != 9 ))) {
                        count = 1;
                        break;
                    }
                    if (!Character.isDigit(args[0].charAt(i)) && !Character.isDigit(args[0].charAt(i + 1))
                            && c != args[0].charAt(i + 1)) {
                        result.append(c);
                        c = args[0].charAt(i + 1);
                    }
                    if (Character.isDigit(args[0].charAt(i + 1))) {
                        int size = Character.getNumericValue(args[0].charAt(i + 1));
                        for (int j = 0; j < size; j++) {
                            result.append(c);
                        }
                    }else c = args[0].charAt(i + 1);
                }
                if (!Character.isDigit(args[0].charAt(args[0].length() - 1))) {
                    result.append(c);
                }
                if (count == 1){
                    result.replace(0, result.length(), "");
                }
            }
            System.out.println(result);
        }
    }
}