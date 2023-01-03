from JsonOperator import JsonOperator

class DataManagerInstance():

    def __init__(self):
        self.__listOfLectures = list()
        self.__listOfPeople = list()
        self.__cacheList = list()
        self.__jsonOperator = JsonOperator()
        
        print("FIRST TIME CREATING DATAMANAGERINSTANCE")
        
    
    def hello(self):
       print("hello")

    def getMetaData(self):
        return self.__jsonOperator.getMetaData()
    
    def logCircleDeneme(self):
        from Logger import Logger
        Logger.getLogger("denemelog").info("circle!!")

    def getNamePool(self):
        return self.__jsonOperator.getNamePool()

    def loadFiles(self):
        self.__jsonOperator.readMetaData()
        self.__jsonOperator.readNamePool()
        self.__jsonOperator.readLectures()
        self.__jsonOperator.readAdvisors()
