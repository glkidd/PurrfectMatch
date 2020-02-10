import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class assignment {
    @Test
    public void test1() {
        assert("Hello, Michelle.".equals(greet("Michelle")));
    }

    @Test
    public void test2() {
        assert("Hello, my friend.".equals(greet(null)));
    }
    
    @Test
    public void test3() {
        assert("HELLO, JOE!".equals(greet("JOE")));
    }
    
    @Test
    public void test4() {
        assert("Hello, Jill and Jane.".equals(greet("Jill", "Jane")));
    }
    
    @Test
    public void test5() {
        assert("Hello, Bob, Charlie, and Dianne.".equals(greet("Bob", "Charlie", "Dianne")));
    }
    
    @Test
    public void test6() {
        assert("Hello, Amy and Charlotte. AND HELLO, BRIAN!".equals(greet("Amy", "BRIAN", "Charlotte")));
    }
    
    @Test
    public void test7() {
        assert("Hello, Bob, Charlie, and Dianne.".equals(greet("Bob", "Charlie, Dianne")));
    }
    
    @Test
    public void test8() {
        assert("Hello, Bob and Charlie, Dianne.".equals(greet("Bob", "\"Charlie, Dianne\"")));
    }
    
    private static String combine(ArrayList<String> names) {
        String last = names.remove(names.size() - 1);
        String result = String.join(", ", names);
        if (names.size() == 0) {
            return "Hello, " + last;
        }
        else if (names.size() == 1){
            return "Hello, " + result + " and " + last;
        }
        else {
            return "Hello, " + result + ", and " + last;
        }
    }
    
    private static String greet(String ...who) {
        String message = "";
        ArrayList<String> lnames = new ArrayList<String>();
        ArrayList<String> cnames = new ArrayList<String>();
        if (who == null || who.length == 0) {
            return "Hello, my friend.";
        }
        for (String name : who) {
            if (name.charAt(0) == '"' && name.charAt(name.length() - 1) == '"') {
                if (name.toUpperCase().equals(name)) {
                    cnames.add(name.substring(1, name.length() - 1));
                }
                else {
                    lnames.add(name.substring(1, name.length() - 1));
                }
                continue;
            }
            for (String subName : name.split(",\\s?")) {
                if (subName.toUpperCase().equals(subName)) {
                    cnames.add(subName);
                }
                else {
                    lnames.add(subName);
                }
            }
        }
        if (lnames.size() > 0) {
            message += combine(lnames) + ".";
        }
        if (cnames.size() > 0) {
            if (message.length() > 0) {
                message += " AND ";
            }
            message += combine(cnames).toUpperCase() + "!";
        }
                
        return message;
        
    }

}
