class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # Assumption: characters must be a-z

        # Lengths must match
        if (len(s) != len(t)):
            return False

        a_ord = ord('a')
        cache = [0]*26
        for c in s:
            cache[ord(c) - a_ord] += 1
        for c in t:
            cache[ord(c) - a_ord] -= 1
        for i in cache:
            if i != 0:
                return False
        return True