class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ''
        for s in strs:
            encoded_str += str(len(s)) + ':' + s
        return encoded_str

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            j = s.find(':', i)
            size = int(s[i:j])
            x = j + 1
            y = x + size
            word = s[x:y]
            res.append(word)
            i = y
        return res