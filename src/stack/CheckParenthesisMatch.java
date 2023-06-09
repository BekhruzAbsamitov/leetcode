package stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class CheckParenthesisMatch {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put('}', '{');
        matchingParenMap.put(']', '[');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public static boolean hasMatchingParens(String input) {
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Add to the stack for an opening paren.
            if (openingParenSet.contains(ch)) {
                parenStack.push(ch);
            }
            if (matchingParenMap.containsKey(ch)) {
                Character lastParen = parenStack.pop();
                if (!Objects.equals(lastParen, matchingParenMap.get(ch))) {
                    return false;
                }
            }
        }
        return parenStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(hasMatchingParens("{}{}{}{(())})"));
    }

}
