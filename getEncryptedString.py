'''
https://leetcode.com/problems/find-the-encrypted-string/description/
https://leetcode.com/problems/find-the-encrypted-string/submissions/1457988987/

You are given a string s and an integer k. Encrypt the string using the following algorithm:

For each character c in s, replace c with the kth character after c in the string (in a cyclic manner).
Return the encrypted string.



Example 1:

Input: s = "dart", k = 3

Output: "tdar"

Explanation:

For i = 0, the 3rd character after 'd' is 't'.
For i = 1, the 3rd character after 'a' is 'd'.
For i = 2, the 3rd character after 'r' is 'a'.
For i = 3, the 3rd character after 't' is 'r'.
Example 2:

Input: s = "aaa", k = 1

Output: "aaa"

Explanation:

As all the characters are the same, the encrypted string will also be the same.
'''

class getEncryptedString:
    def getEncryptedString(self, s: str, k: int) -> str:

        resultStr: str = ""
        newIndex: int

        for index, value in enumerate(s):
            newIndex = (index + k) % len(s)
            resultStr += s[newIndex]

        return resultStr

    s: str = "aaa"
    k: int = 1
    result: str = ""

    result = getEncryptedString('', s, k)
    print(result)
