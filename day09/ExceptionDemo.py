class ShortInputException(Exception):
    # 自定义异常类
    def __init__(self,length,atleast):
        self.length = length
        self.atleast = atleast
def main():
    try:
        s = input('请输入-->')
        if len(s)<3:
            raise ShortInputException(len(s),3)
    except ShortInputException as result:
        print('ShortInputException:输入的长度是%d,长度至少应是%d'%(result.length,result.atleast))
    else:
        print('没有异常发生')
main()