package homework.braceCheck;

public class BraceChecker {
    Stack stack;
    String text;

    //Overloading the constructor
    BraceChecker(String inputText) {
        this(inputText, 20);
    }

    BraceChecker(String inputText, int maxBraces) {
        text = inputText;
        stack = new Stack(maxBraces);
    }


    void check() {
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            switch (current) {
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    char c1 = stack.pop();
                    if (c1 == 0) {
                        System.out.println("Error: closed ] but not opened at " + i);
                        return;
                    }
                    if (c1 != '[') {
                        System.out.println("Error: opened " + c1 + " but closed ] at " + i);
                        return;
                    }
                    System.out.println("Cool! Opened [ and closed ]");
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    char c2 = stack.pop();
                    if (c2 == 0) {
                        System.out.println("Error: closed } but not opened at " + i);
                        return;
                    }
                    if (c2 != '{') {
                        System.out.println("Error: opened " + c2 + " but closed } at " + i);
                        return;
                    }
                    System.out.println("Cool! Opened { and closed }");
                    break;
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    char c3 = stack.pop();
                    if (c3 == 0) {
                        System.out.println("Error: closed ) but not opened at " + i);
                        return;
                    }
                    if (c3 != '(') {
                        System.out.println("Error: opened " + c3 + " but closed ) at " + i);
                        return;
                    }
                    System.out.println("Cool! Opened ( and closed )");
                    break;
            }
        }

        while (!stack.isStackEmpty()){
            System.out.println("Error: opened " + stack.pop() + " but not closed");
        }
    }
}
