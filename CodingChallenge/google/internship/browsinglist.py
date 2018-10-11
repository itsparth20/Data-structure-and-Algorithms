
def solution(L):

    def remove_extra(email):
        email = email.replace('.',"")
        email = email.split("+")[0]
        return email

    dic = {}

    def add_email(email, pure_email):
        if not pure_email in dic:
            dic[pure_email] = []
        dic[pure_email].append(email)

    for email in L:
        arr = email.split('@')
        pure_email = remove_extra(arr[0]) + "@" + arr[1]
        add_email(email, pure_email)

    count = 0
    for x in dic:
        length = len(dic[x])
        if length > 1:
            count = count + 1

    return count


L = [
    "a.b@example.com",
    "x@example.com",
    "x@exa.mple.com",
    "ab+1@example.com",
    "y@example.com",
    "y@example.com",
    "y@example.com",
]
print solution(L)
