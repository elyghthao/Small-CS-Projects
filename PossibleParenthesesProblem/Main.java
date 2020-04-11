import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void possibleParentheses(List<String> outputs, int n) {
        possibleParentheses(outputs,n,n,"");
    }
    private static void possibleParentheses(List<String> outputs, int l, int r, String s) {
        if (r==0 && l==0) {
            outputs.add(s);
        }else if (r==l && r>1) {
            s+="{";
            possibleParentheses(outputs, l-1,r,s);
        }else if(r==l && r==1){
            s+="{";
            s+="}";
            possibleParentheses(outputs,0,0,s);
        }else if (r>l && l==0) {
            for (int i = 0; i<r;i++) {
                s+="}";
            }
            possibleParentheses(outputs,0,0,s);
        }else if (r>l && l!=0) {
            possibleParentheses(outputs,l-1,r,s+="{");
            possibleParentheses(outputs,l,r-1,s.substring(0,s.length()-1)+"}");
        }
    }

    public static void main(String[] args) {
        testPossibleParentheses();
    }

    private static void testPossibleParentheses() {
        List<String> firstTest = new ArrayList<String>();
        possibleParentheses(firstTest,1);
        List<String> secondTest = new ArrayList<String>();
        possibleParentheses(secondTest,2);
        List<String> thirdTest = new ArrayList<String>();
        possibleParentheses(thirdTest,3);

        List<String> expectedFirstTest = new ArrayList<String>();
        expectedFirstTest.add("{}");
        List<String> expectedSecondTest = new ArrayList<String>();
        expectedSecondTest.add("{{}}");
        expectedSecondTest.add("{}{}");
        List<String> expectedThirdTest = new ArrayList<String>();
        expectedThirdTest.add("{{{}}}");
        expectedThirdTest.add("{{}{}}");
        expectedThirdTest.add("{{}}{}");
        expectedThirdTest.add("{}{{}}");
        expectedThirdTest.add("{}{}{}");

        if(firstTest.equals(expectedFirstTest) && secondTest.equals(expectedSecondTest) && thirdTest.equals(expectedThirdTest)) {
            System.out.println("testPossibleParentheses PASSED");
        }else {
            System.out.println("testPossibleParentheses FAILED");
        }
    }
}