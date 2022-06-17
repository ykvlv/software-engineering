from operations import ops

while True:
    print("Введите 2 числа через пробел")
    try:
        num_1, num_2 = map(int, input().strip().split(" "))
        break
    except ValueError:
        print(f"Только целые числа!")

while True:
    print(f"Выберите операцию: {', '.join(ops.keys())}")
    op = input()
    if op in ops:
        break
    print(f"Операции \"{op}\" нету в списке!")

print(f"{num_1} {op} {num_2} = ", end='')
print(ops.get(op)(num_1, num_2))
