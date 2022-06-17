from op import ops

print("Введите 2 числа")
num_1 = int(input())
num_2 = int(input())

print(f"Выберите операцию: {ops}")
op = input()
print(ops.get(op)(num_1, num_2))
