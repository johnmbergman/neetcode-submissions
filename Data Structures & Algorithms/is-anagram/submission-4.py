class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counts = [0] * 26
        for ch in s:
            counts[ord(ch) - ord('a')] += 1
        for ch in t:
            counts[ord(ch) - ord('a')] -= 1
        for count in counts:
            if count != 0:
                return False
        return True