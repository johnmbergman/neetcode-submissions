class Solution:
    delimiter = '#'

    def encode(self, strs: List[str]) -> str:
        res = []
        for s in strs:
            res.append(str(len(s)))
            res.append(self.delimiter)
            res.append(s)
        return ''.join(res)

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0

        while i < len(s):
            j = s.find(self.delimiter, i)
            size = int(s[i:j])
            x = j + 1
            y = x + size
            word = s[x:y]
            res.append(word)
            i = y
        return res