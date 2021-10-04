import java.util.Arrays;
import java.util.Deque;  
import java.util.ArrayDeque;


class integerlists {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int q = io.getInt();
        Deque<Integer> queue = new ArrayDeque<Integer>();;
        char[] cmd; int[] nums;
        boolean reverse; int size; String input;
        for (int k = 0; k < q; k++) {
            reverse = false; queue.clear();
            cmd = io.getLine().toCharArray();
            size = io.getInt();
            input = io.getLine();
            input = input.substring(1, input.length()-1);
            if (size > 0) {
                nums = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
                for (int i = 0; i < size; i++) {
                    queue.offer(nums[i]);
                }
            }
            size = 0;
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == 'R') {
                    reverse = !reverse;
                } else {
                    if (queue.isEmpty()) {
                        size = 1;
                        break;
                    }               
                    if (!reverse) {
                        queue.pollFirst();
                    } else {
                        queue.pollLast();
                    }
                }
            }
            if (size == 1)
                io.println("error");
            else {
                if (queue.size() == 0)
                    reverse = false;
                if (reverse) {
                    io.print('[');
                    while (queue.size() != 1) {
                        io.print(queue.pollLast());
                        io.print(',');
                    }
                    io.print(queue.pollLast());
                    io.println(']');
                } else {
                input = queue.toString();
                io.println(input.replaceAll("\\s+",""));
                }
            }

        }
        io.close();
    }
}

/*
 char[] cmd = io.getLine().toCharArray();
            io.getLine();
            String input = io.getLine();
            String[] nums = input.substring(1, input.length()-1).split(",");
            boolean err = false;
            for (int i = 0; i < cmd.length; i++) {
                try {
                    if (cmd[i] == 'R') {
                        reverseArray(nums);
                    } else {
                        nums[0] = String.valueOf(Integer.parseInt(nums[0]));
                        nums = Arrays.copyOfRange(nums, 1, nums.length);
                    }
                }
                catch (Exception e) {
                    err = true;
                    break;
                }
            }
            if (err) 
                io.println("error");
            else {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i].trim();
                }
                io.println(Arrays.toString(nums).replaceAll(" ", ""));
            }
*/