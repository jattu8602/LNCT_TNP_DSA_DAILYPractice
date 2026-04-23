class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hmap = {')':'(', ']':'[', '}':'{'}
        if len(s) % 2 != 0:
            return False
        for i in s:
            if i not in hmap:
                stack.append(i)
            else:
                if not stack:
                    return False
                if hmap[i] == stack[-1]:
                    stack.pop()
                else:
                    return False
        return len(stack)==0