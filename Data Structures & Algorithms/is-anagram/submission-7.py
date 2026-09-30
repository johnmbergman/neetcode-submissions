class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chars = {}

        for char in s:
            if char not in chars:
                chars[char] = 1
            else:
                chars[char] = chars[char] + 1
        
        for char in t:
            if char not in chars:
                return False
            chars[char] = chars[char] - 1
        
        for _, v in chars.items():
            if v != 0:
                return False
        
        return True