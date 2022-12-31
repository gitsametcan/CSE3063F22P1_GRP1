import json

class DataManagerInstance():

    def __init__(self):
        self.__listOfLectures = list()
        self.__listOfPeople = list()
        self.__cacheList = list()
        metaDataFile = open("JSON Files/MetaData.JSON")
        self.__metaData = json.load(metaDataFile)
        print(self.__metaData)
    
    def hello(self):
       print("hello")

    def getMetaData(self):
        return self.__metaData
    
    def logCircleDeneme(self):
        import Logger
        Logger.Logger.getLogger("denemelog").info("circle!!")