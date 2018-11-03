class Test(object):
    def __init__(self,switch):
        self.switch = switch
    def calc(self,a,b):
        try:
            return a/b
        except Exception as result:
            if self.switch:
                print("捕获开启，已经捕获到了异常，异常如下：")
                print(result)
            else:
                #重新抛出异常
                raise


a = Test(True)
a.calc(11,0)
print("==================")
a.switch=False
a.calc(11,0)