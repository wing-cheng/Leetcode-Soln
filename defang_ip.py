'''
    a function that defangs a given ipv4 address
    input: "0.0.0.0"
    output: "0[.]0[.]0[.]0"
'''
from re import search


def defang_ip(ip: str) -> str:
    # if input string is an invalid ip address, then raise an exception
    if search("^[0-9]{1,3}(\.[0-9]{1,3}){3}$", ip) is None:
        print("IP address is invalid.")
        return

    return ip.replace(".", "[.]")

def defang_ip2(ip: str) -> str:
    
    if search("^[0-9]{1,3}(\.[0-9]{1,3}){3}$", ip) is None:
        print("IP address is invalid.")
        return

    res = ""
    for c in ip:
        if c == ".":
            res += "[.]"
        else:
            res += c

    return res


print(f'defang 0.0.0.0: {defang_ip("0.0.0.0")}')
print(f'defang 0.0.0.0.0: {defang_ip("0.0.0.0.0")}')
print(f'defang 0.0.0.0: {defang_ip2("0.0.0.0")}')
print(f'defang 0.0.0.0.0: {defang_ip2("0.0.0.0.0")}')

