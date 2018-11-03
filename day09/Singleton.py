class Dog(object):
    # 创建一个私有类变量
    __instance = None
    def __new__(cls):
        if cls.__instance ==None:
            cls.__instance = object.__new__(cls)
            return cls.__instance
        else:
            return cls.__instance


# test
a = Dog()
print(id(a))
b = Dog()
print(id(b))