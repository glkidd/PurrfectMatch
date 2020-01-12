import junit.framework.TestCase;
import org.junit.Test;
​
import java.util.ArrayList;
​
public class GreetingKataTestsCopy extends TestCase {
​
    public static String output;
​
    public String greet(String ... name) {
        if (name == null) {
            return "Hello, my friend.";
        }
​
        ArrayList<String> uppers = new ArrayList<String>();
        ArrayList<String> lowers = new ArrayList<String>();
​
        for (int i = 0; i < name.length; i++) {
            if (isUpper(name[i])) {
                if (name[i].contains(",")) {
                    if (name[i].charAt(0) == '\"' || name[i].charAt(name[i].length()-1) == '\"') {
                        name[i] = name[i].replaceAll("\"", "");
                        uppers.add(name[i]);
                    }
                    else {
                        String[] values = name[i].split("\\s*, \\s*");
                        for (String s : values) {
                            uppers.add(s);
                        }
                    }
                }
                else {
                    uppers.add(name[i]);
                }
            }
            else {
                if (name[i].contains(",")) {
                    if (name[i].charAt(0) == '\"' || name[i].charAt(name[i].length()-1) == '\"') {
                        name[i] = name[i].replaceAll("\"", "");
                        lowers.add(name[i]);
                    }
                    else {
                        String[] values = name[i].split("\\s*, \\s*");
                        for (String s : values) {
                            lowers.add(s);
                        }
                    }
                }
                else {
                    lowers.add(name[i]);
                }
            }
        }
​
        if (lowers.size() >= 1) {
            if (lowers.size() == 1) {
                output = "Hello, " + name[0] + ".";
            }
            else if (lowers.size() == 2) {
                output = "Hello, " + lowers.get(0) + " and " + lowers.get(1) + ".";
            }
            else {
                output = "Hello, ";
                int j;
                for (j = 0; j < lowers.size() - 1; j++) {
                    output = output + lowers.get(j) + ", ";
                }
                output = output + "and " + lowers.get(j) + ".";
            }
​
            if (uppers.size() >= 1) {
                if (uppers.size() == 1) {
                    output = output + " AND HELLO " + uppers.get(0) + "!";
                }
                else if (uppers.size() == 2) {
                    output = output + " AND HELLO " + uppers.get(0) + " AND " + uppers.get(1) + "!";
                }
                else {
                    output = output + " AND HELLO ";
                    int k;
                    for (k = 0; k < uppers.size(); k++) {
                        output = output + uppers.get(k) + ", ";
                    }
                    output = output + "AND " + lowers.get(k) + "!";
                }
            }
        }
        else if (uppers.size() >= 1) {
            if (uppers.size() == 1) {
                output = "HELLO " + uppers.get(0) + "!";
            }
            else if (uppers.size() == 2) {
                output = "HELLO " + uppers.get(0) + " AND " + uppers.get(1) + "!";
            }
            else {
                output = "HELLO ";
                int k;
                for (k = 0; k < uppers.size(); k++) {
                    output = output + uppers.get(k) + ", ";
                }
                output = output + "AND " + uppers.get(k) + "!";
            }
        }
​
        return output;
    }
​
    public boolean isUpper(String str) {
        boolean upper = false;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper = true;
            } else {
                upper = false;
            }
        }
        return upper;
    }
​
    @Test
    public void test1() {
        assert("Hello, Bob.".equals(greet("Bob")));
    }
​
    @Test
    public void test2() {
        assert("Hello, my friend.".equals(greet(null)));
    }
​
    @Test
    public void test3() {
        assert("HELLO JERRY!".equals(greet("JERRY")));
    }
​
    @Test
    public void test4() {
        String[] input = new String[]{"Jill", "Jane"};
        assert("Hello, Jill and Jane.".equals(greet(input)));
    }
​
    @Test
    public void test5() {
        String[] input = new String[]{"Amy", "Brian", "Charlotte"};
        assert("Hello, Amy, Brian, and Charlotte.".equals(greet(input)));
    }
​
    @Test
    public void test6() {
        String[] input = new String[]{"Amy", "BRIAN", "Charlotte"};
        assert("Hello, Amy and Charlotte. AND HELLO BRIAN!".equals(greet(input)));
    }
​
    @Test
    public void test7() {
        String[] input = new String[]{"Bob", "Charlie, Dianne"};
        assert("Hello, Bob, Charlie, and Dianne.".equals(greet(input)));
    }
​
    @Test
    public void test8() {
        String[] input = new String[]{"Bob", "\"Charlie, Dianne\""};
        assert("Hello, Bob and Charlie, Dianne.".equals(greet(input)));
    }
​
​
​
}