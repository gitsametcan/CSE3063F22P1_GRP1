import json
import sys

if "../logger" not in sys.path:
    sys.path.append("../logger")

import Logger


loggerInstance = Logger.Logger.getLogger("denemelog")

class DataManager():
    singleInstance = 0

    def __init__(self):
        self.__listOfLectures = list()
        self.__listOfPeople = list()
        self.__cacheList = list()
        
        metaDataFile = open("../JSON Files/MetaData.JSON")
        self.__metaData = json.load(metaDataFile)
        print(self.__metaData)


    @staticmethod
    def getInstance():
        try:
            val = singleInstance
        except NameError:
            print("FIRST TIME CREATING DATA MANAGER")
            singleInstance = DataManager()
        return singleInstance;
    
    def hello(self):
       print("hello")

    def getMetaData(self):
        return self.__metaData
    
    def logCircleDeneme(self):
        loggerInstance.info("circle!!")

