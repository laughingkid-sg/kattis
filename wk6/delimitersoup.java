import java.util.Stack;

class delimitersoup {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int q = io.getInt();
        Stack<Character> stack = new Stack<Character>();
        char arr[] = io.getLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '(':
                case '[':
                case '{':
                    stack.push(arr[i]);
                    break;
                case ')':
                    if (!stack.empty() && stack.pop() == '(')
                        break;
                    else {
                        io.print(')');
                        io.print(' ');
                        io.print(i);
                        io.close();
                        return;
                    }
                case ']':
                    if (!stack.empty() && stack.pop() == '[')
                        break;
                    else {
                        io.print(']');
                        io.print(' ');
                        io.print(i);
                        io.close();
                        return;
                    }
                case '}':
                    if (!stack.empty() && stack.pop() == '{')
                        break;
                    else {
                        io.print('}');
                        io.print(' ');
                        io.print(i);
                        io.close();
                        return;
                    }
                default:
                    break;
            }
        }
        io.print("ok so far");
        io.close();
    }
}