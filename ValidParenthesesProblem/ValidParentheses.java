public class ValidParentheses {
    public static boolean isValid(String str) {
        // homework
        ArrayStack a = new ArrayStack(str.length());
        for (int i = 0; i < str.length();i++) {

            switch(str.charAt(i)) {//switch statement checking the value
                case '('://if char is open push it in the array
                    a.push((int) '(');
                    break;

                case '{':
                    a.push((int) '{');
                    break;

                case '[':
                    a.push((int) '[');
                    break;



                case ')'://if char is closed, peek if top value is corresponding char, if not return false
                    if (a.peek().getData() == (int) '(') {
                        a.pop();
                    }else {
                        return false;
                    }
                    break;

                case '}':
                    if (a.peek().getData() == (int) '{') {
                        a.pop();
                    }else {
                        return false;
                    }
                    break;

                case ']':
                    if (a.peek().getData() == (int) '[') {
                        a.pop();
                    }else {
                        return false;
                    }
                    break;

            }
        }
        if (a.size() != 0) {
            return false;
        }
        return true; // place holder
    }

    public static boolean testIsValid() {
        String[] inputs = {"(}","{}()", ")[](", "()(){([])}", "() {{)}}", /**/"()({{{}}})[]{}()", "((()", "()()()()()()()(){{{}{}{]][][]", "()({[]}){}()[]" };
        boolean[] expected = {false, true, false, true, /**/false, true, false, false, true};

        for (int i = 0; i<inputs.length;i++) {
            if (isValid(inputs[i]) != expected[i]) {
                System.out.println("Test " + i + "Failed: " + "expected " + expected[i]+ "    actual " + isValid(inputs[i]));
                return false;
            }
        }
        return true; // place holder
    }

}