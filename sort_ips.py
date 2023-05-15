'''
    Given a list of ip strings sort them in ascending order
    input: 
        ["1.1.1.1","192.168.1.110","10.192.2.4","10.50.2.3","10.50.2.10","111.120.12.1","172.18.5.112"]
    output:
        1.1.1.1
        10.50.2.3
        10.50.2.10
        10.192.2.4
        111.120.12.1
        172.18.5.112
        192.168.1.110

'''

def sort_ips(ips: list):
    ip_lst = []
    # first transform each ip into a tuple of size 4, as making them in to tuples makes the sorting easier
    for ip in ips:
        s = ip.split(".")
        # cast string into int, make comparison fair, or it will make '196' smaller than '27'
        s = map(lambda x : int(x), s)
        ip_lst.append(tuple(s))

    # this will sort tuples in ascending order
    sorted_ips = sorted(ip_lst)
    res = []
    for ip in sorted_ips:
        # print(".".join(map(lambda x : str(x), ip)))
        res.append(".".join(map(lambda x : str(x), ip)))
    return res


if __name__ == "__main__":
    l = ["1.1.1.1","192.168.1.110","10.192.2.4","10.50.2.3","10.50.2.10","111.120.12.1","172.18.5.112"]
    for i in sort_ips(l):
        print(i)
    # sort_ips(l)
