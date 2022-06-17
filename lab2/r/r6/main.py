while True:
    print("Введите 2 числа через пробел")
    try:
        num_1, num_2 = map(int, input().strip().split(" "))
        break
    except ValueError:
        print(f"Только целые числа!")

print(num_1, num_2)
